/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.util.List;

/**
 * IVertex interface. Requires all IVertex classes to implement these methods.
 */

public interface IVertex {

  /**
   * Allows us to add tiles to the vertex.
   * @Name: addTile()
   * @param: an ITile tile, the tile we want to add to the vertex
   * @Return: none
   */
  void addTile(ITile tile);

  /**
   * Returns the vertex's list of ITiles.
   * @Name: getTiles()
   * @param: none
   * @Return: a list of ITiles, the tiles that that vertex has. Returns a copy.
   */
  List<ITile> getTiles();

  /**
   * Getter for the Vertex's ID.
   * @Name: getVertexID()
   * @param: none
   * @Return: an int, the Vertex's unique ID.
   */
  int getVertexID();
}
