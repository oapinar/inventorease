module com.gnineieceng {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.gnineieceng to javafx.fxml;
    exports com.gnineieceng;
    exports com.gnineieceng.controller to javafx.fxml;
    opens com.gnineieceng.controller to javafx.fxml;
}
