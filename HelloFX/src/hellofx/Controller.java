/* Author: Andre Barros de Medeiros
 * Date: 27/07/19
 * Description: HelloFX controller
 * Copyright: Free to use, copy, and modify
 * */
package hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label label;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }
}