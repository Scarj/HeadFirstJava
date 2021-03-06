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
public class DotCom
{
  private ArrayList<String> locationCells;
  private String name;

  public DotCom()
  {
  }

  public DotCom(String name)
  {
    this.setName(name);
  }

  String checkYourself(String userInput)
  {
    String result = "Мимо";
    int index = locationCells.indexOf(userInput);

    if (index >= 0)
    {
      locationCells.remove(index);

      if (locationCells.isEmpty())
      {
        result = "Потопил";
        System.out.println("Ой! Вы потопили " + name + " :( ");
      }
      else
      {
        result = "Попал";
      }
    }
    return result;
  }

  public void setLocationCells(ArrayList<String> locationCells)
  {
    this.locationCells = locationCells;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
