/**
 * Duncan Echols-Jones
 * Created on: September 3, 2019
 */

package Model;

/**
 * StrategyFactory factory class. Has a static class that returns a new ICatanStrategy object
 * depending on the command line argument input by the user.
 */

public class StrategyFactory {
  public static ICatanStrategy MakeStrategy(String strategy){
    // Parses user's strategy selection from the command line to return an ICatanStrategy object
    if (strategy.toLowerCase().equals("commander")) {
      return new CommanderStrategy();
    } else if (strategy.toLowerCase().equals("developer")) {
      return new DeveloperStrategy();
    } else if (strategy.toLowerCase().equals("producer")) {
      return new ProducerStrategy();
    } else if (strategy.toLowerCase().equals("explorer")) {
      return new ExplorerStrategy();
    } else if (strategy.toLowerCase().equals("queenofsheep")) {
      return new QueenOfSheepStrategy();
    }
    return null;
  }
}
