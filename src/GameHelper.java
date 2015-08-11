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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class GameHelper
{
  public String getUserInput(String promt)
  {
    String inputLine = null;
    System.out.println(promt + " ");
    try
    {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0)
      {
        return null;
      }
    }
    catch (IOException e)
    {
      System.out.println("IOException: " + e);
    }
    return inputLine;
  }
}
