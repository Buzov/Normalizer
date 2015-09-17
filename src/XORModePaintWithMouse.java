import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class XORModePaintWithMouse extends JFrame {
  int chsX = 100, chsY = 100;

  public static void main(String[] a) {
    XORModePaintWithMouse f = new XORModePaintWithMouse();
    f.setSize(300, 300);
    f.setVisible(true);
  }

  XORModePaintWithMouse() {
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        chsX = x - 10;
        chsY = y - 10;
        repaint();
      }
    });
  }
  public void paint(Graphics g) {
    g.drawLine(0, 0, 100, 100);
    g.drawLine(0, 100, 100, 0);
    g.setColor(Color.blue);
    g.drawLine(40, 25, 250, 180);
    g.drawLine(75, 90, 400, 400);
    g.setColor(Color.green);
    g.drawString("Captha", chsX, chsX);
    g.drawString("Captha", chsX+50, chsX);
    g.drawString("Captha", chsX-50, chsX);
   
    
    

    // xor cross hairs
    g.setXORMode(Color.black);
    g.drawLine(chsX - 10, chsY, chsX + 10, chsY);
    g.drawLine(chsX, chsY - 10, chsX, chsY + 10);
    g.setPaintMode();
  }
}