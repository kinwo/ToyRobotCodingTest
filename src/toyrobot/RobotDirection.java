package toyrobot;

/**
 * Created by henry on 17/05/2014.
 */
public enum RobotDirection {

    NORTH {
        @Override
        public RobotDirection left() {
            return WEST;
        }

        @Override
        public RobotDirection right() {
            return EAST;
        }
    },
    SOUTH {
        @Override
        public RobotDirection left() {
            return EAST;
        }

        @Override
        public RobotDirection right() {
            return WEST;
        }
    },
    EAST {
        @Override
        public RobotDirection left() {
            return NORTH;
        }

        @Override
        public RobotDirection right() {
            return SOUTH;
        }
    },
    WEST {
        @Override
        public RobotDirection left() {
            return SOUTH;
        }

        @Override
        public RobotDirection right() {
            return NORTH;
        }
    },
    UNDEFINED {
        @Override
        public RobotDirection left() {
            return UNDEFINED;
        }

        @Override
        public RobotDirection right() {
            return UNDEFINED;
        }
    };

    public abstract RobotDirection left();
    public abstract RobotDirection right();

    public static boolean isValid(String directionString) {
        boolean valid = false;

        try {
            valueOf(directionString);
            valid = true;
        } catch (IllegalArgumentException e) {
            valid = false;
        }

        return valid;
    }
}
