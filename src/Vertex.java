public class Vertex {
    // Out represents the outgoing cell, the cell being left behind.
    private int outX, outY, outWall;
    // In represents the ingoing cell, the cell being entered.
    private int inX, inY, inWall;

    Vertex(int outX, int outY, int ouWall, int inX, int inY, int inWall) {
        this.outX = outX;
        this.outY = outY;
        this.outWall = outWall;
        this.inX = inX;
        this.inY = inY;
        this.inWall = inWall;
    }

    public int getOutX() {
        return outX;
    }

    public int getOutY() {
        return outY;
    }

    public int getOutWall() {
        return outWall;
    }

    public int getInX() {
        return inX;
    }

    public int getInY() {
        return inY;
    }

    public int getInWall() {
        return inWall;
    }
}
