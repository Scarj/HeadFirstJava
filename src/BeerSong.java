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
public class BeerSong
{
  public static void main(String[] args)
  {
    int beerNum = 3;
    String word = "бутылок (бутылки)";

    while (beerNum > 0)
    {
      System.out.println(beerNum + " " + word + " пива на стене");
      System.out.println(beerNum + " " + word + " пива.");
      System.out.println("Возьми одну.");
      System.out.println("Пусти по кругу.");
      beerNum = beerNum - 1;
      if (beerNum == 1)
      {
        word = "бутылка";
      }
      if (beerNum > 0)
      {
        System.out.println(beerNum + " " + word + " пива на стене");
      }
      else
      {
        System.out.println("Нет бутылок пива на стене.");
      }
    }
  }
}
