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

/**
 * @author evgeniy
 */
public class DrumKit
{
  boolean topHat = true;
  boolean snare = true;

  void playSnare() {
    System.out.println("бах бах ба-бах");
  }

  void playTopHat() {
    System.out.println("динь динь ди-динь");
  }
}

class DrumKitTestDrive {
  public static void main(String[] args)
  {
    DrumKit drumKit = new DrumKit();
    if(drumKit.snare == true) {
      drumKit.playSnare();
    }
    drumKit.snare = false;
    drumKit.playTopHat();
  }
}
