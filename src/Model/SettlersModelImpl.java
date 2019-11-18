/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Our SettlersModelImpl class, the model of our program. Implements SettlersModel. Takes a IBoard
 * and an ICatanStrategy.
 */

public class SettlersModelImpl implements SettlersModel {

  private final IBoard board;
  private ICatanStrategy strategy;

  /**
   * @Name: SettlersModelImpl constructor.
   * @param: IBoard board, ICatanStrategy strategy
   */
  public SettlersModelImpl(IBoard board, ICatanStrategy strategy) {

    this.board = board;

    // Uses factory to initialize strategy
    this.strategy = strategy;
  }

  @Override
  public IVertex getOptimalVertex() {
    return this.strategy.getOptimalVertexForStrategy(this.board.getVertices());
  }

  @Override
  public Point2D getOptimalVertexCoordinates() {
    System.out.println(this.strategy.getOptimalVertexForStrategy(this.board.getVertices()));
    return this.board.getVertexCoordinates(this.getOptimalVertex().getVertexID());
  }

  @Override
  public List<ITile> getTilesList() {
    return this.board.getTiles();
  }

}
