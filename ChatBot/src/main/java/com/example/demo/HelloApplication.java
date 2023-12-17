package com.example.demo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.TextFlow;
import java.io.IOException;

public class HelloApplication extends Application {
    FXMLLoader fxmlLoader;

    HelloController controller;
    TextFlow text1;


    @Override


    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new.fxml"));
        Pane root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        text1 = controller.getText();


        add_text(" Hello how can I help you ?\n\n", text1);
        initilize(text1);

        controller.button1.setDisable(true);



        text1.setOnMouseClicked(mouseEvent -> {
            controller.autoScrolling();
        });


        controller.button1.setOnMouseClicked(mouseEvent -> {
            controller.Send();


        });


        Scene scene = new Scene(root, 400, 425);


        stage.setTitle("Chatbot");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();

    }

    public void add_text(Hyperlink text, TextFlow textFlow) {
        Text s = new Text(text + "");
        textFlow.getChildren().add(s);
    }

    public void add_text(String text, TextFlow textFlow) {
        Text s = new Text(text + "");
        textFlow.getChildren().add(s);
    }


    public void initilize(TextFlow textFlow) {


        Hyperlink link2 = new Hyperlink("Coffee prices");
        Hyperlink link3 = new Hyperlink("Live agent");
        Hyperlink link4 = new Hyperlink("Coffee shop location");
        Hyperlink link1 = new Hyperlink("FAQ");


        link2.setOnAction(event -> {
            coffeep(textFlow);
        });

        link3.setOnAction(event -> {
            liveagent(textFlow);
        });

        link4.setOnAction(event -> {
            location(textFlow);
        });

        link1.setOnAction(event -> {
            faq(textFlow);
        });
        textFlow.getChildren().addAll(link4, link3, link2, link1);
    }

    public void faq(TextFlow textFlow) {
        Hyperlink link11 = new Hyperlink("1 Delivery options ");
        add_text("", textFlow);
        link11.setOnAction(event -> {
            add_text("\n 1 - Currently we dont have delivery , only order and collection only.", textFlow);
            decider(textFlow);
        });

        Hyperlink link12 = new Hyperlink("2 How to order coffee");
        add_text("\n", textFlow);

        link12.setOnAction(event -> {
            add_text("\n 2 To order coffee you can call this number +44756444463(collection only)", textFlow);
            decider(textFlow);
        });


        Hyperlink link13 = new Hyperlink("3 Do we have discounts");
        add_text("\n\n", textFlow);

        link13.setOnAction(event -> {
            add_text("\n 3 - Special discount of the day - 30% off  “FFXX30” ", textFlow);
            decider(textFlow);
        });

        textFlow.getChildren().addAll(link11, link12, link13);


    }

    public void decider(TextFlow textFlow) {
        add_text("\n \n If this was helpful", textFlow);
        Hyperlink link20 = new Hyperlink("Yes ");

        link20.setOnAction(event -> {
            add_text("\n \n Thank you for using our service", textFlow);
            add_text("", textFlow);
            decider2(textFlow);
        });
        Hyperlink link21 = new Hyperlink("No");
        link21.setOnAction(event -> {
            add_text("\n \n", textFlow);
            initilize(textFlow);
        });
        Text devider = new Text("/");
        textFlow.getChildren().addAll(link20, devider, link21);

    }

    public void liveagent(TextFlow textFlow) {
        add_text("\n \n Call this number, agent will help you !(+44 750644477552)", textFlow);
        decider(textFlow);
    }

    public void location(TextFlow textFlow) {
        add_text("\n", textFlow);
        add_text("\n \n Cardiff Queen Street 25 / CF24 5XX", textFlow);
        decider(textFlow);
    }

    public void coffeep(TextFlow textFlow) {
        add_text("\n Large = £4.00 / Medium = £2.50", textFlow);
        add_text("\n", textFlow);
        decider(textFlow);
    }

    public void decider2(TextFlow textFlow ) {
        add_text("\n \n Would you like to give some feedback about our service ?", textFlow);
        Hyperlink link23 = new Hyperlink("Yes ");

        link23.setOnAction(event -> {
            add_text("\n\n Please give some feedback about our service!", textFlow);
            controller.button1.setDisable(false);

        });
        Hyperlink link24 = new Hyperlink("No");
        link24.setOnAction(event -> {
            add_text("\n\n This is our special offers  of the week- Large Coffee for £ 1.99", textFlow);
            add_text("\n\n Thank you for using our service.\r\n\n Goodbye", textFlow);


        });
        Text devider2 = new Text("/");
        textFlow.getChildren().addAll(link23, devider2, link24);
    }

}



