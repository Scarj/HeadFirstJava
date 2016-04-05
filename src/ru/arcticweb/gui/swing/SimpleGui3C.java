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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author evgeniy
 */
public class SimpleGui3C implements ActionListener
{
  private JFrame jFrame;

  public static void main(String[] args)
  {
    SimpleGui3C simpleGui3C = new SimpleGui3C();
    simpleGui3C.go();
  }

  private void go()
  {
    jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setSize(300, 300);
    jFrame.setVisible(Boolean.TRUE);
    JButton jButton = new JButton("click me!");
    jButton.addActionListener(this);
    MyDrawPanel jPanel = new MyDrawPanel();
    jFrame.getContentPane().add(BorderLayout.SOUTH, jButton);
    jFrame.getContentPane().add(BorderLayout.CENTER, jPanel);
  }

  @Override
  public void actionPerformed(ActionEvent event)
  {
    System.out.println("repaint");
    jFrame.repaint();
  }
}
