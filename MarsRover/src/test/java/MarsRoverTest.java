import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class MarsRoverTest {

    MarsRover marsRover;
    Robot robot;
    Robot robot1;
    Robot robot2;
    Robot robot3;
    Robot robot4;

    @BeforeEach
    public void setup() throws Exception {
        marsRover = new MarsRover(4,8);
        //testing how the code handles a robot that is initially off the grid
        robot= new Robot(2,9,'E',"LFRFF");

        robot1= new Robot(2,3,'E',"LFRFF");
        robot2 =new Robot(0,2,'N',"FFLFRFF");
        robot3 = new Robot(2, 3, 'N', "FLLFR");
        robot4= new Robot(1,0,'S',"FFRLF");
    }

    @Test
    void monitorBounds() {
        Assertions.assertEquals("("+robot.getStartingX()+", "+ robot.getStartingY()+", "+robot.getStartingOrientation()+ ") LOST",marsRover.moveRobot(robot));
    }

    @Test
    void isInCorrectPosition() {
        Assertions.assertEquals("(4, 4, E)",marsRover.moveRobot(robot1));
        Assertions.assertEquals("(0, 4, W) LOST",marsRover.moveRobot(robot2));
        Assertions.assertEquals("(2, 3, W)",marsRover.moveRobot(robot3));
        Assertions.assertEquals("(1, 0, S) LOST",marsRover.moveRobot(robot4));
    }
}