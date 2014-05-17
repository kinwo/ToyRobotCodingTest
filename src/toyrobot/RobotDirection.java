package toyrobot;

/**
 * Created by henry on 17/05/2014.
 */
public enum RobotDirection {

    NORTH("NORTH"),
    SOUTH("SOUTH"),
    EAST("EAST"),
    WEST("WEST"),
    UNDEFINED("UNDEFINED");


    private String direction;

    RobotDirection(String direction) {
        this.direction = direction;
    }
}
