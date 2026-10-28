/*
 * Class: CMSC203 
 * Instructor: Professor Tarek
 * Description: Design and implement a Property Management application in Java that manages multiple properties owned or managed by a company. 
 * The application will maintain an array of Property objects inside a ManagementCompany object (aggregation), 
 * support adding and listing properties, calculate total rent, include copy constructors, 
 * and provide both a console-based driver and a JavaFX GUI. 
 * Due: 10/28/26
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nebiyou Daniel
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyAppFX extends Application {

    private ManagementCompany company = new ManagementCompany("Sunrise Management", "12-3456789");

    private TextField nameField = new TextField();
    private TextField cityField = new TextField();
    private TextField rentField = new TextField();
    private TextField ownerField = new TextField();
    private TextArea display = new TextArea();

    @Override
    public void start(Stage stage) {
        GridPane gridForm = new GridPane();
        gridForm.setHgap(10);
        gridForm.setVgap(12);
        gridForm.addRow(0, new Label("Property Name:"), nameField);
        gridForm.addRow(1, new Label("City:"), cityField);
        gridForm.addRow(2, new Label("Rent:"), rentField);
        gridForm.addRow(3, new Label("Owner:"), ownerField);

        Button addButton = new Button("Add Property");
        Button showAllButton = new Button("Show All Properties");
        Button totalRentButton = new Button("Show Total Rent");

        addButton.setOnAction(e -> addProperty());
        showAllButton.setOnAction(e -> showAll());
        totalRentButton.setOnAction(e -> showTotal());

        HBox buttons = new HBox(10, addButton, showAllButton, totalRentButton);

        display.setEditable(false);
        display.setPrefRowCount(10);

        VBox root = new VBox(12, gridForm, buttons, display);
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 520, 460));
        stage.setTitle("Property Management");
        stage.show();
    }

    private void addProperty() {
        String name = nameField.getText().trim();
        String city = cityField.getText().trim();
        String owner = ownerField.getText().trim();

        if (name.isEmpty() || city.isEmpty() || owner.isEmpty()) {
            display.setText("Please fill in every field.");
            return;
        }

        double rent;
        try {
            rent = Double.parseDouble(rentField.getText().trim());
        } catch (NumberFormatException ex) {
            display.setText("Rent must be a number.");
            return;
        }

        int index = company.addProperty(new Property(name, city, rent, owner));
        if (index == ManagementCompany.FULL) {
            display.setText("The company is full (max " + ManagementCompany.MAX_PROPERTIES + " properties).");
        } else {
            display.setText("Property added at index " + index + ".");
            nameField.clear();
            cityField.clear();
            rentField.clear();
            ownerField.clear();
        }
    }

    private void showAll() {
        display.setText(company.toString());
    }

    private void showTotal() {
        display.setText("Total rent: $" + String.format("%.2f", company.totalRent()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
