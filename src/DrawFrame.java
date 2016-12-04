import javax.swing.*;

public class DrawFrame extends JFrame {
    private JPanel rootPanel;
    private DrawPanel drawPanel;
    private JPanel controlPanel;
    private JButton clearButton;
    private JComboBox shapeComboBox;
    private JComboBox lineComboBox;
    private JRadioButton greenRadioButton;
    private JRadioButton redRadioButton;
    private JRadioButton blueRadioButton;

    DrawFrame() {
        // Set JFrame title
        super("Drawing App");
        // Some standard swing stuff
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // Create all of the GUI components
    private void createUIComponents() {
        drawPanel = new DrawPanel();

        // Initialize the shape combo box
        shapeComboBox = new JComboBox();
        shapeComboBox.addItem(new ComboItem("Line", "1"));
        shapeComboBox.addItem(new ComboItem("Rectangle", "2"));
        shapeComboBox.addItem(new ComboItem("Oval", "3"));
        // Set shape selection action
        shapeComboBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String itemName = cb.getSelectedItem().toString();
            drawPanel.setShape(itemName);
        });

        // Initialize the line thickness combo box
        lineComboBox = new JComboBox();
        lineComboBox.addItem(new ComboItem("Small", "1"));
        lineComboBox.addItem(new ComboItem("Medium", "2"));
        lineComboBox.addItem(new ComboItem("Large", "3"));
        // Set shape selection action
        lineComboBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String itemName = cb.getSelectedItem().toString();
            drawPanel.setThickness(itemName);
        });

        // Set clear button action listener
        clearButton = new JButton();
        clearButton.addActionListener(e -> drawPanel.clearImage());

        // Set color radio button action listeners
        redRadioButton = new JRadioButton();
        blueRadioButton = new JRadioButton();
        greenRadioButton = new JRadioButton();
        redRadioButton.addActionListener(e -> drawPanel.setColor("Red"));
        blueRadioButton.addActionListener(e -> drawPanel.setColor("Blue"));
        greenRadioButton.addActionListener(e -> drawPanel.setColor("Green"));
    }
}