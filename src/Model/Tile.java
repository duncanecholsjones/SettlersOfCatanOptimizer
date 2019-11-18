/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

/**
 * Our Tile class. Represents the hexagonal tiles on the Settlers of Catan board. Will have an
 * TileID, a terrain type, a probability, and a number of pips.
 */

public class Tile implements ITile {

  private final int tileID;
  private final Terrain terrain;
  private final int probability;
  private final int numPips;

  public Tile(int tileID, Terrain terrain, int probability, int numPips) throws IllegalArgumentException {
    // Error checking for invalid input
    if (probability < 2 && !terrain.equals(Terrain.DESERT) || probability > 12) {
      throw new IllegalArgumentException("Can't have a probability less than 2 or greater than " +
              "12!");
    }
    this.tileID = tileID;
    this.terrain = terrain;
    if (this.terrain.equals(Terrain.DESERT)) {
      this.probability = 0;
    } else {
      this.probability = probability;
    }
    this.numPips = numPips;
  }

  @Override
  public int getProbability() {
    return this.probability;
  }

  @Override
  public Terrain getTerrain() {
    return this.terrain;
  }

  @Override
  public int getTileID() {
    return this.tileID;
  }

  @Override
  public int getNumPips() {
    return this.numPips;
  }
}

