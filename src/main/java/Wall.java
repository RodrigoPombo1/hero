import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {

    Wall(int x, int y) {
        this.position = new Position(x, y);
    }

    public void draw(TextGraphics screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('W')[0]);
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        screen.putString(new TerminalPosition(position.getX(), position.getY()), "W");
    }
}
