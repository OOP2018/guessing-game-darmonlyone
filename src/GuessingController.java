import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class GuessingController {

    private int upperBound;

    private NumberGame game;

    private CounterView counterView;
    @FXML
    private Button startBut;

    @FXML
    private TextField upperboundText;

    @FXML
    private Label settedLable;

    @FXML
    private Button setButton;

    @FXML
    private Label upperLable;

    @FXML
    private TextField inputText;

    @FXML
    private Button okButton;

    @FXML
    private Button clearButton;

    @FXML
    private Label loveLable;

    @FXML
    public void initialize(){
        upperBound = 100;
        game = new DarmGame(upperBound);
        settedLable.setVisible(false);
        upperLable.setText(upperboundText.getText());
        okButton.setDisable(true);
        loveLable.setVisible(false);
        inputText.setDisable(true);

        counterView = new CounterView(game);
        game.addObserver(counterView);
        counterView.run();
    }

    @FXML
    void clear(ActionEvent event) {
        inputText.setText("");
        okButton.setDisable(true);
        startBut.setDisable(false);
        setButton.setDisable(false);
        upperboundText.setDisable(false);
        loveLable.setVisible(false);
        inputText.setDisable(true);

    }

    @FXML
    void okay(ActionEvent event) {
        loveLable.setVisible(true);
        int gues;
        try {
            gues = Integer.parseInt(inputText.getText());
        }catch (Exception e){
            loveLable.setText("Please input value");
            return;
        }
        if (!game.guess(gues)){
            loveLable.setTextFill(Color.RED);
        }else{
            inputText.setDisable(true);
            okButton.setDisable(true);
            loveLable.setTextFill(Color.GREEN);
        }
        loveLable.setText(game.getMessage());
    }

    @FXML
    void setUpperBound(ActionEvent event) {
        settedLable.setVisible(true);
        try {
            upperBound = Integer.parseInt(upperboundText.getText());
            upperLable.setText(upperboundText.getText());
        }catch (Exception e){
            upperboundText.setText("");
        }
    }

    @FXML
    void start(ActionEvent event) {
        game.setSecret(upperBound);
        startBut.setDisable(true);
        okButton.setDisable(false);
        setButton.setDisable(true);
        upperboundText.setDisable(true);
        settedLable.setVisible(false);
        inputText.setDisable(false);
        game.setCount(0);
    }

}
