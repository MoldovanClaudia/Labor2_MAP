import UI.Ui;
import UiDB.UiDB;


public class Main {
//    public static void main(String[] args) {
//        Ui ui = Ui.getInstance(); // Retrieve the singleton instance (optional)
//        ui.main(); // Call the main method of the Ui class
//    }

    public static void main(String[] args) {
        UiDB uiDB = UiDB.getInstance();
        uiDB.main();
    }

}
