package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;



public class Controller {

    @FXML
    protected Canvas paper;
    @FXML
    private int selected = -1;

    @FXML
    private ColorPicker colorSelected;

    @FXML
    Button deletBt;
    @FXML
    Button cloneBt;

    private ArrayList<Circle> circles = new ArrayList<Circle>(0);

    private ArrayList<Rectangle> rects = new ArrayList<Rectangle>(0);

    private ArrayList<Rectangle> lines = new ArrayList<Rectangle>(0);

    public Controller(){
        super();
    }
    public void draw(MouseEvent mouseEvent)

    {
        GraphicsContext gc = paper.getGraphicsContext2D();
        addDrawing(mouseEvent.getX(),mouseEvent.getY());
        drawSomthing(gc);
    }

    public void drawSomthing(GraphicsContext gc){

        for(Circle c : circles) {
            gc.beginPath();
            gc.setFill(c.getColor());
            gc.fillOval(c.getX(),c.getY(),c.getWidth(),c.getHeight());
            gc.stroke();
        }
        for(Rectangle r : rects) {
            gc.beginPath();
            gc.setFill(r.getColor());
            gc.fillRect(r.getX(),r.getY(),r.getWidth(),r.getHeight());
            gc.stroke();
        }

        for(Rectangle l : lines) {
            gc.beginPath();
            gc.setFill(l.getColor());
            gc.fillRect(l.getX(),l.getY(),l.getWidth(),l.getHeight());
            gc.stroke();
        }
    }

    public void addDrawing(double x,double  y) {
        switch (selected) {
            case 0:
                circles.add(new Circle(x-25,y-25,50,50,getColor()));

                break;
            case 1:
                rects.add(new Rectangle(x-25,y-25,50,50,getColor()));

                break;
            case 2:
                lines.add(new Rectangle(x,y,200,3,getColor()));
            case 3 :
                break;

        };


    }

    public void slectMove(MouseEvent mouseEvent) {
        selected = 3;
        deletBt.setDisable(false);
        cloneBt.setDisable(false);

    }

    public void drawCircle(MouseEvent mouseEvent) {
            selected = 0;
            deletBt.setDisable(true);
            cloneBt.setDisable(true);

    }

    public void drawRectangle(MouseEvent mouseEvent) {
        selected = 1;
        deletBt.setDisable(true);
        cloneBt.setDisable(true);
    }

    public void drawLine(MouseEvent mouseEvent) {
        selected = 2;
        deletBt.setDisable(true);
        cloneBt.setDisable(true);
    }

    public Color getColor() {
        deletBt.setDisable(true);
        cloneBt.setDisable(true);
        return colorSelected.getValue();

    }

    public void tackColor(ActionEvent actionEvent) {
    }

    /*
        repaint ???
     */

    public void delete(MouseEvent mouseEvent) {
        for(Circle c : circles){
            if(c.clicked) {
                circles.remove(c);
                GraphicsContext gc = paper.getGraphicsContext2D();
                gc.clearRect(0, 0, paper.getWidth(), paper.getHeight());
                GraphicsContext gc2 = paper.getGraphicsContext2D();
                drawSomthing(gc2);
            }

        }

        for(Rectangle r : rects){
            if(r.clicked) {
                circles.remove(r);
                GraphicsContext gc = paper.getGraphicsContext2D();
                gc.clearRect(0, 0, paper.getWidth(), paper.getHeight());
                GraphicsContext gc2 = paper.getGraphicsContext2D();
                drawSomthing(gc2);;
            }
        }

        for(Rectangle l : lines){
            if(l.clicked) {
                circles.remove(l);
                GraphicsContext gc = paper.getGraphicsContext2D();
                gc.clearRect(0, 0, paper.getWidth(), paper.getHeight());
                GraphicsContext gc2 = paper.getGraphicsContext2D();
                drawSomthing(gc2);
            }
        }


    }
}
