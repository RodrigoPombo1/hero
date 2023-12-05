import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    protected Position position;

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public abstract void draw(TextGraphics screen);

}
