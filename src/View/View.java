/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package View;

import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.*;

import Model.ITile;
import Model.IVertex;

/**
 * Our View concrete class. This class is intended to create the display for our program.
 * Implements IView.
 */

public class View extends JFrame implements IView {

  private JFrame frame = new JFrame("Settlers of Catan");
  private DrawingPanel drawingPanel;

  /**
   * Our View constructor. Initializes our view and drawing board so that we can view the output
   * of getOptimalVertex().
   */
  public View() {

    this.drawingPanel = new DrawingPanel();
    // Add a scrollPane so that we can easily see the entire board
    JScrollPane scrollPane = new JScrollPane(drawingPanel);
    frame.setTitle("Settlers of Catan Optimal Starting Vertex Program");
    frame.setSize(1200,650);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.add(scrollPane);
    frame.setVisible(true);

  }

  @Override
  public void render(List<ITile> tileList, IVertex optimalVertex, Point2D optimalVertexCoordinates) {
    this.drawingPanel.drawShapes(tileList, optimalVertex, optimalVertexCoordinates);
  }

}
