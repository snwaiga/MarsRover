public class Robot{

    int startingX;
    int startingY;
    char startingOrientation;
    String instructions;

    public Robot(int x,int y, char orientation, String instructions){
        startingX=x;
        startingY=y;
        startingOrientation=orientation;
        this.instructions=instructions;
    }
    public int getStartingX() {
        return startingX;
    }

    public int getStartingY() {
        return startingY;
    }

    public char getStartingOrientation() {
        return startingOrientation;
    }

    public String getInstructions() {
        return instructions;
    }
}