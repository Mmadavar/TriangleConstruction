module com.example.triangleproblemhw4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.triangleproblemhw4 to javafx.fxml;
    exports com.example.triangleproblemhw4;
}