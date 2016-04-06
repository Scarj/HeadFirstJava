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

package ru.arcticweb.gui.swing.music.beatbox;

import static ru.arcticweb.gui.swing.music.MidiHelper.createEvent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.*;
import javax.swing.*;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class BeatBox
{
  private JPanel mainPanel;
  private List<JCheckBox> checkBoxList;
  private Sequencer sequencer;
  private Sequence sequence;
  private Track track;
  private JFrame theFrame;

  private String[] instrumentNames =
          {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "Hight Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell",
                  "Vibraslap", "Low-mid Tom", "Hight Agogo", "Open Hi Conga"};
  private int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

  public static void main(String[] args)
  {
    new BeatBox().buildGUI();
  }

  private void buildGUI()
  {
    theFrame = new JFrame("Cyber BeatBox");
    theFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    BorderLayout layout = new BorderLayout();
    JPanel background = new JPanel(layout);
    background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    checkBoxList = new ArrayList<>();
    Box buttonBox = new Box(BoxLayout.Y_AXIS);

    JButton start = new JButton("Start");
    start.addActionListener(new MyStartListener());
    buttonBox.add(start);

    JButton stop = new JButton("Stop");
    stop.addActionListener(new MyStopListener());
    buttonBox.add(stop);

    JButton upTempo = new JButton("Tempo Up");
    upTempo.addActionListener(new MyUpTempoListener());
    buttonBox.add(upTempo);

    JButton downTempo = new JButton("Tempo Down");
    downTempo.addActionListener(new MyDownTempoListener());
    buttonBox.add(downTempo);

    Box nameBox = new Box(BoxLayout.Y_AXIS);
    for (String instrumentName : instrumentNames)
    {
      nameBox.add(new Label(instrumentName));
    }

    background.add(BorderLayout.EAST, buttonBox);
    background.add(BorderLayout.WEST, nameBox);

    theFrame.getContentPane().add(background);

    GridLayout grid = new GridLayout(16, 16);
    grid.setVgap(1);
    grid.setHgap(2);

    mainPanel = new JPanel(grid);
    background.add(BorderLayout.CENTER, mainPanel);

    for (int i = 0; i < 256; i++)
    {
      JCheckBox checkBox = new JCheckBox();
      checkBox.setSelected(Boolean.FALSE);
      checkBoxList.add(checkBox);
      mainPanel.add(checkBox);
    }

    setUpMidi();

    theFrame.setBounds(50, 50, 300, 300);
    theFrame.pack();
    theFrame.setVisible(Boolean.TRUE);
  }

  private void setUpMidi()
  {
    try
    {
      sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequence = new Sequence(Sequence.PPQ, 4);
      track = sequence.createTrack();
      sequencer.setTempoInBPM(1700);
    }
    catch (MidiUnavailableException | InvalidMidiDataException e)
    {
      e.printStackTrace();
    }
  }

  private void buildTrackAndStart()
  {
    int[] trackList = null;
    sequence.deleteTrack(track);
    track = sequence.createTrack();

    for (int i = 0; i < 16; i++)
    {
      trackList = new int[16];
      int key = instruments[i];

      for (int j = 0; j < 16; j++)
      {
        JCheckBox checkBox = checkBoxList.get(j + (16 * i));
        if (checkBox.isSelected())
        {
          trackList[j] = key;
        }
        else
        {
          trackList[j] = 0;
        }
      }

      makeTracks(trackList);
      track.add(createEvent(176, 1, 127, 0, 16));
    }

    track.add(createEvent(192, 9, 1, 9, 15));

    try
    {
      sequencer.setSequence(sequence);
      sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
      sequencer.start();
      sequencer.setTempoInBPM(120);
    }
    catch (InvalidMidiDataException e)
    {
      e.printStackTrace();
    }

  }

  private void makeTracks(int[] trackList)
  {
    for (int key : trackList)
    {
      if (key != 0)
      {
        track.add(createEvent(144, 9, key, 100, key));
        track.add(createEvent(128, 9, key, 100, key + 2));
      }
    }
  }

  private class MyStartListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      buildTrackAndStart();
    }
  }

  private class MyStopListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      sequencer.stop();
    }
  }

  private class MyUpTempoListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      float tempoFactor = sequencer.getTempoFactor();
      sequencer.setTempoFactor((float) (tempoFactor * 1.03));
    }
  }

  private class MyDownTempoListener implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      float tempoFactor = sequencer.getTempoFactor();
      sequencer.setTempoFactor((float) (tempoFactor * 0.97));
    }
  }
}
