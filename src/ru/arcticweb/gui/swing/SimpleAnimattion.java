/*********************************************************************
 * The Initial Developer of the content of this file is NOVARDIS.
 * All portions of the code written by NOVARDIS are property of
 * NOVARDIS. All Rights Reserved.
 * <p>
 * NOVARDIS
 * Detskaya st. 5A, 199106
 * Saint Petersburg, Russian Federation
 * Tel: +7 (812) 331 01 71
 * Fax: +7 (812) 331 01 70
 * www.novardis.com
 * <p>
 * (c) 2016 by NOVARDIS
 *********************************************************************/

package ru.arcticweb.gui.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author evgeniy
 */
public class SimpleAnimattion
{
  private int x = 70;
  private int y = 70;

  public static void main(String[] args)
  {
    SimpleAnimattion simpleAnimattion = new SimpleAnimattion();
    simpleAnimattion.go();
  }

  private void go()
  {
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JPanel drawPanel = new MyDrawInnerPanel();
    jFrame.getContentPane().add(drawPanel);
    jFrame.setSize(300, 300);
    jFrame.setVisible(Boolean.TRUE);

    for (int i = 0; i < 130; i++)
    {
      x++;
      y++;
      drawPanel.repaint();

      try
      {
        Thread.sleep(50);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  private class MyDrawInnerPanel extends JPanel
  {
    @Override
    protected void paintComponent(Graphics graphics)
    {
      graphics.setColor(Color.WHITE);
      graphics.fillRect(0,0,this.getWidth(),this.getHeight());

      graphics.setColor(Color.GREEN);
      graphics.fillOval(x, y, 40, 40);
    }
  }
}
