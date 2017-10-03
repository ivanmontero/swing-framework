import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

@SuppressWarnings("serial")
public class FinalProduct extends JPanel implements ActionListener {

    public static final int TIME_INTERVAL = 16;
    private JFrame frame;
    private Timer timer;

    private boolean mouseIsPressed;
    private int x, y;
    private Random rand;

    public FinalProduct(String title) {
        frame = new JFrame(title);
        frame.add(this);
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        timer = new Timer(TIME_INTERVAL, this);
        rand = new Random();

        this.setFocusable(true);
        this.grabFocus();

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void update(){

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }

    public void stop() {
        timer.stop();
        frame.dispose();
    }

    public static void main(String[] args) {
        new FinalProduct("Game");
    }
}