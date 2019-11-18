/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

import Controller.Controller;
import Controller.IController;
import Model.SettlersModel;
import Model.SettlersModelImpl;
import Model.StandardBoard;
import Model.StrategyFactory;
import View.IView;
import View.View;

/**
 * Citation for different strategy types: https://www.instructables.com/id/Catan-strategy-guide/
 */

public class Main {
  public static void main(String[] args) {
    SettlersModel model = new SettlersModelImpl(new StandardBoard(),
            StrategyFactory.MakeStrategy(args[0]));
    IView view = new View();
    IController controller = new Controller(model, view);
    controller.execute();
  }
}
