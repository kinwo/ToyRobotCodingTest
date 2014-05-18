package toyrobot;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Robot Main App for running in command line.
 *
 * Created by henry on 17/05/2014.
 */
public class RobotApp {

    public static void main(String[] args) {
        // validate args
        if (args.length != 1) {
            System.out.println("Usage: RobotApp [File path of the command file]");
            System.exit(0);
        }

        String fileName = args[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // create Robot
            Robot robot = new Robot(new Table(5, 5));
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
                String output;
                if (!(output = robot.runCommand(line)).equals("")) {
                    System.out.println("Output: " + output);
                }
            }

        } catch (Exception ioe) {
            System.out.println("Exception is found when loading file: " + fileName + "\n\n" + ioe.toString());
        }
    }

}
