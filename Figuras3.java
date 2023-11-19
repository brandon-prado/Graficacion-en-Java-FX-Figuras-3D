package Figuras;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * Figuras en 3 dimensiones de cubo, cilindro y esfera con textura.
 *
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 1.0. 20.10.2021
 */

public class Figuras3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //------------CUBO------------//
        //Crear cubo por medio de Box
        Box cubo = new Box(250, 250, 250);
        cubo.setTranslateX(150);
        cubo.setTranslateY(250);
        cubo.setTranslateZ(150);

        //Textura del cubp
        PhongMaterial texturaCubo = new PhongMaterial();
        texturaCubo.setDiffuseMap(new Image("https://thumbs.dreamstime.com/b/color-fluido-fondo-llamativo-gradiente-forma-elemento-foco-indeterminado-en-de-una-gota-agua-brillante-textura-ilustraci%C3%B3n-210531632.jpg"));
        cubo.setMaterial(texturaCubo);

        //Rotación del cubo
        cubo.setRotate(45);
        cubo.setRotationAxis(new Point3D(1, 1, 0));

        //------------CILINDRO------------//
        //Crear cilindro por medio de Cylinder
        Cylinder cilindro = new Cylinder(50, 300, 500);
        cilindro.setTranslateX(500);
        cilindro.setTranslateY(250);
        cilindro.setTranslateZ(150);

        //Textura del cilindro
        PhongMaterial texturaCilindro = new PhongMaterial();
        texturaCilindro.setDiffuseMap(new Image("https://previews.123rf.com/images/krinichnaya/krinichnaya1706/krinichnaya170600137/80445684-textura-roja-brillante-abstracto-arte-de-fantas%C3%ADa-digital-raster-3d.jpg"));
        cilindro.setMaterial(texturaCilindro);

        //Rotación del cilindro
        cilindro.setRotate(60);
        cilindro.setRotationAxis(new Point3D(1, 2, 0));

        //------------ESFERA------------//
        //Crear esfera por medio de Sphere
        Sphere esfera = new Sphere(150);
        esfera.setTranslateX(800);
        esfera.setTranslateY(250);
        esfera.setTranslateZ(150);
        esfera.setRotate(23.5);

        //Textura de la esfera
        PhongMaterial texturaEsfera = new PhongMaterial();
        texturaEsfera.setDiffuseMap(new Image("https://static6.depositphotos.com/1053932/550/i/600/depositphotos_5508430-stock-photo-burlap-sack-vegetal-brown-texture.jpg"));
        esfera.setMaterial(texturaEsfera);

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
        Scene scene = new Scene(root, 1000, 500, Color.rgb(95, 213, 117));//Verde claro

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
        primaryStage.setTitle("Cubo, cilindro y esfera con textura");

        // Orden para que se muestre la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
