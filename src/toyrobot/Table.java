package toyrobot;

import static toyrobot.RobotState.newState;

/**
 * A simple Table for Robot to act upon.
 * It also validates movement.
 *
 * Created by henry on 17/05/2014.
 */
public class Table {

    private int numRows;
    private int numCols;

    public Table(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
    }

    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < numRows) && (y >= 0 && y < numCols);
    }

    public RobotState move(RobotState state) {
        int newX = state.xPos();
        int newY = state.yPos();

        switch (state.direction()) {
            case NORTH: {
                newY++;
                break;
            }
            case SOUTH: {
                newY--;
                break;
            }
            case EAST: {
                newX++;
                break;
            }
            case WEST: {
                newX--;
                break;
            }
            default: {
                break;
            }
        }

        RobotState newState;
        if (isValidPosition(newX, newY)) {
            newState = newState(newX, newY, state.direction());
        } else {
            newState = state;
        }

        return newState;
    }
}
