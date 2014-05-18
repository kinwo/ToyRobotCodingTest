package toyrobot;

import java.util.Scanner;

import static toyrobot.RobotState.*;

/**
 * Created by henry on 17/05/2014.
 */
public class Robot {

    private RobotState state;
    private Table table;

    public Robot(Table table) {
        this.state = UNKNOWN;
        this.table = table;
    }

    /**
     * Get a read-only state of the Robot
     * @return Immutable Robot State instance
     */
    public RobotState state() {
        return state;
    }

    /**
     * Parse and run the command string.
     *
     * If the string is invalid, nothing would happen.
     *
     * @param command Non-null command string
     * @return Output string of the command if there is any, else empty string
     */
    public String runCommand(String command) {
        String output = "";
        String action = "";

        Scanner sc = new Scanner(command);
        sc.useDelimiter(" ");

        if (sc.hasNext()) {
            action = sc.next();
        }

        switch (action) {
            case "PLACE": {
                if (sc.hasNext()) {
                    parsePlaceAndRun(sc.next());
                }
                break;
            }
            case "MOVE": {
                move();
                break;
            }
            case "LEFT": {
                left();
                break;
            }
            case "RIGHT": {
                right();
                break;
            }
            case "REPORT": {
                output = report();
                break;
            }
            default: {
                // do nothing
            }

        }

        return output;
    }

    /**
     * PLACE command argument parser.
     *
     * If arguments are valid, run the command straight away.
     *
     * @param arguments Arguments string
     */
    private void parsePlaceAndRun(String arguments) {
        int xPos;
        int yPos;

        Scanner placeSC = new Scanner(arguments);
        placeSC.useDelimiter(",");

        // parse xPos
        if (!placeSC.hasNextInt()) {
            return;
        }
        xPos = placeSC.nextInt();

        // parse yPos
        if (!placeSC.hasNextInt()) {
            return;
        }
        yPos = placeSC.nextInt();

        // parse direction
        if (!placeSC.hasNext()) {
            return;
        }
        String directionString = placeSC.next().trim();
        if (!RobotDirection.isValid(directionString)) {
            return;
        }
        RobotDirection direction = RobotDirection.valueOf(directionString);

        // run place command
        place(xPos, yPos, direction);
    }

    public void place(int x, int y, RobotDirection facing) {
        if (table.isValidPosition(x, y)) {
            state = newState(x, y, facing);
        }
    }

    public void move() {
        state = table.move(state);
    }

    public void left() {
        state = state.turnLeft();
    }

    public void right() {
        state = state.turnRight();
    }

    public String report() {
        return state.equals(UNKNOWN)? "" : state.toString();
    }
}
