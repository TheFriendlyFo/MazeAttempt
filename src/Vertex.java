public class Vertex {
    // Out represents the outgoing cell, the cell being left behind.
    private final int outWall;
    // In represents the ingoing cell, the cell being entered.
    private final int inX, inY, inWall;

    Vertex(int inX, int inY, int inWall, int outWall) {
        this.inX = inX;
        this.inY = inY;
        this.inWall = inWall;
        this.outWall = outWall;
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
