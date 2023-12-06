import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    Monster(int x, int y) {
        this.position = new Position(x, y);
    }

    public void draw(TextGraphics screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('M')[0]);
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        screen.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position positionMonsterWantsToMove() {
        Random random = new Random();
        return switch (random.nextInt(4)) {
            case 0 -> moveUp();
            case 1 -> moveDown();
            case 2 -> moveRight();
            case 3 -> moveLeft();
            default -> null;
        };
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
}
