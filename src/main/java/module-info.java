module ua.ithillel.hilleljjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens ua.ithillel.hilleljjavafx to javafx.fxml;
    exports ua.ithillel.hilleljjavafx;
    exports ua.ithillel.hilleljjavafx.userupp;
    exports ua.ithillel.hilleljjavafx.homework;
    exports ua.ithillel.hilleljjavafx.homework.user;
}