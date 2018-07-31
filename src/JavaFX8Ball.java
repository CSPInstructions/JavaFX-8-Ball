/*
    JavaFX 8 Ball
    Wesley van Schaijk
    wesley@wschaijk.nl
 */

// Import necessary Java libraries and components
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

// The main class of our application
public class JavaFX8Ball extends Application {

    private Text answer;

    // The starting point of our application
    public static void main(String[] args) {
        // Launch the application with given arguments
        launch(args);
    }

    @Override // The starting point of JavaFX
    public void start(Stage primaryStage) {
        // Create a text block as our header
        Text applicationHeader = new Text();
        applicationHeader.setText("Magic 8 Ball");
        applicationHeader.setFont(Font.font(25));

        // Create a label for the textinput
        Label askAQuestionLabel = new Label();
        askAQuestionLabel.setText("Stel een vraag: ");

        // Create a text field for the user to enter it's question in
        TextField questionField = new TextField();

        // Create a button that the user can click in order to get an answer
        Button askTheQuestionButton = new Button();
        askTheQuestionButton.setText("Stel de vraag");
        askTheQuestionButton.setMaxWidth(Double.MAX_VALUE);
        askTheQuestionButton.setOnAction(event -> getAnAnswer());

        // Create a text block for the answer that our application will give
        this.answer = new Text();
        answer.setWrappingWidth(300);
        answer.setText("Stel een vraag... en wacht op een antwoord. Even kijken wat er gebeurd als ik jou langer maak dan het scherm");

        // Create a GridPane that will hold our components
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        // Add the components to the gridpane
        grid.add(applicationHeader, 0, 0, 2, 1);
        grid.add(askAQuestionLabel, 0, 1);
        grid.add(questionField, 1, 1);
        grid.add(askTheQuestionButton, 0, 2, 2, 1);
        grid.add(answer, 0, 4, 2, 1);

        // Configure the stage and show it
        primaryStage.setScene(new Scene(grid, 320, 200));
        primaryStage.setTitle("Magic 8 Ball");
        primaryStage.show();
    }

    // Function that displays a random answer on the screen
    private void getAnAnswer() {
        // Create an array with answers
        String[] answers = {"Ja", "Zeker", "Lijkt me wel", "Absoluut!", "Nee", "Zeker niet", "Lijkt me niet", "Absoluut Niet!"};

        // Change the answer text to a random answer
        this.answer.setText(answers[new Random().nextInt(answers.length)]);
    }
}
