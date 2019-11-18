/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Controller;

/**
 * IController interface. Only has one method (execute()) that will tell the view to display the
 * Settlers of Catan board with optimal hex.
 */

public interface IController {

  /**
   * Method that runs the program, and passes all needed information from the model to the view.
   * @Name: execute()
   */
  void execute();
}
