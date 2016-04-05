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
public class MiniMusicCmdLine
{
  public static void main(String[] args)
  {
    MiniMusicCmdLine mini = new MiniMusicCmdLine();
    if (args.length < 2)
    {
      System.out.println("Не забудьте аргументы для инструмента и ноты");
    }
    else
    {
      int instrument = Integer.parseInt(args[0]);
      int note = Integer.parseInt(args[1]);
      mini.play(instrument, note);
    }
  }

  private void play(int instrument, int note)
  {
    try
    {
      Sequencer player = MidiSystem.getSequencer();
      player.open();
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      MidiEvent event = null;

      ShortMessage first = new ShortMessage();
      first.setMessage(192, 1, instrument, 0);
      MidiEvent changeInstrument = new MidiEvent(first, 1);
      track.add(changeInstrument);

      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, note, 100);
      MidiEvent noteOn = new MidiEvent(a, 1);
      track.add(noteOn);

      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, note, 100);
      MidiEvent noteOff = new MidiEvent(b, 1);
      track.add(noteOff);

      player.setSequence(seq);
      player.start();
    }
    catch (MidiUnavailableException | InvalidMidiDataException e)
    {
      e.printStackTrace();
    }
  }
}
