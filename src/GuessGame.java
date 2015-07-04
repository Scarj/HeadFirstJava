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
public class GuessGame
{
  private Player p1;
  private Player p2;
  private Player p3;

  public void startGame()
  {
    p1 = new Player();
    p2 = new Player();
    p3 = new Player();

    int guessp1 = 0;
    int guessp2 = 0;
    int guessp3 = 0;

    boolean p1iRight = false;
    boolean p2iRight = false;
    boolean p3iRight = false;

    int targetNumer = (int) (Math.random() * 10);
    System.out.println("Я загадываю число от 0 до 9...");

    while (true)
    {
      System.out.println("Число, которое нужно угадать, - " + targetNumer);

      p1.guess();
      p2.guess();
      p3.guess();

      guessp1 = p1.number;
      System.out.println("Первый игрок думает что это " + guessp1);
      guessp2 = p2.number;
      System.out.println("Второй игрок думает что это " + guessp2);
      guessp3 = p3.number;
      System.out.println("Третий игрок думает что это " + guessp3);

      if (guessp1 == targetNumer)
      {
        p1iRight = true;
      }
      if (guessp2 == targetNumer)
      {
        p2iRight = true;
      }
      if (guessp3 == targetNumer)
      {
        p3iRight = true;
      }

      if (p1iRight || p2iRight || p3iRight)
      {
        System.out.println("У нас есть победитель!");
        System.out.println("Первый игрок угадал? " + p1iRight);
        System.out.println("Второй игрок угадал? " + p2iRight);
        System.out.println("Третий игрок угадал? " + p3iRight);
        break;
      } else {
        System.out.println("Игроки должны попробовать еще раз.");
      }
    }
  }
}
