package parking;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.geom.Line2D;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
 
/**
 * This program demonstrates how to draw lines using Graphics2D object.
 * @author www.codejava.net
 *
 */
public class Affichage extends JFrame {
	static JLabel textE1 ;
	static JLabel textE2 ;
	static JLabel textE3 ;

    public Affichage() {
        super("Parking monitor");
        setResizable(false);
        setSize(1200, 850);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setLayout(null);

        JLabel text1 = text1();
        text1.setText("1");
        text1.setSize(20, 50);
        text1.setBounds(175, 30, 200, 200);
        this.add(text1);
        
        JLabel text2 = text1();
        text2.setText("2");
        text2.setSize(20, 50);
        text2.setBounds(575, 30, 200, 200);
        this.add(text2);
        
        JLabel text3 = text1();
        text3.setText("3");
        text3.setSize(20, 50);
        text3.setBounds(975, 30, 200, 200);
        this.add(text3);
        
        textE1 = text1();
        textE1.setText("ETAT1");
        textE1.setSize(10, 30);
        textE1.setForeground(Color.RED);
        textE1.setBounds(150, 260, 200, 200);
        this.add(textE1);
        
        textE2 = text1();
        textE2.setText("ETAT2");
        textE2.setSize(10, 30);
        textE2.setForeground(Color.RED);
        textE2.setBounds(550, 260, 200, 200);
        this.add(textE2);
        
        textE3 = text1();
        textE3.setText("ETAT3");
        textE3.setSize(10, 30);
        textE3.setForeground(Color.RED);
        textE3.setBounds(950, 260, 200, 200);
        this.add(textE3);
        
    }
    
    public JLabel text1(){
		 JLabel label = new JLabel("My label");
		 label.setPreferredSize(new Dimension(100,100));		 
		 label.setFont(new Font("Consolas",1,30));
		 return label;
    }
    
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Stroke stroke = new BasicStroke(10f);

        g2d.setStroke(stroke);
        g2d.draw(new Line2D.Double(400d, 0d, 400d, 500d));
        g2d.setStroke(stroke);
        g2d.draw(new Line2D.Double(800d, 0d, 800d, 500d));
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
 
    
    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Affichage().setVisible(true);
                //String d = "5";
                //textE1.setText(d);
            }
        });
    }
}