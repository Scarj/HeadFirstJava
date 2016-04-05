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

import javax.sound.midi.*;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class MiniMiniMusicApp
{
  public static void main(String[] args)
  {
    MiniMiniMusicApp mini = new MiniMiniMusicApp();
    mini.play();
  }

  private void play()
  {
    try
    {
      Sequencer player = MidiSystem.getSequencer();
      player.open();

      Sequence sequence = new Sequence(Sequence.PPQ, 4);
      Track track = sequence.createTrack();

      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, 44, 100);
      MidiEvent noteOn = new MidiEvent(a, 5);
      track.add(noteOn);

      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, 44, 100);
      MidiEvent noteOff = new MidiEvent(b, 16);
      track.add(noteOff);

      player.setSequence(sequence);
      player.start();
    }
    catch (MidiUnavailableException | InvalidMidiDataException e)
    {
      e.printStackTrace();
    }
  }
}
