package Figuras;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Figuras en 3 dimensiones de cubo, cilindro y esfera con transformaciones.
 *
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 1.0. 21.10.2021
 */

public class Figuras4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //------------CUBO------------//
        //Crear cubo por medio de Box
        Box cubo = new Box(250, 250, 250);
        cubo.setTranslateX(150);
        cubo.setTranslateY(250);
        cubo.setTranslateZ(150);

        //Textura del cubo
        PhongMaterial texturaCubo = new PhongMaterial();
        texturaCubo.setDiffuseMap(new Image("https://previews.123rf.com/images/julietphotography/julietphotography1801/julietphotography180100113/94600436-bonito-fondo-rojo-m%C3%A1rmol-y-rojo-intenso-en-colores-llamativos.jpg"));
        cubo.setMaterial(texturaCubo);

        //Rotación del cubo
        cubo.setRotate(45);
        cubo.setRotationAxis(new Point3D(1, 1, 0));

        //------------CILINDRO------------//
        //Crear cilindro por medio de Cylinder
        Cylinder cilindro = new Cylinder(50, 300);
        cilindro.setTranslateX(500);
        cilindro.setTranslateY(250);
        cilindro.setTranslateZ(150);

        //Textura del cilindro
        PhongMaterial texturaCilindro = new PhongMaterial();
        texturaCilindro.setDiffuseMap(new Image("https://thumbs.dreamstime.com/b/modelo-mexicano-de-la-manta-el-serape-raya-vector-127789614.jpg"));
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
        esfera.setRotate(1.303);//Inclinación de 1.303° de Júpiter

        //Textura de la esfera
        PhongMaterial texturaEsfera = new PhongMaterial();
        texturaEsfera.setDiffuseMap(new Image("https://st2.depositphotos.com/7239616/43805/i/600/depositphotos_438053546-stock-photo-orange-brown-background-with-glittering.jpg"));
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
        // Contenedores principales donde se alojarán los elementos
        Group rootCubo = new Group(cubo);
        Group rootCilindro = new Group(cilindro);
        Group rootEsfera = new Group(esfera);
        Group rootLuz = new Group(luz, luzContraste);
        Group rootRadioButton = new Group();
        Group rootFiguras = new Group(rootCubo, rootCilindro, rootEsfera, rootLuz);
        Group rootPrincipal = new Group(rootRadioButton, rootFiguras);

        // Creación del área (scene) correspondiente al contenido que tendrá la ventana 
        // de 1000 x 500 puntos, con color de fondo dado en rgb, indicando que el
        // elemento rootPrincipal va a ser el contenedor principal de este espacio
        Scene scene = new Scene(rootPrincipal, 1000, 500, Color.rgb(27, 164, 224));//Azul claro

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
        primaryStage.setTitle("Cubo, cilindro y esfera con transformaciones");

        // Orden para que se muestre la ventana
        primaryStage.show();

        //Botones para realizar las transformaciones
        RadioButton rbRotar = new RadioButton("Rotar cubo");
        RadioButton rbTrasladar = new RadioButton("Trasladar cilindro");
        RadioButton rbEscalar = new RadioButton("Escalar esfera");
        RadioButton rbSesgar = new RadioButton("Sesgar todo");

        //Posicion de los botones
        rbRotar.setLayoutY(20);
        rbTrasladar.setLayoutX(100);
        rbTrasladar.setLayoutY(20);
        rbEscalar.setLayoutX(220);
        rbEscalar.setLayoutY(20);
        rbSesgar.setLayoutX(330);
        rbSesgar.setLayoutY(20);

        //Agregar los botones al grupo
        rootRadioButton.getChildren().add(rbRotar);
        rootRadioButton.getChildren().add(rbTrasladar);
        rootRadioButton.getChildren().add(rbEscalar);
        rootRadioButton.getChildren().add(rbSesgar);

        //Accion de cada boton
        rbRotar.setOnAction(event -> {
            rbRotar.setSelected(true);
            Rotate rotar = new Rotate();
            rotar.setAngle(5);
            rootCubo.getTransforms().addAll(rotar);
        });
        rbTrasladar.setOnAction((ActionEvent event) -> {
            rbTrasladar.setSelected(true);
            Translate trasladar = new Translate();
            trasladar.setY(30);
            rootCilindro.getTransforms().addAll(trasladar);
        });
        rbEscalar.setOnAction((ActionEvent event) -> {
            rbEscalar.setSelected(true);
            Scale escalar = new Scale();
            escalar.setX(0.9);
            escalar.setY(0.9);
            rootEsfera.getTransforms().addAll(escalar);
        });
        rbSesgar.setOnAction((ActionEvent event) -> {
            rbSesgar.setSelected(true);
            Shear shear = new Shear();
            shear.setPivotX(0);
            shear.setPivotY(0);
            shear.setX(0.09);
            shear.setY(0.09);
            rootFiguras.getTransforms().addAll(shear);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
