/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package View;

import java.awt.geom.Point2D;
import java.util.List;

import Model.ITile;
import Model.IVertex;

/**
 * Our IView interface. All IViews should implement this method.
 */

public interface IView {

  /**
   * Our method that takes the information from the controller / model and displays it
   * @Name: render()
   * @param: tileList as a List, the tiles we want to draw
   * @param: optimalVertex as an IVertex, the vertex we want to identify
   * @param: optimalVertexCoordinates as a Point2D, the coordinates of the ideal vertex
   * @Return: none
   */
  void render(List<ITile> tileList, IVertex optimalVertex, Point2D optimalVertexCoordinates);
}
