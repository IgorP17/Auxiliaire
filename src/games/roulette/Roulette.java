package games.roulette;

import java.util.ArrayList;

class Roulette {

    public static void main(String[] args) {
        int startAmount = 1_000_000;
        RouletteBetTable betTable = new RouletteBetTable();
        RouletteSector winSector;
        ArrayList<Strategy> strategies = new ArrayList<>();

        strategies.add(new SimpleRandomColorStrategyTypeH(startAmount));
        strategies.add(new SimpleRandomNumberStrategyTypeA(startAmount));
        strategies.add(new SimpleRandomPairsStrategyTypeB(startAmount));


        for (int i = 0; i < 1_000; i++) {
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

            System.out.println("Notify strategies:");
            // notify all strategies about win sector
            for (Strategy strategy:
                 strategies) {
                strategy.notification(winSector);
            }

            // show strategies
            // sort by balance
            //Collections.sort(strategies, new StrategyComparator());
            strategies.sort(new StrategyComparator());
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
