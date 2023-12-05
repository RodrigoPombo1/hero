import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {
    Coin(int x, int y) {
        this.position = new Position(x, y);
    }

    public void draw(TextGraphics screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('C')[0]);
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        screen.putString(new TerminalPosition(position.getX(), position.getY()), "C");
    }

}
