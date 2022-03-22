package Friendsbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Button buttonSubmit,buttonDelete;
    @FXML
    private TextArea textareaProperties;
    @FXML
    private TextField textfieldName;
    @FXML
    private Label labelTitle, labelNametitle,labelName, labelPropertiestitle;
    @FXML
    private ListView<friends> listviewFriends;
    @FXML
    private Text textProperties;
    
    String name;
    String properties;
    
    public void submit(ActionEvent e) {
       properties = textareaProperties.getText();
       name = textfieldName.getText();
       friends friend = new friends(name, properties);
       listviewFriends.getItems().add(friend);
       textareaProperties.clear();
       textfieldName.clear();
    }

    public void displayFriend(MouseEvent mouseEvent) {
        friends friend;
        friend = listviewFriends.getSelectionModel().getSelectedItem();
        labelTitle.setText(friend.getname());
        labelNametitle.setOpacity(1);
        labelName.setText(friend.getname());
        labelPropertiestitle.setOpacity(1);
        textProperties.setWrappingWidth(100);
        textProperties.setText(friend.getproperties());
    }
        
    public void delete(ActionEvent e) {
        int selectedIndex = listviewFriends.getSelectionModel().getSelectedIndex();
        listviewFriends.getItems().remove(selectedIndex);
        labelTitle.setText("");
        labelNametitle.setOpacity(0);
        labelName.setText("");
        labelPropertiestitle.setOpacity(0);  
        textProperties.setText("");      
    }

    
}
