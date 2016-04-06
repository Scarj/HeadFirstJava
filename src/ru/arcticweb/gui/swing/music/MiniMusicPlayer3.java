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

package ru.arcticweb.gui.swing.music;

import static ru.arcticweb.gui.swing.music.MidiHelper.createEvent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author evgeniy
 */
public class MiniMusicPlayer3
{
  private static JFrame jFrame = new JFrame("Мой первый музыкальный клип");
  private static MyDrawPanel myDrawPanel;


  public static void main(String[] args)
  {
    MiniMusicPlayer3 musicPlayer3 = new MiniMusicPlayer3();
    musicPlayer3.go();
  }

  private void setUpGUI()
  {
    myDrawPanel = new MyDrawPanel();
    jFrame.setContentPane(myDrawPanel);
    jFrame.setBounds(30, 30, 300, 300);
    jFrame.setVisible(Boolean.TRUE);
  }

  private void go()
  {
    setUpGUI();

    try
    {
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequencer.addControllerEventListener(myDrawPanel, new int[] {127});
      Sequence sequence = new Sequence(Sequence.PPQ, 4);
      Track track = sequence.createTrack();

      int r = 0;
      for (int i = 5; i < 61; i += 4)
      {
        r = (int) ((Math.random() * 50) + 1);
        track.add(createEvent(ShortMessage.NOTE_ON, 1, r, 100, i));
        track.add(createEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, i));
        track.add(createEvent(ShortMessage.NOTE_OFF, 1, r, 100, i + 2));
      }

      sequencer.setSequence(sequence);
      sequencer.start();
      sequencer.setTempoInBPM(220);
    }
    catch (MidiUnavailableException | InvalidMidiDataException e)
    {
      e.printStackTrace();
    }
  }

  private static class MyDrawPanel extends JPanel implements ControllerEventListener
  {
    boolean message = false;

    @Override
    public void controlChange(ShortMessage event)
    {
      message = true;
      repaint();
    }

    @Override
    protected void paintComponent(Graphics graph)
    {
      if (message)
      {
        Graphics2D graphics = (Graphics2D) graph;

        int r = (int) (Math.random() * 250);
        int g = (int) (Math.random() * 250);
        int b = (int) (Math.random() * 250);
        graphics.setColor(new Color(r, g, b));

        int height = (int) ((Math.random() * 120) + 10);
        int width = (int) ((Math.random() * 120) + 10);

        int x = (int) ((Math.random() * 40) + 10);
        int y = (int) ((Math.random() * 40) + 10);

        graphics.fillRect(x, y, width, height);
        message = false;
      }
    }
  }
}
