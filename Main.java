package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			Scene scene = new Scene(root,500,500);
			Canvas canvas = new Canvas(400,400); // Canvas width and height
			canvas.setLayoutX(0);
			canvas.setLayoutY(0);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			geometric.drawshape1(gc); // calling geometric class which draws the shape
			root.getChildren().addAll(canvas);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PieChart.area(); // calling class PieChart 
		launch(args);
	}
}
