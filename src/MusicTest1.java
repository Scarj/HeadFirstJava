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

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class MusicTest1
{
  public static void main(String[] args)
  {
    MusicTest1 mt = new MusicTest1();
    mt.play();
  }

  public void play()
  {
    try
    {
      Sequencer sequencer = MidiSystem.getSequencer();
      System.out.println("Мы получили синтезатор");
    }
    catch (MidiUnavailableException e)
    {
      System.out.println("Неудача!");
    }

  }
}
