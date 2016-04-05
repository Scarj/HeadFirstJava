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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author evgeniy
 */
public class TwoButtons
{
  private JFrame jFrame;
  private JLabel jLabel;

  public static void main(String[] args)
  {
    TwoButtons twoButtons = new TwoButtons();
    twoButtons.go();
  }

  private void go()
  {
    jFrame = new JFrame();

    JButton labelButton = new JButton("Change label");
    labelButton.addActionListener(new LabelListener());

    JButton colorButton = new JButton("Change color");
    colorButton.addActionListener(new ColorListener());

    jLabel = new JLabel("I'm label!");
    JPanel myDrawPanel = new MyDrawPanel();

    jFrame.getContentPane().add(BorderLayout.CENTER, myDrawPanel);
    jFrame.getContentPane().add(BorderLayout.SOUTH, colorButton);
    jFrame.getContentPane().add(BorderLayout.WEST, jLabel);
    jFrame.getContentPane().add(BorderLayout.EAST, labelButton);

    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setSize(500, 500);
    jFrame.setVisible(Boolean.TRUE);
  }

  private class LabelListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      jLabel.setText("Ouch!");
    }
  }

  private class ColorListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      jFrame.repaint();
    }
  }
}
