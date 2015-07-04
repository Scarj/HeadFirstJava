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
public class MovieTestDrive
{
  public static void main(String[] args)
  {
    Movie one = new Movie();
    one.title = "Как Прогореть на Акциях";
    one.genre = "Трагедия";
    one.rating = -2;
    one.playIt();

    Movie two = new Movie();
    two.title="Потерянные в офисе";
    two.genre = "Комедия";
    two.rating = 5;
    two.playIt();

    Movie three = new Movie();
    three.title = "Байт-клуб";
    three.genre = "Трагедия, но в целом веселая";
    three.playIt();
  }
}
