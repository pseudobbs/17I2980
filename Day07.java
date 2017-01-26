/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author unouser
 */
public class Day06 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ImageView imageView = new ImageView(outputImageJfx);
        
        
        
        Button btn = new Button();
        btn.setText("I am a button");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Joseph likes to eat sandwiches");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Quien es tu Papa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    static BufferedImage inputImage;
    static Image inputImageJfx;
    static WritableImage outputImageJfx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        
        inputImage = ImageIO.read(new File("c:/users/unouser/desktop/photo.jpg"));
        inputImageJfx = new Image(new FileInputStream("c:/users/unouser/desktop/photo.jpg"));
        
        outputImageJfx = new WritableImage(360, 255);
        
        
        
        BufferedImage outputImage = new BufferedImage(360 ,  255, BufferedImage.TYPE_INT_RGB);
        
        for(int y = 0; y < 255 ;  y++)
        {
            for(int x = 0; x < 255 ; x++)
            {
                
                
                //outputImage.setRGB(x, y, Color.YELLOW.getRGB());
                
                
                
                outputImageJfx.getPixelWriter().setColor(x, y,  javafx.scene.paint.Color.hsb(x, y/255.0, 1));
            }
        }
        
        ImageIO.write(outputImage, "PNG", new File("c:/users/unouser/desktop/newPhoto.png") );
        
        launch(args);
    }

   
    
    
}
