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
import java.util.Iterator;

/**
 * @author evgeniy
 */
public class DogTestDrive
{
  public static void main(String[] args)
  {
    Dog dog1 = new Dog();
    dog1.size = 70;
    Dog dog2 = new Dog();
    dog2.size = 8;
    Dog dog3 = new Dog();
    dog3.size = 35;


    dog1.bark();
    dog2.bark();
    dog3.bark();


    ArrayList<String> strings = new ArrayList<>(Arrays.asList("hello", "world", "third"));
  }
}
