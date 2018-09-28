import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class View extends Application {
    private static Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        controller = new Controller();
        stage.setResizable(false);
        HBox root = new HBox();
        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("Encryption");
        stage.setScene(scene);
        stage.show();

        VBox leftPane = new VBox(60);
        leftPane.setStyle("-fx-background-color: grey;");
        leftPane.setPadding(new Insets(60));
        leftPane.setMinSize(516.6,Integer.MAX_VALUE);
        leftPane.setMaxSize(516.6,Integer.MAX_VALUE);
        BorderPane.setAlignment(leftPane, Pos.CENTER);
        VBox.setVgrow(leftPane, Priority.ALWAYS);

        TextArea inputMessage = new TextArea();
        inputMessage.setPromptText("Enter Message");
        inputMessage.setWrapText(true);
        TextField inputKeyword = new TextField();
        inputKeyword.setPromptText("Enter Keyword");
        Button encrypt = new Button("Encrypt");
        Label encryptedMessage = new Label();
        encryptedMessage.setWrapText(true);
        encrypt.setOnAction((ActionEvent ae) -> controller.encrypt(inputMessage.getText(),inputKeyword.getText(),encryptedMessage));
        leftPane.getChildren().addAll(inputMessage,inputKeyword,encrypt,encryptedMessage);


        VBox rightPane = new VBox(60);
        rightPane.setStyle("-fx-background-color: grey;");
        rightPane.setPadding(new Insets(60));
        rightPane.setMinSize(516.5,Integer.MAX_VALUE);
        rightPane.setMaxSize(516.6,Integer.MAX_VALUE);
        BorderPane.setAlignment(rightPane, Pos.CENTER);
        VBox.setVgrow(rightPane, Priority.ALWAYS);
        root.getChildren().addAll(leftPane,rightPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
