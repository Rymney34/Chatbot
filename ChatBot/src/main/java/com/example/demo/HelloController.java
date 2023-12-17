package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.event.ActionEvent;



public class HelloController {

    @FXML
    private ScrollPane scroll = new ScrollPane();

    @FXML
    private TextFlow text1 = new TextFlow();

        @FXML
        public TextField textField;

        @FXML
        Button button1 = new Button();




@FXML
    public void setText(TextFlow text) {
        this.text1 = text;
    }

@FXML
    public void autoScrolling(){
        text1.heightProperty().addListener(((observableValue, oldValue, newValue) -> {
            text1.layout();
            scroll.setVvalue(1.0);
        }));
     }
     public TextFlow getText() {
        return text1;
    }

    @FXML
    public void Send() {
        String newText = textField.getText();
        Text newTextNode = new Text("\n \n " + newText);
        text1.getChildren().add(newTextNode);
        Text th = new Text("\n\n Thank you for your Feedback");
        Text ofer = new Text("\n\n This is our special offers  of the week- Large Coffee for £ 1.99");
        Text last = new Text("\n\n Thank you for using our service.\r\n\n Goodbye");
        text1.getChildren().addAll(th,ofer,last);
        textField.clear();


    }

}



