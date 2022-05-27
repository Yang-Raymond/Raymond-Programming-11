package Friendsbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button buttonSubmit, buttonDelete, buttonSave, buttonLoad;
    @FXML
    private TextArea textareaProperties;
    @FXML
    private TextField textfieldName;
    @FXML
    private Label labelTitle, labelNametitle, labelName, labelPropertiestitle;
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

    public void load(ActionEvent e) throws IOException {
        friends friend;
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Open Resource File");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File file = filechooser.showOpenDialog(new Stage());
        if (file != null) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                String[] values = str.split(",");
                if (values.length != 4) {
                    continue;
                
                }
                friend(values[0],values[2]);
            }
            reader.close();
        }
    }

    public void save(ActionEvent e) {

    }
    private void friend(String string, String string2) {
        friends friend;
        ListView<friends> listview = new ListView<>();
        listview.setItems(friend);
        listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listview.setOnMouseClicked(new EventHandler<Event>();
    }
}
