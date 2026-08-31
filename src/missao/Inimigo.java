package missao;

public class Inimigo {

    private int x;
    private int y;

    public Inimigo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean colideCom(Nave n) {
        return n.getX() == x && n.getY() == y;
    }

}