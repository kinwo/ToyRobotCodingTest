package toyrobot;

/**
 * Created by henry on 17/05/2014.
 */
public enum RobotDirection {

    NORTH("NORTH") {
        @Override
        public RobotDirection left() {
            return WEST;
        }

        @Override
        public RobotDirection right() {
            return EAST;
        }
    },
    SOUTH("SOUTH") {
        @Override
        public RobotDirection left() {
            return EAST;
        }

        @Override
        public RobotDirection right() {
            return WEST;
        }
    },
    EAST("EAST") {
        @Override
        public RobotDirection left() {
            return NORTH;
        }

        @Override
        public RobotDirection right() {
            return SOUTH;
        }
    },
    WEST("WEST") {
        @Override
        public RobotDirection left() {
            return SOUTH;
        }

        @Override
        public RobotDirection right() {
            return NORTH;
        }
    },
    UNDEFINED("UNDEFINED") {
        @Override
        public RobotDirection left() {
            return UNDEFINED;
        }

        @Override
        public RobotDirection right() {
            return UNDEFINED;
        }
    };


    private String direction;

    RobotDirection(String direction) {
        this.direction = direction;
    }

    public abstract RobotDirection left();
    public abstract RobotDirection right();
}
