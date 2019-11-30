package games.roulette;

import java.util.ArrayList;

public class Roulette {

    public static void main(String[] args) {
        RouletteBetTable betTable = new RouletteBetTable();
        RouletteSector winSector;
        ArrayList<Strategy> strategies = new ArrayList<>();
        strategies.add(new SimpleRandomStrategy(1_000_000));


        for (int i = 0; i < 10; i++) {
            for (Strategy strategy :
                    strategies) {
                // strategy bet
                if (!strategy.makeBet(betTable)) {
                    System.out.println("!!! Strategy " + strategy.getClass().getSimpleName()
                            + " make no bet");
                }
            }
            // bets
            System.out.println("Bets are:");
            for (RouletteBetItem item :
                    betTable.getBets()) {
                System.out.println(item);
            }

            // spin
            winSector = RouletteSector.getRandomSector();
            System.out.println("Win sector is:");
            System.out.println(winSector);
            System.out.println("Winners are:");
            for (RouletteBetItem item :
                    betTable.getBets()) {
                if (item.getRouletteSector().equals(winSector)) {
                    System.out.println(item);
                    // need notify strategy +
                    item.getStrategy().notification(item.getWinAmount());
                }
            }

            // notify all strategies about win sector
            for (Strategy strategy:
                 strategies) {
                strategy.notification(winSector);
            }

            // show strategies
            System.out.println("Played round: " + i);
            System.out.println("Strategies:");
            for (Strategy strategy :
                    strategies) {
                System.out.println(strategy);
            }

            // clean table for next round
            betTable.cleanBets();
        }
    }


}
