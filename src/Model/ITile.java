/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

/**
 * ITile interface. Requires all tiles to implement these methods.
 */

public interface ITile {

  /**
   * Getter for tile's probability
   * @Name: getProbability()
   * @return: an int, the probability for that given tile
   */
  int getProbability();

  /**
   * Getter for tile's terrain type
   * @Name: getTerrain()
   * @return: an enum, the terrain type
   */
  Terrain getTerrain();

  /**
   * Getter for the tile's ID
   * @Name: getTileID()
   * @return: an int, the tile's unique ID
   */
  int getTileID();

  /**
   * Getter for the tile's number of pips (i.e. a tile with a probability of 6 would return 5 pips)
   * @Name: getNumPips()
   * @return: an int, the number of pips that tile has
   */
  int getNumPips();
}
