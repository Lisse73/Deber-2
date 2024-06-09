package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DateColorPickerApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear los controles
        Label dateLabel = new Label("Selecciona una fecha:");
        DatePicker datePicker = new DatePicker();

        Label colorLabel = new Label("Selecciona un color:");
        ColorPicker colorPicker = new ColorPicker();

        Button submitButton = new Button("Confirmar selección");
        Label outputLabel = new Label();

        // Configurar la acción del botón
        submitButton.setOnAction(event -> {
            // Obtener la fecha y el color seleccionados
            String selectedDate = datePicker.getValue() != null ? datePicker.getValue().toString() : "No date selected";
            Color selectedColor = colorPicker.getValue();

            // Mostrar las selecciones en la consola
            System.out.println("Fecha seleccionada: " + selectedDate);
            System.out.println("Color seleccionado: " + selectedColor);

            // Mostrar las selecciones en la etiqueta de salida
            outputLabel.setText("Fecha: " + selectedDate + "\nColor: " + selectedColor);
            outputLabel.setTextFill(selectedColor);
        });

        // Crear y configurar el layout
        VBox vbox = new VBox(10);  // Espaciado de 10 píxeles entre elementos
        vbox.getChildren().addAll(dateLabel, datePicker, colorLabel, colorPicker, submitButton, outputLabel);

        // Crear la escena y configurarla en el escenario
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Selector de Fecha y Color");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
