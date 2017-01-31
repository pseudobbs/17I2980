package day07Starter;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Day07Starter extends Application {
    
    static Image inputImageJfx;
    static WritableImage outputImageJfx;

    public static void main(String[] args) throws Exception{
        
        inputImageJfx = new Image(new FileInputStream(System.getProperty("user.home") + "/Desktop/photo.jpg"));
        
        outputImageJfx = new WritableImage((int)inputImageJfx.getWidth(), (int)inputImageJfx.getHeight());
        
        for(int y = 0; y < outputImageJfx.getHeight() ;  y++)
        {
            for(int x = 0; x < outputImageJfx.getWidth() ; x++)
            {
                outputImageJfx.getPixelWriter().setColor(x, y,  inputImageJfx.getPixelReader().getColor(x, y).invert());
            }
        }
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(outputImageJfx, null);
        ImageIO.write(renderedImage, "PNG", new File(System.getProperty("user.home") + "/Desktop/newPhoto.png") );
        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        ImageView inputImageView = new ImageView(inputImageJfx);
        ImageView outputImageView = new ImageView(outputImageJfx);
        
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setStyle("-fx-background-color: DAE6F3;");
        root.setHgap(10);
        root.setVgap(10);
        root.getChildren().add(inputImageView);
        root.getChildren().add(outputImageView);
        
        Scene scene = new Scene(root, inputImageJfx.getWidth() + 20, inputImageJfx.getHeight()*2 + 20 * 1.5);
        
        primaryStage.setTitle("Duplicates");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
