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

import javax.sound.midi.*;

/**
 * @author evgeniy
 */
public class MiniMusicPlayer2 implements ControllerEventListener
{
  public static void main(String[] args)
  {
    MiniMusicPlayer2 miniMusicPlayer2 = new MiniMusicPlayer2();
    miniMusicPlayer2.go();
  }

  private void go()
  {
    try
    {
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();

      int[] events = {127};
      sequencer.addControllerEventListener(this, events);

      Sequence sequence = new Sequence(Sequence.PPQ, 4);
      Track track = sequence.createTrack();

      for (int i = 5; i < 61; i += 4)
      {
        track.add(createEvent(144, 1, i, 100, i));
        track.add(createEvent(176, 1, 127, 0, i));
        track.add(createEvent(128, 1, i, 100, i + 2));
      }

      sequencer.setSequence(sequence);
      sequencer.setTempoInBPM(220);
      sequencer.start();
    }
    catch (MidiUnavailableException | InvalidMidiDataException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void controlChange(ShortMessage event)
  {
    System.out.println("Ля!");
  }
}
