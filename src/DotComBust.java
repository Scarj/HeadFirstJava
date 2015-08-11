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

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class DotComBust
{
  private GameHelper helper = new GameHelper();
  private ArrayList<DotCom> dotComList = new ArrayList<>();
  private int numOfGuesses = 0;

  public static void main(String[] args)
  {
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
  }

  private void setUpGame()
  {
    DotCom one = new DotCom("Pets.com");
    DotCom two = new DotCom("eToys.com");
    DotCom three = new DotCom("Go2.com");
    dotComList.add(one);
    dotComList.add(two);
    dotComList.add(three);

    System.out.println("Ваша цель - потопить три сайта.");
    System.out.println("Pets.com, eToys.com, Go2.com");
    System.out.println("Попытайтесь потопить их за минимальное количество ходов");

    for (DotCom dotComToSet : dotComList)
    {
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    }
  }

  private void startPlaying()
  {
    while (!dotComList.isEmpty())
    {
      String userGuess = helper.getUserInput("Сделайте ход");
      checkUserGuess(userGuess);
    }

    finishGame();
  }

  private void checkUserGuess(String userGuess)
  {
    numOfGuesses++;
    String result = "Мимо";

    for (DotCom dotCom : dotComList)
    {
      result = dotCom.checkYourself(userGuess);
      if (result.equals("Попал"))
      {
        break;
      }
      if (result.equals("Потопил"))
      {
        dotComList.remove(dotCom);
        break;
      }
    }
    System.out.println(result);
  }

  private void finishGame()
  {
    System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
    if (numOfGuesses <= 18)
    {
      System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
      System.out.println("Вы успели выбраться до того , как ваши вложения утонули.");
    }
    else
    {
      System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
      System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
    }
  }
}
