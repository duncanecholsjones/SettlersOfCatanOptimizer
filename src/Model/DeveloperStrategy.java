/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.util.List;

/**
 * Developer Strategy class. Implements ICatanStrategy and gives the user the optimal vertex given
 * that strategy. This strategy is based on getting lots of development cards. Therefore, this
 * strategy prioritizes ore, wheat, and sheep. A typical victory for this strategy is 3 or 4
 * victory point cards, largest army, and then an assortment of cities and settlements.
 */

public class DeveloperStrategy implements ICatanStrategy {

  // Initialize the values that each resource type has for this given strategy
  private double OREVALUE = 17.0 / 42;
  private double WHEATVALUE = 15.0 / 42;
  private double SHEEPVALUE = 10.0 / 42;
  private double BRICKVALUE = 0.0 / 42;
  private double LUMBERVALUE = 0.0 / 42;
  private double DESERTVALUE = 0.0;

  @Override
  public IVertex getOptimalVertexForStrategy(List<IVertex> board) {
    double maxVertexValue = 0;
    IVertex maxVertex = null;
    for (IVertex vertex : board) {
      // Accumulate value of vertex here using that strategy's given values
      double currentVertexValue = 0.0;
      List<ITile> tiles = vertex.getTiles();
      for (ITile tile : tiles) {
        if (tile.getTerrain().equals(Terrain.ORE)) {
          currentVertexValue += tile.getNumPips() * (OREVALUE);
        } else if (tile.getTerrain().equals(Terrain.WHEAT)) {
          currentVertexValue += tile.getNumPips() * (WHEATVALUE);
        } else if (tile.getTerrain().equals(Terrain.SHEEP)) {
          currentVertexValue += tile.getNumPips() * (SHEEPVALUE);
        } else if (tile.getTerrain().equals(Terrain.BRICK)) {
          currentVertexValue += tile.getNumPips() * (BRICKVALUE);
        } else if (tile.getTerrain().equals(Terrain.LUMBER)) {
          currentVertexValue += tile.getNumPips() * (LUMBERVALUE);
          // Conditional for desert
        } else {
          currentVertexValue += DESERTVALUE;
        }
      }
      if (currentVertexValue > maxVertexValue) {
        maxVertexValue = currentVertexValue;
        maxVertex = vertex;

      }
    }
    return maxVertex;
  }
}
