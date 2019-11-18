/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Controller;

/**
 * Our Controller class. Implements IController. Serves to pass information from model to view to
 * vice versa.
 */

import Model.SettlersModel;
import View.IView;

public class Controller implements IController {
  private final SettlersModel model;
  private final IView view;

  /**
   * @Name: Controller constructor.
   * @param: SettlersModel model
   * @param: IView view
   * @throws: IllegalArgumentException if model or view are null
   */
  public Controller(SettlersModel model, IView view) throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Can't have a null model or view!");
    }
    this.model = model;
    this.view = view;
  }

  @Override
  public void execute() {
    this.view.render(model.getTilesList(), model.getOptimalVertex(),
            model.getOptimalVertexCoordinates());
  }
}
