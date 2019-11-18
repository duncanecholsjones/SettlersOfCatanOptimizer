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
 * Our IDrawingPanel interface. All IDrawingPanels should implement these methods.
 */

public interface IDrawingPanel {

  /**
   * The method that will have our view draw the shapes to represent what the Catan board should
   * look like.
   * @Name: drawShapes()
   * @param: tilesToDraw as a List, the tiles we want to draw
   * @param: optimalVertexToDraw as an IVertex, the vertex we want to identify
   * @param: optimalVertexCoordinates as a Point2D, the coordinates of the ideal vertex
   * @Return: none
   */
  void drawShapes(List<ITile> tilesToDraw, IVertex optimalVertexToDraw,
                  Point2D optimalVertexCoordinates);
}
