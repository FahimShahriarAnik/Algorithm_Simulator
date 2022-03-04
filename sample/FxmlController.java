package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class FxmlController {

    public Circle CicrleTemp[];
    public static Circle temp;
    LinkedList<Integer> list;
    public int sourceNode;

    private Main main;

    void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle0;

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle3;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML // fx:id="line4"
    private Line line4; // Value injected by FXMLLoader

    @FXML // fx:id="line5"
    private Line line5; // Value injected by FXMLLoader

    @FXML // fx:id="line6"
    private Line line6; // Value injected by FXMLLoader

    @FXML
    private Label label2;

    @FXML
    private Label label6;

    @FXML
    private Label label8;

    @FXML
    private Label label5;

    @FXML
    private Button button1;

    @FXML
    private Text text1;

    @FXML // fx:id="textfield1"
    private TextField textfield1;

    @FXML // fx:id="button2"
    private Button button2;

    @FXML // fx:id="label1"
    private Label label1;

    @FXML // fx:id="button2Refresh"
    private Button button2Refresh; // Value injected by FXMLLoader

    @FXML
    private Button Home;

    @FXML
    void button1Pressed(ActionEvent event) {
        int i = list.poll();
        System.out.println(i);
        temp = CicrleTemp[i];

        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);

        KeyValue kv1 = new KeyValue(temp.fillProperty(), Color.RED);
        KeyFrame kf1 = new KeyFrame(Duration.millis(1500), kv1);
        timeline.getKeyFrames().add(kf1);
        timeline.play();

    }
    @FXML
    void button2Pressed(ActionEvent event){
        sourceNode= Integer.parseInt(textfield1.getText());
        System.out.println("Here Source Node is: "+sourceNode);

        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        list = g.BFS(sourceNode);

        assignRef();

    }

    @FXML
    void initialize() {
        assert circle2 != null : "fx:id=\"circle2\" was not injected: check your FXML file 'fxml.fxml'.";
        assert circle0 != null : "fx:id=\"circle0\" was not injected: check your FXML file 'fxml.fxml'.";
        assert circle1 != null : "fx:id=\"circle1\" was not injected: check your FXML file 'fxml.fxml'.";
        assert circle3 != null : "fx:id=\"circle3\" was not injected: check your FXML file 'fxml.fxml'.";
        assert line1 != null : "fx:id=\"line1\" was not injected: check your FXML file 'fxml.fxml'.";
        assert line2 != null : "fx:id=\"line2\" was not injected: check your FXML file 'fxml.fxml'.";
        assert line3 != null : "fx:id=\"line3\" was not injected: check your FXML file 'fxml.fxml'.";
        assert line4 != null : "fx:id=\"line4\" was not injected: check your FXML file 'fxml.fxml'.";
        assert line5 != null : "fx:id=\"line5\" was not injected: check your FXML file 'fxml.fxml'.";
        assert line6 != null : "fx:id=\"line6\" was not injected: check your FXML file 'fxml.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'fxml.fxml'.";
        assert label6 != null : "fx:id=\"label6\" was not injected: check your FXML file 'fxml.fxml'.";
        assert label8 != null : "fx:id=\"label8\" was not injected: check your FXML file 'fxml.fxml'.";
        assert label5 != null : "fx:id=\"label5\" was not injected: check your FXML file 'fxml.fxml'.";
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'fxml.fxml'.";
        assert text1 != null : "fx:id=\"text1\" was not injected: check your FXML file 'fxml.fxml'.";
        assert textfield1 != null : "fx:id=\"textfield1\" was not injected: check your FXML file 'fxml.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'fxml.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'fxml.fxml'.";
        assert button2Refresh != null : "fx:id=\"button2Refresh\" was not injected: check your FXML file 'fxml.fxml'.";

    }

    public void assignRef(){
        CicrleTemp = new Circle[4];
        CicrleTemp[0]=circle0;
        CicrleTemp[1]=circle1;
        CicrleTemp[2]=circle2;
        CicrleTemp[3]=circle3;
    }

    @FXML
    void BfsRefreshClicked(){
        try {
            main.showBfsPage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void HomeClicked(){
        try {
            main.showHomePage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

