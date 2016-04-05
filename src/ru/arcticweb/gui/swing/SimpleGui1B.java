/*********************************************************************
 * The Initial Developer of the content of this file is NOVARDIS.
 * All portions of the code written by NOVARDIS are property of
 * NOVARDIS. All Rights Reserved.
 * <p/>
 * NOVARDIS
 * Detskaya st. 5A, 199106
 * Saint Petersburg, Russian Federation
 * Tel: +7 (812) 331 01 71
 * Fax: +7 (812) 331 01 70
 * www.novardis.com
 * <p/>
 * (c) 2015 by NOVARDIS
 *********************************************************************/

package ru.arcticweb.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class SimpleGui1B implements ActionListener
{
  private JButton button;

  public static void main(String[] args)
  {
    SimpleGui1B gui = new SimpleGui1B();
    gui.go();
  }

  private void go()
  {
    JFrame frame = new JFrame();
    button = new JButton("click me");

    button.addActionListener(this);

    frame.getContentPane().add(button);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(Boolean.TRUE);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    button.setText("I've been clicked!");
  }
}
