package toyrobot;

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
        return state.toString();
    }
}
