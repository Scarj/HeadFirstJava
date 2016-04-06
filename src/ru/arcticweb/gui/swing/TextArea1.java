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
public class TextArea1 implements ActionListener
{

  JTextArea textArea;

  public static void main(String[] args)
  {
    TextArea1 textArea1 = new TextArea1();
    textArea1.go();
  }

  private void go()
  {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JButton button = new JButton("Just click it!");
    button.addActionListener(this);

    textArea = new JTextArea(10, 20);
    textArea.setLineWrap(Boolean.TRUE);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    JPanel panel = new JPanel();
    panel.add(scrollPane);

    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.getContentPane().add(BorderLayout.SOUTH, button);

    frame.setSize(300, 300);
    frame.setVisible(Boolean.TRUE);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    textArea.append("button clicked\n");
  }
}
