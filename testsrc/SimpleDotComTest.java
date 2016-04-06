import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

public class SimpleDotComTest
{

  private SimpleDotCom dot;
  private int[] locations;
  private String userGuess;

  @Before
  public void setUp() throws Exception
  {
    dot = new SimpleDotCom();
    locations = new int[] {2, 3, 4};
    userGuess = "2";
  }

  @Test
  public void testCheckYourself() throws Exception
  {
    dot.setLocationCells(locations);
    String result = dot.checkYourself(userGuess);
    Assert.assertEquals("Попал", result);
  }
}