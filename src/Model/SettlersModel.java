/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * SettlersModel interface. The interface for all models of this program.
 */

public interface SettlersModel {

  /**
   * Returns the optimal vertex for some given ICatanStrategy strategy.
   * @Name: getOptimalVertex()
   * @return: an IVertex, the optimal vertex on the board
   */
  IVertex getOptimalVertex();

  /**
   * Getter for the optimal Vertex's coordinates (so that it may be drawn on the view).
   * @Name: getOptimalVertexCoordinates()
   * @return: a Point2D, the coordinates of the optimal vertex
   */
  Point2D getOptimalVertexCoordinates();

  /**
   * Getter for the list of ITiles so that we may pass it to the view.
   * @Name: getTilesList()
   * @return: a list of ITiles, the tiles for the board. Returns a copy.
   */
  List<ITile> getTilesList();

}
