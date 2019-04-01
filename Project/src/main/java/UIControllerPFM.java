import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class UIControllerPFM extends UIController {

    @FXML
    public ChoiceBox initialLocationSelect;
    public VBox leftVBox;
    public Rectangle rectangleLeft;
    public ChoiceBox destinationSelect;
    public ImageView leftImage;
    public AnchorPane parentAnchorPane;
    public JFXButton cancel_button;

    @FXML
    public void initialize() {
//        leftVBox.prefWidthProperty().bind(parentAnchorPane.widthProperty().multiply(0.15));

        // bind choicebox widths to pane
        initialLocationSelect.prefWidthProperty().bind(leftVBox.prefWidthProperty().multiply(0.75));
        destinationSelect.prefWidthProperty().bind(leftVBox.prefWidthProperty().multiply(0.75));

        // bind background image size to window size
        // ensures auto resize works
        leftImage.fitHeightProperty().bind(parentAnchorPane.heightProperty());
        leftImage.fitWidthProperty().bind(parentAnchorPane.widthProperty());

        // bind opaque rectangle to leftVbox width
        rectangleLeft.widthProperty().bind(leftVBox.prefWidthProperty());

        // set default location
        initialLocationSelect.getItems().add("This Kiosk");
        initialLocationSelect.getSelectionModel().selectFirst();

        // update choices for initial location
        initialLocationSelect.getItems().addAll("choice1", "choice2", "hi");
        // update choices for destination location
        destinationSelect.getItems().addAll("dest1", "dest2");
    }

    @FXML
    public void initLocChanged(ActionEvent actionEvent) {
        System.out.println("Initial location selected: " + initialLocationSelect.getValue());
    }

    @FXML
    public void destLocChanged(ActionEvent actionEvent) {
        System.out.println("Destination selected: " + destinationSelect.getValue());
        System.out.println("Initial location: " + initialLocationSelect.getValue());
        getPath();
    }

    private void getPath() {
        System.out.println("getPath called");
    }
}
