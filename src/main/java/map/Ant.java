package map;

public class Ant {

    private int x;
    private int y;


    public Ant(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y*Map.getSCALE();
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x*Map.getSCALE();
    }

    public void setX(int x) {
        this.x = x;
    }
}
