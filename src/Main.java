import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener{
    //JFrame - Actual window
    //JPanel - Actual stuff shown

    private final int TIME_INTERVAL = 16;
    private JFrame frame;
    private Timer timer;

    public Main(String title){
        frame = new JFrame(title);
        frame.add(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        timer = new Timer(TIME_INTERVAL, this);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void update(){

    }

    public void render(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.fillRect(50, 50, 50, 50);
        g2d.fillOval(100, 100, 50, 50);
        g2d.drawRect(200, 50, 50, 50);
        g2d.drawOval(50, 200, 50, 50);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        render(g2d);
    }

    public void stop(){
        timer.stop();
        frame.dispose();
    }

    public static void main(String[] args){
        new Main("Window");
    }

}
