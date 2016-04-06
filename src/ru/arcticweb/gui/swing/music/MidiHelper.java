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

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * @author evgeniy
 */
public class MidiHelper
{
  public static MidiEvent createEvent(int command, int channel, int one, int two, long tick)
  {
    MidiEvent midiEvent = null;
    try
    {
      ShortMessage message = new ShortMessage();
      message.setMessage(command, channel, one, two);
      midiEvent = new MidiEvent(message, tick);
    }
    catch (InvalidMidiDataException e)
    {
      e.printStackTrace();
    }
    return midiEvent;
  }
}
