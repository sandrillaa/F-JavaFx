package sample;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
/*import org.w3c.dom.Text;*/
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.management.modelmbean.ModelMBean;


public class Controller {

    @FXML
    private Text output;
    private long num1 = 0;
    private long num2 = 0;

    private boolean start = true;

    private String operator = "";
    private model model = new model();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private void num(ActionEvent event) {
        if(start) {
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText()+value);
    }

    @FXML
    void operator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if(!"=".equals(value)){
            if(!operator.isEmpty()) return;
            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if(operator.isEmpty()) return;
            output.setText(String.valueOf(model.calculation(num1, Long.parseLong(output.getText()),operator)));
            operator = "";
            start = true;
        }
    }

    @FXML
    void initialize() {

    }
}
