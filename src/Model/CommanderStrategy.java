/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.util.List;

/**
 * CommanderStrategy class. Implements ICatanStrategy and gives the user the optimal vertex given
 * that strategy. This strategy is based on gathering lots of ore and wheat with the goal of
 * winning by creating cities, getting development cards, and getting largest army. Value of each
 * resource is based on the contribution each resource card has to a Commander victory of 3
 * cities, 2 victory points, and largest army.
 */

public class CommanderStrategy implements ICatanStrategy {

  // Initialize the values that each resource type has for this given strategy
  private double OREVALUE = 15.0 / 39;
  private double WHEATVALUE = 12.0 / 39;
  private double SHEEPVALUE = 6.0 / 39;
  private double BRICKVALUE = 3.0 / 39;
  private double LUMBERVALUE = 3.0 / 39;
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
