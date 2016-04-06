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

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author evgeniy
 */
public class Button1
{
  public static void main(String[] args)
  {
    Button1 button1 = new Button1();
    button1.go();
  }

  private void go()
  {
    JFrame jFrame = new JFrame();
    JButton jButton = new JButton("Click This!");
    Font bigFont = new Font("serif", Font.BOLD, 22);
    jButton.setFont(bigFont);
    jFrame.getContentPane().add(BorderLayout.NORTH, jButton);
    jFrame.setSize(200, 200);
    jFrame.setVisible(Boolean.TRUE);

    jFrame = new JFrame();

    JButton east = new JButton("East");
    JButton west = new JButton("West");
    JButton north = new JButton("North");
    JButton south = new JButton("South");
    JButton center = new JButton("Center");

    jFrame.getContentPane().add(BorderLayout.EAST, east);
    jFrame.getContentPane().add(BorderLayout.WEST, west);
    jFrame.getContentPane().add(BorderLayout.SOUTH, south);
    jFrame.getContentPane().add(BorderLayout.NORTH, north);
    jFrame.getContentPane().add(BorderLayout.CENTER, center);

    jFrame.setSize(300, 300);
    jFrame.setVisible(Boolean.TRUE);
  }
}
