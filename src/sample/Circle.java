package sample;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Circle extends Parent {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;
    protected Boolean clicked;
    public Circle(double x, double y, double width, double height, Color color){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        clicked = false;
        this.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                clicked = true;
            }
        });

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
