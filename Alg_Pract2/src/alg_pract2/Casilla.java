package alg_pract2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Sergi
 */
public class Casilla extends JPanel {

    private BufferedImage imagen;
    private final String dir;

    public Casilla(String dir) {
        imagen = null;
        this.dir = dir;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        try {
            imagen = ImageIO.read(new File(dir));
            g2D.drawImage(imagen.getScaledInstance(this.getWidth(), this.getHeight(), 0), 0, 0, this);
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
