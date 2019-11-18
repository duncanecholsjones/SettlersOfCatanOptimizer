/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

/**
 * Our Vertex class. A vertex is the intersection between tiles. A Vertex object is necessary
 * because we play our settlements on vertices, not tiles. Therefore, each vertex should have a
 * list of the tiles that comprise it as well as an ID.
 */

import java.util.ArrayList;
import java.util.List;

public class Vertex implements IVertex {

  private final int vertexID;
  private final List<ITile> tiles;
  // Use a singleton here to only allow 3 tiles to be added to each vertex
  private int singleton;

  public Vertex(int vertexID) {
    // Initialize each Vertex's list of tiles to 3 as that will be the maximum possible number of
    // tiles per vertex.
    this.tiles = new ArrayList<>(3);
    this.vertexID = vertexID;
    this.singleton = 0;

  }

  public void addTile(ITile tile) throws IllegalArgumentException {
    if (tile == null) {
      throw new IllegalArgumentException("Model.Tile is null.");
    }
    // Check to ensure that no more than 3 tiles have been added to this vertex
    if (this.singleton <= 3) {
      this.tiles.add(tile);
      this.singleton++;
    }
  }

  @Override
  public List<ITile> getTiles() {
    return new ArrayList<>(this.tiles);
  }

  @Override
  public int getVertexID() {
    return this.vertexID;
  }

  @Override
  public String toString() {
    String myString = "vertex " + this.vertexID + " with tiles: \n";
    for (ITile tile : this.tiles) {
      myString += "a " + tile.getTerrain() + " with roll " + tile.getProbability() +
              " \n";
    }
    return myString;
  }
}
