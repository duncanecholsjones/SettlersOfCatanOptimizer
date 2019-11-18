/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.util.List;

/**
 * Interface for any given ICatanStrategy that a user may want to implement. Uses Strategy
 * Pattern to allow for easy plug-and-play.
 */

public interface ICatanStrategy {

  /**
   * Returns the optimal vertex on the board for that user-selected strategy.
   * @Name: getOptimalVertexForStrategy()
   * @param: vertexList, the list of IVertex's given from the board
   * @return: an IVertex, the optimal vertex to place the first settlement on
   */
  IVertex getOptimalVertexForStrategy(List<IVertex> vertexList);
}
