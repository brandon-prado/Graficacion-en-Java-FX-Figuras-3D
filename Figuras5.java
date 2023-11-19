package Figuras;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Figuras en 3 dimensiones de cubo, cilindro y esfera con animaciones.
 *
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 1.0. 21.10.2021
 */
 
public class Figuras5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //------------CUBO------------//
        //Crear cubo por medio de Box
        Box cubo = new Box(250, 250, 250);
        cubo.setTranslateX(150);
        cubo.setTranslateY(350);
        cubo.setTranslateZ(150);

        //Textura del cubo
        PhongMaterial texturaCubo = new PhongMaterial();
        texturaCubo.setDiffuseMap(new Image("https://i.pinimg.com/originals/57/db/29/57db2939f6af09f0772399fe2e5eadda.jpg"));
        cubo.setMaterial(texturaCubo);

        //Rotación del cubo
        cubo.setRotate(45);
        cubo.setRotationAxis(new Point3D(1, 1, 0));

        //Animación del cubo
        RotateTransition rotacionCubo = new RotateTransition(Duration.seconds(3.9));
        rotacionCubo.setCycleCount(Animation.INDEFINITE);
        rotacionCubo.setNode(cubo);
        rotacionCubo.setByAngle(360);
        rotacionCubo.setAutoReverse(true);
        rotacionCubo.setCycleCount(Timeline.INDEFINITE);
        rotacionCubo.play();

        //------------CILINDRO------------//
        //Crear cilindro por medio de Cylinder
        Cylinder cilindro = new Cylinder(50, 300);
        cilindro.setTranslateX(500);
        cilindro.setTranslateY(350);
        cilindro.setTranslateZ(150);

        //Textura del cilindro
        PhongMaterial texturaCilindro = new PhongMaterial();
        texturaCilindro.setDiffuseMap(new Image("https://static-cse.canva.com/blob/210838/40-texturas-gratuitas.png"));
        cilindro.setMaterial(texturaCilindro);

        //Rotación del cilindro
        cilindro.setRotate(60);
        cilindro.setRotationAxis(new Point3D(1, 2, 0));
        
        //Animación del cilindro
        RotateTransition rotacionCilindro = new RotateTransition(Duration.seconds(3.9));
        rotacionCilindro.setCycleCount(Animation.INDEFINITE);
        rotacionCilindro.setNode(cilindro);
        rotacionCilindro.setFromAngle(0);
        rotacionCilindro.setToAngle(360);
        rotacionCilindro.setAutoReverse(true);
        rotacionCilindro.setAxis(Rotate.X_AXIS);
        rotacionCilindro.play();

        //------------ESFERA------------//
        //Crear esfera por medio de Sphere
        Sphere esfera = new Sphere(150);
        esfera.setTranslateX(800);
        esfera.setTranslateY(350);
        esfera.setTranslateZ(150);
        esfera.setRotate(23.5);//Inclinación de 23.5° de la Tierra

        //Textura de la esfera
        PhongMaterial texturaEsfera = new PhongMaterial();
        texturaEsfera.setDiffuseMap(new Image("https://ep01.epimg.net/verne/imagenes/2015/04/14/articulo/1429016086_681676_1429024842_sumario_normal.jpg"));
        esfera.setMaterial(texturaEsfera);

        //Animación (rotación de la Tierra)
        RotateTransition rotacionEsfera = new RotateTransition(Duration.seconds(3.9));
        rotacionEsfera.setCycleCount(Animation.INDEFINITE);
        rotacionEsfera.setNode(esfera);
        rotacionEsfera.setByAngle(-360);
        rotacionEsfera.setAxis(Rotate.Y_AXIS);
        rotacionEsfera.setCycleCount(Timeline.INDEFINITE);
        rotacionEsfera.play();

        //------------LUZ------------//
        PointLight luz = new PointLight();
        luz.setTranslateX(-350);
        luz.setTranslateY(-180);
        luz.setTranslateZ(-500);

        PointLight luzContraste = new PointLight();
        luzContraste.setTranslateX(450);
        luzContraste.setTranslateY(300);
        luzContraste.setTranslateZ(310);

        PointLight luzGris = new PointLight();
        luzGris.setColor(Color.GRAY);
        luzGris.setTranslateX(-350);
        luzGris.setTranslateY(-180);
        luzGris.setTranslateZ(-500);

        /* CREACIÓN DE LA VENTANA Y DE LOS CONTENEDORES PRINCIPALES */
        // Contenedor principal donde se alojarán todos los elementos
        Group root = new Group(cubo, cilindro, esfera, luz, luzContraste, luzGris);

        // Creación del área (scene) correspondiente al contenido que tendrá la ventana 
        // de 1000 x 700 puntos, con color de fondo dado en rgb, indicando que el
        // elemento root va a ser el contenedor principal de este espacio
        Scene scene = new Scene(root, 1000, 700, Color.rgb(148, 49, 38));//Rojo oscuro

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
        primaryStage.setTitle("Cubo, cilindro y esfera con animaciones");

        // Orden para que se muestre la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
