package day09;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MoreKernels extends Application
{

	static Image inputImageJfx;
	static MyImage outputImageJfx;


	public static void main(String[] args) throws Exception
	{

		inputImageJfx = new Image(
				new FileInputStream(System.getProperty("user.home") + "/Desktop/photo.jpg"));
		;

		outputImageJfx = new MyImage((int) inputImageJfx.getWidth(),
				(int) inputImageJfx.getHeight());
		;

		outputImageJfx.copyFrom(inputImageJfx);

		outputImageJfx.blur(2);
		outputImageJfx.save();

		launch(args);
	}


	@Override
	public void start(Stage primaryStage)
	{

		ImageView inputImageView = new ImageView(inputImageJfx);
		ImageView outputImageView = new ImageView(outputImageJfx);

		FlowPane root = new FlowPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setStyle("-fx-background-color: DAE6F3;");
		root.setHgap(10);
		root.setVgap(10);
		root.getChildren().add(inputImageView);
		root.getChildren().add(outputImageView);

		Scene scene = new Scene(root, inputImageJfx.getWidth() + 20,
				inputImageJfx.getHeight() * 2 + 20 * 1.5);

		primaryStage.setTitle("Duplicates");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}