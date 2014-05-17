package toyrobot;

/**
 * A immutable state class for tracking Robot position and facing direction
 *
 * Created by henry on 17/05/2014.
 */
public class RobotState {

    private int xPos;
    private int yPos;
    private RobotDirection direction;

    /**
     * UNKNOWN Robot State
     */
    public static final RobotState UNKNOWN = new RobotState(-1, -1, RobotDirection.UNDEFINED);

    public RobotState(int xPos, int yPos, RobotDirection direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    /**
     * Helper static method for creating new state
     *
     * @param xPos X Position
     * @param yPos Y Position
     * @param direction Facing direction
     * @return A new instance of RobotState
     */
    public static RobotState newState(int xPos, int yPos, RobotDirection direction) {
        return new RobotState(xPos, yPos, direction);
    }

    /**
     * Helper method to create new state using existing x and y but turn left
     *
     * @return A new instance of RobotState
     */
    public RobotState turnLeft() {
        return new RobotState(xPos, yPos, direction.left());
    }

    /**
     * Helper method to create new state using existing x and y but turn left
     *
     * @return A new instance of RobotState
     */
    public RobotState turnRight() {
        return new RobotState(xPos, yPos, direction.right());
    }

    public int xPos() {
        return xPos;
    }

    public int yPos() {
        return yPos;
    }

    public RobotDirection direction() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotState that = (RobotState) o;

        if (xPos != that.xPos) return false;
        if (yPos != that.yPos) return false;
        if (direction != that.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xPos;
        result = 31 * result + yPos;
        result = 31 * result + direction.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append(xPos);
        report.append(",");
        report.append(yPos);
        report.append(",");
        report.append(direction);

        return report.toString();
    }
}
