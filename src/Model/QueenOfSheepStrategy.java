/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.util.List;

/**
 * Queen of Sheep Strategy class. Implements ICatanStrategy and gives the user the optimal vertex
 * given that strategy. This strategy is based monopolizing all of the sheep with the 2:1 sheep
 * port. Because few other players are likely to go for sheep, this player just controls all of
 * it and trades it as needed to win whatever way they can.
 */

public class QueenOfSheepStrategy implements ICatanStrategy {

  // Initialize the values that each resource type has for this given strategy
  private double OREVALUE = 0.0 / 54;
  private double WHEATVALUE = 12.0 / 54;
  private double SHEEPVALUE = 36.0 / 54;
  private double BRICKVALUE = 3.0 / 54;
  private double LUMBERVALUE = 3.0 / 54;
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
