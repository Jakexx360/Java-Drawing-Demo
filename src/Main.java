import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // Create an instance of the JFrame, which shows the GUI
        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
        });
    }
}
