/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.util.List;

/**
 * Producer Strategy class. Implements ICatanStrategy and gives the user the optimal vertex given
 * that strategy. This strategy is based on collecting more resources than any other player. It
 * will simply look for the best balance of probabilities and resources so that there are
 * resources of all types coming in. A typical victory involves longest road, an assortment of
 * cities and settlements, and perhaps some development card victory points.
 */

public class ProducerStrategy implements ICatanStrategy {

  // Initialize the values that each resource type has for this given strategy
  private double OREVALUE = 12.0 / 46;
  private double WHEATVALUE = 10.0 / 46;
  private double SHEEPVALUE = 4.0 / 46;
  private double BRICKVALUE = 10.0 / 46;
  private double LUMBERVALUE = 10.0 / 46;
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
