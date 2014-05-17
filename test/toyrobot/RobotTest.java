package toyrobot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static toyrobot.RobotDirection.*;
import static toyrobot.RobotState.*;
import static toyrobot.RobotState.UNKNOWN;

import toyrobot.Robot;

/**
 * A simple Unit Test for Robot class
 *
 * Created by henry on 17/05/2014.
 */
public class RobotTest {

    private Robot robot;

// setup
    @Before
    public void setUp() {
        // Robot
        robot = new Robot(new Table(5, 5));
    }

// teardown
    @After
    public void tearDown() {
        robot = null;
    }


// Single command
    @Test
    public void testPlace() {
        robot.place(0, 0, NORTH);

        assertEquals(newState(0, 0, NORTH), robot.state());
    }

    @Test
    public void testReport() {
        robot.place(1, 2, SOUTH);

        assertEquals("1,2,SOUTH", robot.report());
    }

    @Test
    public void testMove() {
        robot.place(3, 4, EAST);
        robot.move();

        assertEquals(newState(4, 4, EAST), robot.state());
    }

    @Test
    public void testLeft() {
        robot.place(3, 2, WEST);
        robot.left();

        assertEquals(newState(3, 2, SOUTH), robot.state());
    }

    @Test
    public void testRight() {
        robot.place(0, 4, NORTH);
        robot.right();

        assertEquals(newState(0, 4, EAST), robot.state());
    }

// Multiple commands
    @Test
    public void testMultiPlaces() {
        robot.place(0, 0, WEST);
        robot.place(2, 3, EAST);
        robot.place(3, 1, NORTH);

        assertEquals(newState(3, 1, NORTH), robot.state());
    }

    @Test
    public void testIgnoreAllUntilFirstPlace() {
        robot.right();
        robot.move();
        robot.left();
        robot.place(2, 1, EAST);

        assertEquals(newState(2, 1, EAST), robot.state());
    }

    @Test
    public void testMoveThenLeft() {
        robot.place(1, 1, NORTH);
        robot.move();
        robot.left();

        assertEquals(newState(1, 2, WEST), robot.state());
    }

    @Test
    public void testMoveThenRight() {
        robot.place(2, 4, SOUTH);
        robot.move();
        robot.right();

        assertEquals(newState(2, 3, WEST), robot.state());
    }

    @Test
    public void testLeftThenMove() {
        robot.place(3, 1, EAST);
        robot.left();
        robot.move();

        assertEquals(newState(3, 2, NORTH), robot.state());
    }

    @Test
    public void testRightThenMove() {
        robot.place(3, 1, EAST);
        robot.left();
        robot.move();

        assertEquals(newState(3, 2, NORTH), robot.state());
    }

    @Test
    public void testLeftThenRightThenMove() {
        robot.place(1, 3, SOUTH);
        robot.left();
        robot.move();

        assertEquals(newState(2, 3, EAST), robot.state());
    }

    @Test
    public void testMultiMoves() {
        robot.place(3, 1, WEST);
        robot.move();
        robot.move();
        robot.move();

        assertEquals(newState(0, 1, WEST), robot.state());
    }

    // Negative tests
    @Test
    public void testInvalidPlace() {
        robot.place(6, 8, WEST);
        robot.move();
        robot.left();
        robot.move();

        assertEquals(UNKNOWN, robot.state());
    }

    @Test
    public void testInvalidPlaceReport() {
        robot.place(-6, -8, WEST);
        robot.move();
        robot.left();
        robot.move();

        // empty string
        assertEquals("", robot.report());
    }

    @Test
    public void testInvalidMoveBeyondWestBound() {
        robot.place(2, 2, WEST);
        robot.move();
        robot.move();
        robot.move();

        assertEquals(newState(0, 2, WEST), robot.state());
    }

    @Test
    public void testInvalidMoveBeyondEastBound() {
        robot.place(3, 3, EAST);
        robot.move();
        robot.move();
        robot.move();
        robot.move();

        assertEquals(newState(4, 3, EAST), robot.state());
    }

    @Test
    public void testInvalidMoveBeyondNorthBound() {
        robot.place(0, 0, EAST);
        robot.left();
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        robot.move();

        assertEquals(newState(0, 4, NORTH), robot.state());
    }

    @Test
    public void testInvalidMoveBeyondSouthBound() {
        robot.place(4, 4, WEST);
        robot.move();
        robot.left();
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        robot.move();

        assertEquals(newState(3, 0, SOUTH), robot.state());
    }

}
