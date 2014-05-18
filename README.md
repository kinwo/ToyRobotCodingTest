h3. A simple Java Robot Test

Author: Henry Chan
IDE: Intellij CE 13.1.2
Requirements: Java JDK 1.7
Usage: java -cp classes toyrobot.RobotApp [File path of the command file]

Fixture:
SingleTest.txt
TestCommands.txt
InvalidCommands.txt

E.g
java -cp classes toyrobot.RobotApp SingleTest.txt
java -cp classes toyrobot.RobotApp TestCommands.txt
java -cp classes toyrobot.RobotApp InvalidCommands.txt


Notes:
* Input through line-separated commands in file.
* Test Driver Development - JUnit RobotTest.java
* Lightweight Java
* Simple RobotDirection state machine using Enum
