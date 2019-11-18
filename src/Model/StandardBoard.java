/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Our StandardBoard concrete class. Holds much of the logic and information for what our Settlers
 * of Catan board actually looks like. In this particular class, our board is a standard 19-tile
 * board with randomized terrains and probabilities. Implements IBoard.
 */

public class StandardBoard implements IBoard {

  private final int NUMTILES;
  private final int NUMVERTICES;
  private final List<IVertex> board;
  private List<Integer> probabilityList;
  private List<Terrain> terrainList;
  private List<ITile> tileList;
  private Point2D vertexCoordinates[];


  /**
   * @Name: StandardBoard constructor.
   */
  public StandardBoard() {

    // Intiialize NUMTILES to 19 and NUMVERTICES to 54
    this.NUMTILES = 19;
    this.NUMVERTICES = 54;

    // Create our list of probabilities in a standard Catan game
    int[] initialProbabilityList = new int[]{2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11,
            11, 12};
    probabilityList = new ArrayList<>(NUMTILES);
    for (int num : initialProbabilityList) {
      this.probabilityList.add(num);
    }

    // Create our list of terrains in a standard Catan game
    Terrain[] initialTerrainList = new Terrain[]{Terrain.DESERT, Terrain.ORE, Terrain.ORE,
            Terrain.ORE, Terrain.BRICK, Terrain.BRICK, Terrain.BRICK, Terrain.SHEEP,
            Terrain.SHEEP, Terrain.SHEEP, Terrain.SHEEP, Terrain.LUMBER, Terrain.LUMBER,
            Terrain.LUMBER, Terrain.LUMBER, Terrain.WHEAT, Terrain.WHEAT, Terrain.WHEAT,
            Terrain.WHEAT};

    terrainList = new ArrayList<>(NUMTILES);
    this.terrainList.addAll(Arrays.asList(initialTerrainList));

    // Create our list of Tiles that will use private methods to pair each random tile with a
    // random probability. Pairing removes that element from each list after it is used. If desert,
    // probability is zero. There should be 19 total times in our list.
    tileList = new ArrayList<>(NUMTILES);
    for (int i = 0; i < this.NUMTILES; i++) {
      Terrain randomTerrain = getRandomTerrain();
      if (randomTerrain.equals(Terrain.DESERT)) {
        this.tileList.add(new Tile(i, randomTerrain, 0, 0));
      } else {
        int randomProbability = getRandomProbability();
        this.tileList.add(new Tile(i, randomTerrain, randomProbability, getPips(randomProbability)));
      }
    }

    // Initialize each vertex's coordinates
    vertexCoordinates = new Point2D[54];
    vertexCoordinates[0] = new Point2D.Double(320, 30);
    vertexCoordinates[1] = new Point2D.Double(495, 30);
    vertexCoordinates[2] = new Point2D.Double(670, 30);
    vertexCoordinates[3] = new Point2D.Double(235, 80);
    vertexCoordinates[4] = new Point2D.Double(410, 80);
    vertexCoordinates[5] = new Point2D.Double(585, 80);
    vertexCoordinates[6] = new Point2D.Double(760, 80);
    vertexCoordinates[7] = new Point2D.Double(235, 180);
    vertexCoordinates[8] = new Point2D.Double(410, 180);
    vertexCoordinates[9] = new Point2D.Double(585, 180);
    vertexCoordinates[10] = new Point2D.Double(760, 180);
    vertexCoordinates[11] = new Point2D.Double(150, 230);
    vertexCoordinates[12] = new Point2D.Double(325, 225);
    vertexCoordinates[13] = new Point2D.Double(500, 225);
    vertexCoordinates[14] = new Point2D.Double(675, 225);
    vertexCoordinates[15] = new Point2D.Double(850, 225);
    vertexCoordinates[16] = new Point2D.Double(150, 330);
    vertexCoordinates[17] = new Point2D.Double(325, 330);
    vertexCoordinates[18] = new Point2D.Double(495, 330);
    vertexCoordinates[19] = new Point2D.Double(670, 330);
    vertexCoordinates[20] = new Point2D.Double(850, 330);
    vertexCoordinates[21] = new Point2D.Double(60, 375);
    vertexCoordinates[22] = new Point2D.Double(240, 375);
    vertexCoordinates[23] = new Point2D.Double(410, 375);
    vertexCoordinates[24] = new Point2D.Double(585, 375);
    vertexCoordinates[25] = new Point2D.Double(760, 375);
    vertexCoordinates[26] = new Point2D.Double(935, 375);
    vertexCoordinates[27] = new Point2D.Double(60, 480);
    vertexCoordinates[28] = new Point2D.Double(235, 480);
    vertexCoordinates[29] = new Point2D.Double(410, 480);
    vertexCoordinates[30] = new Point2D.Double(585, 480);
    vertexCoordinates[31] = new Point2D.Double(760, 480);
    vertexCoordinates[32] = new Point2D.Double(935, 480);
    vertexCoordinates[33] = new Point2D.Double(150, 525);
    vertexCoordinates[34] = new Point2D.Double(320, 525);
    vertexCoordinates[35] = new Point2D.Double(495, 525);
    vertexCoordinates[36] = new Point2D.Double(670, 525);
    vertexCoordinates[37] = new Point2D.Double(850, 525);
    vertexCoordinates[38] = new Point2D.Double(150, 630);
    vertexCoordinates[39] = new Point2D.Double(320, 630);
    vertexCoordinates[40] = new Point2D.Double(495, 630);
    vertexCoordinates[41] = new Point2D.Double(670, 630);
    vertexCoordinates[42] = new Point2D.Double(850, 630);
    vertexCoordinates[43] = new Point2D.Double(235, 675);
    vertexCoordinates[44] = new Point2D.Double(410, 675);
    vertexCoordinates[45] = new Point2D.Double(585, 675);
    vertexCoordinates[46] = new Point2D.Double(760, 675);
    vertexCoordinates[47] = new Point2D.Double(235, 780);
    vertexCoordinates[48] = new Point2D.Double(410, 780);
    vertexCoordinates[49] = new Point2D.Double(585, 780);
    vertexCoordinates[50] = new Point2D.Double(760, 780);
    vertexCoordinates[51] = new Point2D.Double(320, 825);
    vertexCoordinates[52] = new Point2D.Double(495, 825);
    vertexCoordinates[53] = new Point2D.Double(670, 825);

    // Create board as ArrayList of Model.IVertex's
    this.board = new ArrayList<>(NUMVERTICES);
    for (int i = 0; i < NUMVERTICES; i++) {
      this.board.add(new Vertex(i));
    }

    // Visually, I create the board (which is a list of IVertex's) by going horizontally across
    // the board of tiles and assigning each IVertex its corresponding 1-3 tiles.

    // First Line----------------------------------
    this.board.get(0).addTile(this.tileList.get(0));

    this.board.get(1).addTile(this.tileList.get(1));

    this.board.get(2).addTile(this.tileList.get(2));

    // Second Line---------------------------------
    this.board.get(3).addTile(this.tileList.get(0));

    this.board.get(4).addTile(this.tileList.get(0));
    this.board.get(4).addTile(this.tileList.get(1));

    this.board.get(5).addTile(this.tileList.get(1));
    this.board.get(5).addTile(this.tileList.get(2));

    this.board.get(6).addTile(this.tileList.get(2));

    // Third Line------------------------------------
    this.board.get(7).addTile(this.tileList.get(0));
    this.board.get(7).addTile(this.tileList.get(3));

    this.board.get(8).addTile(this.tileList.get(0));
    this.board.get(8).addTile(this.tileList.get(1));
    this.board.get(8).addTile(this.tileList.get(4));

    this.board.get(9).addTile(this.tileList.get(1));
    this.board.get(9).addTile(this.tileList.get(2));
    this.board.get(9).addTile(this.tileList.get(5));

    this.board.get(10).addTile(this.tileList.get(2));
    this.board.get(10).addTile(this.tileList.get(6));

    // Fourth Line-----------------------------------
    this.board.get(11).addTile(this.tileList.get(3));

    this.board.get(12).addTile(this.tileList.get(0));
    this.board.get(12).addTile(this.tileList.get(3));
    this.board.get(12).addTile(this.tileList.get(4));

    this.board.get(13).addTile(this.tileList.get(1));
    this.board.get(13).addTile(this.tileList.get(4));
    this.board.get(13).addTile(this.tileList.get(5));

    this.board.get(14).addTile(this.tileList.get(2));
    this.board.get(14).addTile(this.tileList.get(5));
    this.board.get(14).addTile(this.tileList.get(6));

    this.board.get(15).addTile(this.tileList.get(6));

    // Fifth Line-------------------------------------
    this.board.get(16).addTile(this.tileList.get(3));
    this.board.get(16).addTile(this.tileList.get(7));

    this.board.get(17).addTile(this.tileList.get(3));
    this.board.get(17).addTile(this.tileList.get(4));
    this.board.get(17).addTile(this.tileList.get(8));

    this.board.get(18).addTile(this.tileList.get(4));
    this.board.get(18).addTile(this.tileList.get(5));
    this.board.get(18).addTile(this.tileList.get(9));

    this.board.get(19).addTile(this.tileList.get(5));
    this.board.get(19).addTile(this.tileList.get(6));
    this.board.get(19).addTile(this.tileList.get(10));

    this.board.get(20).addTile(this.tileList.get(6));
    this.board.get(20).addTile(this.tileList.get(11));

    // Sixth Line-----------------------------------
    this.board.get(21).addTile(this.tileList.get(7));

    this.board.get(22).addTile(this.tileList.get(3));
    this.board.get(22).addTile(this.tileList.get(7));
    this.board.get(22).addTile(this.tileList.get(8));

    this.board.get(23).addTile(this.tileList.get(4));
    this.board.get(23).addTile(this.tileList.get(8));
    this.board.get(23).addTile(this.tileList.get(9));

    this.board.get(24).addTile(this.tileList.get(5));
    this.board.get(24).addTile(this.tileList.get(9));
    this.board.get(24).addTile(this.tileList.get(10));

    this.board.get(25).addTile(this.tileList.get(6));
    this.board.get(25).addTile(this.tileList.get(10));
    this.board.get(25).addTile(this.tileList.get(11));

    this.board.get(26).addTile(this.tileList.get(11));

    // Seventh Line----------------------------------
    this.board.get(27).addTile(this.tileList.get(7));

    this.board.get(28).addTile(this.tileList.get(7));
    this.board.get(28).addTile(this.tileList.get(8));
    this.board.get(28).addTile(this.tileList.get(12));

    this.board.get(29).addTile(this.tileList.get(8));
    this.board.get(29).addTile(this.tileList.get(9));
    this.board.get(29).addTile(this.tileList.get(13));

    this.board.get(30).addTile(this.tileList.get(9));
    this.board.get(30).addTile(this.tileList.get(10));
    this.board.get(30).addTile(this.tileList.get(14));

    this.board.get(31).addTile(this.tileList.get(10));
    this.board.get(31).addTile(this.tileList.get(11));
    this.board.get(31).addTile(this.tileList.get(15));

    this.board.get(32).addTile(this.tileList.get(11));

    // Eighth Line------------------------------------
    this.board.get(33).addTile(this.tileList.get(7));
    this.board.get(33).addTile(this.tileList.get(12));

    this.board.get(34).addTile(this.tileList.get(8));
    this.board.get(34).addTile(this.tileList.get(12));
    this.board.get(34).addTile(this.tileList.get(13));

    this.board.get(35).addTile(this.tileList.get(9));
    this.board.get(35).addTile(this.tileList.get(13));
    this.board.get(35).addTile(this.tileList.get(14));

    this.board.get(36).addTile(this.tileList.get(10));
    this.board.get(36).addTile(this.tileList.get(14));
    this.board.get(36).addTile(this.tileList.get(15));

    this.board.get(37).addTile(this.tileList.get(11));
    this.board.get(37).addTile(this.tileList.get(15));

    // Ninth Line-------------------------------------
    this.board.get(38).addTile(this.tileList.get(12));

    this.board.get(39).addTile(this.tileList.get(12));
    this.board.get(39).addTile(this.tileList.get(13));
    this.board.get(39).addTile(this.tileList.get(16));

    this.board.get(40).addTile(this.tileList.get(13));
    this.board.get(40).addTile(this.tileList.get(14));
    this.board.get(40).addTile(this.tileList.get(17));

    this.board.get(41).addTile(this.tileList.get(14));
    this.board.get(41).addTile(this.tileList.get(15));
    this.board.get(41).addTile(this.tileList.get(18));

    this.board.get(42).addTile(this.tileList.get(15));

    // Tenth Line--------------------------------------
    this.board.get(43).addTile(this.tileList.get(12));
    this.board.get(43).addTile(this.tileList.get(16));

    this.board.get(44).addTile(this.tileList.get(13));
    this.board.get(44).addTile(this.tileList.get(16));
    this.board.get(44).addTile(this.tileList.get(17));

    this.board.get(45).addTile(this.tileList.get(14));
    this.board.get(45).addTile(this.tileList.get(17));
    this.board.get(45).addTile(this.tileList.get(18));

    this.board.get(46).addTile(this.tileList.get(15));
    this.board.get(46).addTile(this.tileList.get(18));

    // Eleventh Line------------------------------------
    this.board.get(47).addTile(this.tileList.get(16));

    this.board.get(48).addTile(this.tileList.get(16));
    this.board.get(48).addTile(this.tileList.get(17));

    this.board.get(49).addTile(this.tileList.get(17));
    this.board.get(49).addTile(this.tileList.get(18));

    this.board.get(50).addTile(this.tileList.get(18));

    // Twelfth Line--------------------------------------
    this.board.get(51).addTile(this.tileList.get(16));

    this.board.get(52).addTile(this.tileList.get(17));

    this.board.get(53).addTile(this.tileList.get(18));

  }

  /**
   * Private helper to create tilesList.
   *
   * @return: A Model.Terrain enum, the randomly selected Model.Terrain piece from terrainList.
   */
  private Terrain getRandomTerrain() {
    Random random = new Random();
    Terrain randomTerrain = this.terrainList.get(random.nextInt(this.terrainList.size()));
    this.terrainList.remove(randomTerrain);
    return randomTerrain;
  }

  /**
   * Private helper to create tilesList.
   *
   * @return: An int, the randomly selected int probability from probabilityList.
   */
  private int getRandomProbability() {
    Random random = new Random();
    int randomProbability = this.probabilityList.get(random.nextInt(this.probabilityList.size()));
    this.probabilityList.remove((Integer) randomProbability);
    return randomProbability;
  }

  /**
   * Private helper to identify number of 'pips', or our probability, given the tile's number
   */
  private int getPips(int probability) {

    if (probability == 2) {
      return 1;
    } else if (probability == 3) {
      return 2;
    } else if (probability == 4) {
      return 3;
    } else if (probability == 5) {
      return 4;
    } else if (probability == 6) {
      return 5;
    } else if (probability == 8) {
      return 5;
    } else if (probability == 9) {
      return 4;
    } else if (probability == 10) {
      return 3;
    } else if (probability == 11) {
      return 2;
    } else {
      return 1;
    }
  }

  @Override
  public List<IVertex> getVertices() {
    return new ArrayList<>(this.board);
  }

  @Override
  public List<ITile> getTiles() {
    return new ArrayList<>(this.tileList);
  }

  @Override
  public Point2D getVertexCoordinates(int vertexID) {
    return this.vertexCoordinates[vertexID];
  }
}
