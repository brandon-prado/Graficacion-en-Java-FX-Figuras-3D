package Figuras;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * Figuras en 3 dimensiones de cubo, cilindro y esfera sin color ni cámara.
 *
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 1.0. 20.10.2021
 */

public class Figuras1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //------------CUBO------------//
        //Crear cubo por medio de Box
        Box cubo = new Box(300, 300, 300);
        cubo.setTranslateX(200);
        cubo.setTranslateY(250);
        cubo.setTranslateZ(200);
        
        //Rotación del cubo
        cubo.setRotate(4);
        cubo.setRotationAxis(new Point3D(0.4, 0.4, 0));

        //------------CILINDRO------------//
        //Crear cilindro por medio de Cylinder
        Cylinder cilindro = new Cylinder(50, 300);
        cilindro.setTranslateX(500);
        cilindro.setTranslateY(250);
        cilindro.setTranslateZ(100);
        
        //Rotación del cilindro
        cilindro.setRotate(5);
        cilindro.setRotationAxis(new Point3D(2, 0, 0));

        //------------ESFERA------------//
        //Crear esfera por medio de Sphere
        Sphere esfera = new Sphere(150);
        esfera.setTranslateX(800);
        esfera.setTranslateY(250);
        esfera.setTranslateZ(400);

        /* CREACIÓN DE LA VENTANA Y DE LOS CONTENEDORES PRINCIPALES */
        // Contenedor principal donde se alojarán todos los elementos
        Group root = new Group(cubo, cilindro, esfera);

        // Creación del área (scene) correspondiente al contenido que tendrá la ventana 
        // de 1000 x 500 puntos, con color de fondo dado en rgb, indicando que el
        // elemento root va a ser el contenedor principal de este espacio
        Scene scene = new Scene(root, 1000, 500, Color.rgb(198, 77, 11));//Naranja

        // Se asocia la ventana (scene) al parámetro primaryStage (escenario
        // principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);

        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Cubo, cilindro y esfera simples");

        // Orden para que se muestre la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
