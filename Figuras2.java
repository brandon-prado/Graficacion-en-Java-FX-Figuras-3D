package Figuras;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * Figuras en 3 dimensiones de cubo, cilindro y esfera con color, cámara e
 * iluminación.
 *
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 1.0. 20.10.2021
 */

public class Figuras2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //------------CUBO------------//
        //Crear cubo por medio de Box
        Box cubo = new Box(250, 250, 250);
        cubo.setTranslateX(150);
        cubo.setTranslateY(250);
        cubo.setTranslateZ(200);
        
        //Rotación del cubo
        cubo.setRotate(45);
        cubo.setRotationAxis(new Point3D(1, 1, 0));

        //Color del cubo
        PhongMaterial colorCubo = new PhongMaterial();
        colorCubo.setDiffuseColor(Color.rgb(27, 108, 76));//Verde oscuro
        cubo.setMaterial(colorCubo);
        
        //------------CILINDRO------------//
        //Crear cilindro por medio de Cylinder
        Cylinder cilindro = new Cylinder(50, 300);
        cilindro.setTranslateX(500);
        cilindro.setTranslateY(250);
        cilindro.setTranslateZ(100);
        
        //Rotación del cilindro
        cilindro.setRotate(60);
        cilindro.setRotationAxis(new Point3D(1, 2, 0));

        //Color del cilindro
        PhongMaterial colorCilindro = new PhongMaterial();
        colorCilindro.setDiffuseColor(Color.rgb(29, 114, 146));//Azul oscuro
        cilindro.setMaterial(colorCilindro);
        
        //------------ESFERA------------//
        //Crear esfera por medio de Sphere
        Sphere esfera = new Sphere(150);
        esfera.setTranslateX(800);
        esfera.setTranslateY(250);
        esfera.setTranslateZ(200);

        //Color de la esfera
        PhongMaterial colorEsfera = new PhongMaterial();
        colorEsfera.setDiffuseColor(Color.rgb(127, 20, 48));//Rojo oscuro
        esfera.setMaterial(colorEsfera);
        
        //------------LUZ------------//
        PointLight luz = new PointLight();
        luz.setTranslateX(-350);
        luz.setTranslateY(-180);
        luz.setTranslateZ(-500);
        
        PointLight luzContraste = new PointLight();
        luzContraste.setTranslateX(450);
        luzContraste.setTranslateY(300);
        luzContraste.setTranslateZ(310);

        /* CREACIÓN DE LA VENTANA Y DE LOS CONTENEDORES PRINCIPALES */
        // Contenedor principal donde se alojarán todos los elementos
        Group root = new Group(cubo, cilindro, esfera, luz, luzContraste);

        // Creación del área (scene) correspondiente al contenido que tendrá la ventana 
        // de 1000 x 500 puntos, con color de fondo dado en rgb, indicando que el
        // elemento root va a ser el contenedor principal de este espacio
        Scene scene = new Scene(root, 1000, 500, Color.rgb(196, 152, 62));//Amarillo oscuro

        // Se asocia la ventana (scene) al parámetro primaryStage (escenario
        // principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);

        //Se aplica la cámara a las figuras
        PerspectiveCamera camara = new PerspectiveCamera();
        camara.setTranslateX(-60);
        camara.translateZProperty().set(40);
        scene.setCamera(camara);
        primaryStage.setScene(scene);
        
        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Cubo, cilindro y esfera con color, cámara e iluminación");

        // Orden para que se muestre la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
