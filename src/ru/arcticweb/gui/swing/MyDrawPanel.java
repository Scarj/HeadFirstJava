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

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class MyDrawPanel extends JPanel
{
  @Override
  protected void paintComponent(Graphics g)
  {
    Graphics2D graphics2D = (Graphics2D) g;
    GradientPaint gradientPaint = new GradientPaint(70,70,Color.BLUE,150,150,Color.ORANGE);
    graphics2D.setPaint(gradientPaint);
    g.fillRect(20, 50, 100, 100);
  }
}


