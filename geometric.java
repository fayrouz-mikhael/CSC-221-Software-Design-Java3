package application;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class geometric {
public static void drawshape1(GraphicsContext gc) {
	double canvasWidth = gc.getCanvas().getWidth();
	PieChart p = new PieChart(0,0,canvasWidth/2, Color.WHITE); // calling PieChart class
	p.setColor(Color.WHITE);
	p.drawShape(gc); // calling the drawshape finction in Piechart class.
}
}
