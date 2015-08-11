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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class SimpleDotComGame
{

  public static void main(String[] args)
  {
    int numOfGuesses = 0;
    GameHelper helper = new GameHelper();
    DotCom theDotCom = new DotCom();
    Integer randomNum = (int) (Math.random() * 5);
    ArrayList<String> locations = new ArrayList<>();
    locations.add(String.valueOf(randomNum));
    locations.add(String.valueOf(randomNum+1));
    locations.add(String.valueOf(randomNum+2));

    theDotCom.setLocationCells(locations);
    boolean isAlive = true;

    while (isAlive)
    {
      String guess = helper.getUserInput("Введите число");
      String result = theDotCom.checkYourself(guess);
      numOfGuesses++;
      if (result.equals("Потопил"))
      {
        isAlive = false;
        System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
      }
    }
  }
}
