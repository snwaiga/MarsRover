public class MarsRover {

    int gridWidth,gridLength;

    public MarsRover(int x, int y ){

        //setting the length and width of the grid
        gridWidth=x;
        gridLength=y;
    }
    //method moves the Robot and returns a String that details it final position
    public String moveRobot(Robot robot){

        int rX= robot.getStartingX();
        int rY= robot.getStartingY();

        char orientation= robot.getStartingOrientation();

        if(rX>gridWidth || rY>gridLength){
            return "("+rX+", "+rY+ ", "+orientation + ") LOST";

        }

        for(char c: robot.getInstructions().toCharArray()){

            if(c=='L'){
                //here we change the orientation
                if(orientation=='N')
                    orientation='W';

                else if(orientation=='W')
                    orientation='S';

                else if(orientation=='S')
                    orientation='W';

                else if(orientation=='E')
                    orientation='N';
            }
            else if(c=='R'){
                if(orientation=='N')
                    orientation='E';

                else if(orientation=='W')
                    orientation='S';

                else if(orientation=='S')
                    orientation='W';

                else if(orientation=='E')
                    orientation='S';
            }
            //here before we change the coordinates we check if the robot is on the edge of the grid edges and if moving would
            //push it off the grid we return the coordinates and label it as LOST
            else if(c=='F'){

                if(orientation=='N'){
                    if(rY>gridLength)
                        return "("+rX+", "+rY+ ", "+orientation + ") LOST";
                    rY+=1;
                }
                else if (orientation=='S'){
                    if(rY==0)
                        return "("+rX+", "+rY+ ", "+orientation + ") LOST";
                    rY-=1;
                }
                else if (orientation=='W') {
                    if(rX==0)
                        return "("+rX+", "+rY+ ", "+orientation + ") LOST";
                    rX-=1;
                }
                else if(orientation=='E'){
                    if(rX>gridWidth)
                        return "("+rX+", "+rY+ ", "+orientation + ") LOST";
                    rX+=1;
                }
            }
        }
        return "("+rX+ ", "+ rY+ ", "+ orientation+")";
    }
}
