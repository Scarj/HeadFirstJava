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
public class PhraseOMatic
{
  public static void main(String[] args)
  {
    String[] wordListOne =
            {"круглосуточный", "трех-звенный", "30000-футовый", "взаимный", "обоюдный выигрыш", "фронтэнд", "на основе веб-технологий", "проникающий", "умный", "шесть сигм",
                    "метод критического пути", "диинамичный"};
    String[] wordListTwo =
            {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный", "распределенный", "фирменный", "нестандартный ум", "позиционированный", "сетевой",
                    "сфокусированный", "использованный с выгодой", "выровненный", "нацеленный на", "общий", "совместный", "ускоренный"};
    String[] wordListThree =
            {"процесс", "пункт разгрузки", "выход из положения", "тип структуры", "талант", "подход", "уровень завоеванного внимания", "портал", "период времени", "обзор",
                    "образец", "пункт следования"};

    int oneLength = wordListOne.length;
    int twoLength = wordListTwo.length;
    int threeLength = wordListThree.length;

    int rand1 = (int) (Math.random() * oneLength);
    int rand2 = (int) (Math.random() * twoLength);
    int rand3 = (int) (Math.random()*threeLength);

    String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

    System.out.println("Все что нам нужно, - это " + phrase);
  }
}
