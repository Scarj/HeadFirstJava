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
 * @author evgeniy.scherbakov@novardis.com
 */
public class SimpleDotCom
{
  int[] locationCells;
  int numOfHits = 0;

  String checkYourself(String stringGuess)
  {
    int guess = Integer.parseInt(stringGuess);
    String result = "Мимо";

    for (int cell : locationCells)
    {
      if (guess == cell)
      {
        result = "Попал";
        numOfHits++;
        break;
      }
    }

    if (numOfHits == locationCells.length)
    {
      result = "Потопил";
    }

    System.out.println(result);

    return result;
  }

  void setLocationCells(int[] loc)
  {
    locationCells = loc;
  }
}
