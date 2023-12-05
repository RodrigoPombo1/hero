import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;


    Hero hero = new Hero(10, 10);

    private List<Wall> walls;

    private List<Coin> coins;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
        }
    }

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(screen);
        for (Wall wall : walls)
            wall.draw(screen);
        retrieveCoins(hero.getPosition());
        for (Coin coin : coins)
            coin.draw(screen);
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private void retrieveCoins(Position position) {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                System.out.println("gay");
                break;
            }
        }
    }

    private boolean canHeroMove(Position position) {
        boolean not_blocked_by_walls = true;
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                not_blocked_by_walls = false;
                break;
            }
        }
        return not_blocked_by_walls && (position.getX() < width && position.getX() >= 0 && position.getY() < height && position.getY() >= 0);
    }
}
