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

package ru.arcticweb.gui.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author evgeniy.scherbakov@novardis.com
 */
public class SimpleGuiFx1B extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    primaryStage.setTitle("Hello world!");
    Button button = new Button();
    button.setText("click me!");
    button.setOnAction(new ButtonClickHandler());
    StackPane root = new StackPane();
    root.getChildren().add(button);
    primaryStage.setScene(new Scene(root, 300, 300));
    primaryStage.show();
  }

  private class ButtonClickHandler implements EventHandler<ActionEvent>
  {
    @Override
    public void handle(ActionEvent actionEvent)
    {
      if (actionEvent.getSource() instanceof Button)
      {
        Button button = (Button) actionEvent.getSource();
        button.setText("I've been clicked!");
      }
    }
  }
}
