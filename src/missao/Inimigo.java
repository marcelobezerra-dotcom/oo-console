package missao;

import java.util.Random;

public class Inimigo {
    private int x;
    private int y;

    public Inimigo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void mover(Random random, int minX, int maxX, int minY, int maxY) {
        int dir = random.nextInt(4);
        switch (dir) {
            case 0: if (y > minY) y--; break;
            case 1: if (y < maxY) y++; break;
            case 2: if (x > minX) x--; break;
            case 3: if (x < maxX) x++; break;
        }
    }

    public boolean colideCom(Nave nave) {
        return nave.getX() == x && nave.getY() == y;
    }
}
