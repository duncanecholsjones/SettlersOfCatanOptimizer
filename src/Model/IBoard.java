/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * IBoard interface. Requires all boards a user may want to use to implement these methods.
 */

public interface IBoard {

  /**
   * Getter for our list of IVertices.
   * @Name: getVertices()
   * @return: a copy of the List of IVertex's.
   */
  List<IVertex> getVertices();

  /**
   * Getter for our list of ITiles.
   * @Name: getTiles()
   * @return: a copy of the list of ITiles.
   */
  List<ITile> getTiles();

  /**
   * Getter for a given Vertex's Point2D coordinates.
   * @Name: getVertexCoordinates()
   * @param: vertexID, the int vertex identifier
   * @return: the IVertex's x and y coordinates as a Point2D
   */
  Point2D getVertexCoordinates(int vertexID);
}
