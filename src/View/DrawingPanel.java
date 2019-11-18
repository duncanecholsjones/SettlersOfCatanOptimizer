/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package View;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Model.ITile;
import Model.IVertex;
import Model.Terrain;

/**
 * Our DrawingPanel class. This is what actually creates our GUI representation of the Catan
 * board. Implements IDrawingPanel.
 */

public class DrawingPanel extends JPanel implements IDrawingPanel {

  // Take these two values as fields so that we can initialize them in drawShapes() but use them
  // in paintComponent()
  private List<HexagonalTile> hexagonalTilesToDraw;
  private Point2D optimalVertexCoordinates;

  /**
   * DrawingPanel constructor.
   */
  public DrawingPanel() {
    setLayout(null);
  }

  @Override
  public void drawShapes(List<ITile> tilesToDraw, IVertex optimalVertexToDraw,
                         Point2D optimalVertexCoordinates) {

    this.hexagonalTilesToDraw = new ArrayList<>();
    this.optimalVertexCoordinates = optimalVertexCoordinates;

    // Initialize pixel values and coordinates so that we can draw our board using Swing
    int TILERADIUS = 50;
    int xCoordinate = 350;
    int yCoordinate = 100;
    int rowStartingTileID = 0;

    // Change our coordinates depending on the row each vertex is in
    for (ITile tile : tilesToDraw) {
      if (tile.getTileID() == 3) {
        xCoordinate = 265;
        yCoordinate = 250;
        rowStartingTileID = 3;
      } else if (tile.getTileID() == 7) {
        xCoordinate = 175;
        yCoordinate = 400;
        rowStartingTileID = 7;
      } else if (tile.getTileID() == 12) {
        xCoordinate = 265;
        yCoordinate = 550;
        rowStartingTileID = 12;
      } else if (tile.getTileID() == 16) {
        xCoordinate = 350;
        yCoordinate = 700;
        rowStartingTileID = 16;
      }

      // Initialize color
      Color shapeColor;
      if (tile.getTerrain().equals(Terrain.ORE)) {
        shapeColor = new Color(179, 179, 204);
      } else if (tile.getTerrain().equals(Terrain.WHEAT)) {
        shapeColor = new Color(255, 219, 77);
      } else if (tile.getTerrain().equals(Terrain.BRICK)) {
        shapeColor = new Color(230, 57, 100);
      } else if (tile.getTerrain().equals(Terrain.LUMBER)) {
        shapeColor = new Color(26, 115, 21);
      } else if (tile.getTerrain().equals(Terrain.SHEEP)) {
        shapeColor = new Color(112, 219, 112);
      } else {
        shapeColor = new Color(255, 236, 179);
      }

      // Add that HexagonalTile to the list of HexagonalTilesToDraw. Change only the x coordinate
      // as each tile comes as part of a row and therefore, the same y coordinate
      HexagonalTile hex = new HexagonalTile(shapeColor, tile.getProbability(),
              TILERADIUS * 2,
              new Point2D.Double(xCoordinate + ((TILERADIUS * 3.5) * (tile.getTileID()
                      - rowStartingTileID)), yCoordinate));
      this.hexagonalTilesToDraw.add(hex);
    }
  }

  @Override
  public void paintComponent(Graphics g) {

    // Use Graphics2D and AffineTransform to allow for rotation of hexagon tiles
    Graphics2D g2 = (Graphics2D) g;
    AffineTransform oldTransform = g2.getTransform();
    g2.setFont(new Font("Georgia", Font.PLAIN, 30));

    // Iterate through list of Tiles and draw each with terrains and probabilities colored in
    for (HexagonalTile hex : hexagonalTilesToDraw) {
      // Draw the hexagonal tile with it's corresponding terrain color
      g2.setColor(hex.getColor());
      g2.rotate(Math.toRadians(90), hex.getCenter().getX(), hex.getCenter().getY());
      g2.drawPolygon(hex.getHexagonalTile());
      g2.fillPolygon(hex.getHexagonalTile());
      // Outline each hexagon in black
      g2.setColor(Color.black);
      g2.drawPolyline(hex.getHexagonalTile().xpoints, hex.getHexagonalTile().ypoints,
              hex.getHexagonalTile().npoints);
      // Reset the rotation transformation so that we can correctly rotate our next hexagon
      g2.setTransform(oldTransform);
      // Draw the probabilities, red if probability is 6 or 8, black otherwise
      if (hex.getProbability() == 6 || hex.getProbability() == 8) {
        g2.setColor(new Color(210, 50, 30));
      }
      g2.drawString("" + hex.getProbability(), (int) hex.getCenter().getX(),
              (int) hex.getCenter().getY());
    }

    // Circle the optimal vertex
    g2.setColor(Color.black);
    g2.setFont(new Font("Georgia", Font.PLAIN, 80));
    g2.drawString("O", (int)this.optimalVertexCoordinates.getX(),
            (int)this.optimalVertexCoordinates.getY());
  }


  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1200, 900);
  }

  /**
   * This inner class allows us to create Hexagon tiles that we can easily draw with Swing. They
   * are meant to represent an ITile object but now with values that Swing can use.
   */
  class HexagonalTile {

    private final Color color;
    private final int probability;
    private final int radius;
    private final Point2D center;
    private final Polygon HexagonalTile;

    public HexagonalTile( Color color, int probability, int radius, Point2D center) {

      this.color = color;
      this.probability = probability;
      this.radius = radius;
      this.center = center;
      this.HexagonalTile = makeNewHexagonalTile();
    }

    private Polygon makeNewHexagonalTile() {

      Polygon hexTile = new Polygon();
      // Initialize the hexagon's 6 points that we will later connect to draw each hexagon
      for (int i = 0; i < 6; i++) {
        int xValue = (int) (center.getX() + radius * Math.cos(i * 2 * Math.PI / 6));
        int yValue = (int) (center.getY() + radius * Math.sin(i * 2 * Math.PI / 6));
        hexTile.addPoint(xValue, yValue);
      }

      return hexTile;
    }

    public Color getColor() {
      return this.color;
    }

    public int getProbability() {
      return this.probability;
    }

    public Point2D getCenter() {
      return this.center;
    }

    public Polygon getHexagonalTile() {
      return this.HexagonalTile;
    }
  }

}



