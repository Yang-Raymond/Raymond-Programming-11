package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.util.Random;
import java.util.ArrayList;

public class Controller {
    @FXML
    private TextField textFieldamount, textfieldBet;
    @FXML
    private Button buttonAmount, buttonRoll, buttonBet;
    @FXML
    private Label labelDice, labelError;
    @FXML
    private RadioButton radiobuttonHigher, radiobuttonSame, radiobuttonLower;

    double amount;
    int number;
    ArrayList<Integer>Numbers= new ArrayList<Integer>();
    int guess;
    double bet;

    public void submit(ActionEvent event) {
        Random rand = new Random();
        number = rand.nextInt(1, 7);
        Numbers.add(number);
        labelDice.setText(Integer.toString(number));
        try {
            amount = Double.parseDouble(textFieldamount.getText());
            labelError.setText(Double.toString(amount));
            if (amount <= 0) {
                labelError.setText("ERROR: amount<=0");
            } else {
                labelError.setText(Double.toString(amount));
                buttonAmount.setDisable(true);
                buttonBet.setDisable(false);
            }

        } catch (Exception e) {
            labelError.setText("ERROR: Contains symbols or letter");
        }
    }

    public void setBetamount(ActionEvent event) {
        try {
            bet = Double.parseDouble(textfieldBet.getText());
            labelError.setText(Double.toString(amount));
            if (bet > amount || bet <= 0) {
                labelError.setText("ERROR: Bet > amount re-enter bet");
            } else if (bet <= amount) {
                labelError.setText(Double.toString(amount));
                buttonBet.setDisable(true);
                radiobuttonHigher.setDisable(false);
                radiobuttonSame.setDisable(false);
                radiobuttonLower.setDisable(false);
            }

        } catch (Exception e) {
            labelError.setText("ERROR: Contains symbols or letter");
        }

    }

    public void roll(ActionEvent event) {
        Random random = new Random();
        number = random.nextInt(1, 7);
        Numbers.add(number);
        labelDice.setText(Integer.toString(number));
        buttonRoll.setDisable(true);
        buttonBet.setDisable(false);
        if (number > Numbers.get(Numbers.size()-2) && guess == 1){
            amount+=bet;
        }else if (number == Numbers.get(Numbers.size()-2) && guess == 2){
            amount+=bet;
        }else if (number < Numbers.get(Numbers.size()-2) && guess == 3){
            amount+=bet;
        }else{
            amount-=bet;
        }
        labelError.setText(Double.toString(amount));
        radiobuttonHigher.setSelected(false);
        radiobuttonSame.setSelected(false);
        radiobuttonLower.setSelected(false);
    }

    public void guess(ActionEvent event) {
        if (radiobuttonHigher.isSelected()) {
            guess = 1;
        } else if (radiobuttonSame.isSelected()) {
            guess = 2;
        } else if (radiobuttonLower.isSelected()) {
            guess = 3;
        }
        if (amount <= 0) {
            labelError.setText("You don't have enough money");
            buttonAmount.setDisable(false);
            buttonBet.setDisable(true);
            buttonRoll.setDisable(true);
            radiobuttonHigher.setDisable(true);
            radiobuttonLower.setDisable(true);
            radiobuttonSame.setDisable(true);
        }else{
            buttonRoll.setDisable(false);  
        }
    }

}
