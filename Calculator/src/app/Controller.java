package app;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonMultiply, buttonDivide, buttonPlus, buttonMinus,
    buttonClear, buttonBack, buttonClose;//declare buttons
    @FXML
    private Label labelDisplay, labelAnswer;//declare labels
    String label="";
    RemoveLastCharacter RLC = new RemoveLastCharacter();
    String tmpLabel="";
    String answerLabel="";
    int answer=0;
    //make buttons do something
    public void zero(ActionEvent e){
        label+="0";
        labelDisplay.setText(label);
    }
    public void one(ActionEvent e){
        label+="1";
        labelDisplay.setText(label);
    }
    public void two(ActionEvent e){
        label+="2";
        labelDisplay.setText(label);
    }
    public void three(ActionEvent e){
        label+="3";
        labelDisplay.setText(label);
    }
    public void four(ActionEvent e){
        label+="4";
        labelDisplay.setText(label);
    }
    public void five(ActionEvent e){
        label+="5";
        labelDisplay.setText(label);
    }
    public void six(ActionEvent e){
        label+="6";
        labelDisplay.setText(label);
    }
    public void seven(ActionEvent e){
        label+="7";
        labelDisplay.setText(label);
    }
    public void eight(ActionEvent e){
        label+="8";
        labelDisplay.setText(label);
    }
    public void nine(ActionEvent e){
        label+="9";
        labelDisplay.setText(label);
    }
    public void equal(ActionEvent e){
        answer=Evaluate.evaluate(label);//evaluate label
        answerLabel=Integer.toString(answer);
        labelAnswer.setText(answerLabel);

    }
    public void close(ActionEvent e){
        Platform.exit();
    }
    public void clear(ActionEvent e){
        label="";
        labelDisplay.setText(label);
        answerLabel="";
        labelAnswer.setText(answerLabel);
    }
    public void back(ActionEvent e){
        tmpLabel=RLC.removeLastchar(label);//remove a number or operator from the back
        label=tmpLabel;
        labelDisplay.setText(label); 
    }
    public void minus(ActionEvent e){
        label+="-";
        labelDisplay.setText(label);
    }
    public void plus(ActionEvent e){
        label+="+";
        labelDisplay.setText(label);
    }
    public void multiply(ActionEvent e){
        label+="x";
        labelDisplay.setText(label);
    }
    public void divide(ActionEvent e){
        label+="÷";
        labelDisplay.setText(label);
    }
    
}
