package toyrobot;

/**
 * Created by henry on 17/05/2014.
 */
public class Robot {

    private RobotState state;

    /**
     * Get a read-only state of the Robot
     * @return Immutable Robot State instance
     */
    public RobotState state() {
        return state;
    }

    public void place(int x, int y, RobotDirection facing) {

    }

    public void move() {

    }

    public void left() {

    }

    public void right() {

    }

    public String report() {
        return "implement me";
    }
}
