import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExcerciseWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
    primaryStage.setTitle("tt");
    VBox layout = new VBox();
    layout.setPadding(new Insets(5, 5, 5, 5));
    layout.setSpacing(5);
    final Label response = new Label();
    Button aButton = new Button("pree");
    aButton.setOnAction(e -> {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Ple");
    alert.setHeaderText("Plaaaaaaaaaaaaae");
    alert.setContentText("Peeeeeeeeeeeeeele");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK){
    response.setText("Psssssssssssssssle");
    } else {
    response.setText("Pxxxxxle");
    }
    });
    layout.getChildren().addAll(aButton, response);
    Scene theScene = new Scene(layout, 300, 200);
    primaryStage.setScene(theScene);
    primaryStage.show();
}
}