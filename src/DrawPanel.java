import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class DrawPanel extends JPanel {
    // Attributes for drawing
    private String color = "Red";
    private String shape = "Line";
    private String thickness = "Small";
    private Point startPoint;
    private Point currentPoint;
    private BufferedImage img;

    DrawPanel() {
        // Initialize a buffered image for drawing
        img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        addMouseListener(new MouseAdapter()
        {
            // Handle Mouse Press
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = new Point(e.getX(), e.getY());
            }
            // Handle Mouse Release
            @Override
            public void mouseReleased(MouseEvent e) {
                currentPoint = new Point(e.getX(), e.getY());
                repaint();
            }
        });

        // Handle mouse drag
        addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent e) {
                currentPoint = new Point(e.getX(), e.getY());
                if (getShape().equals("Line")) {
                    repaint();
                    startPoint = currentPoint;
                }
            }
        });
    }

    // Handles all of the graphics functionality
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics gg = img.getGraphics();
        Graphics2D g2 = (Graphics2D) gg;

        // Set respective line color
        switch (getColor()) {
            case "Red":
                gg.setColor(Color.RED);
                break;
            case "Blue":
                gg.setColor(Color.BLUE);
                break;
            case "Green":
                gg.setColor(Color.GREEN);
                break;
        }
        // Set respective line thickness
        switch (getThickness()) {
            case "Small":
                g2.setStroke(new BasicStroke(2));
                break;
            case "Medium":
                g2.setStroke(new BasicStroke(4));
                break;
            case "Large":
                g2.setStroke(new BasicStroke(6));
                break;
        }
        if (startPoint != null && currentPoint != null) {
            // Draw respective shape
            switch (getShape()) {
                case "Line":
                    gg.drawLine(startPoint.x, startPoint.y, currentPoint.x, currentPoint.y);
                    break;
                case "Rectangle":
                    gg.drawRect(startPoint.x, startPoint.y, currentPoint.x - startPoint.x, currentPoint.y - startPoint.y);
                    break;
                case "Oval":
                    gg.drawOval(startPoint.x, startPoint.y, currentPoint.x - startPoint.x, currentPoint.y - startPoint.y);
                    break;
            }
        }
        g.drawImage(img, 0, 0, 500, 500, null);
        gg.dispose();
    }

    // Delete the existing canvas
    void clearImage() {
        img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        startPoint = null;
        currentPoint = null;
        repaint();
    }

    // GETTERS AND SETTERS ------

    private String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    private String getShape() {
        return shape;
    }

    void setShape(String shape) {
        this.shape = shape;
    }

    private String getThickness() {
        return thickness;
    }

    void setThickness(String thickness) {
        this.thickness = thickness;
    }
}
