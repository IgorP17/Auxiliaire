package games.roulette;

import games.roulette.strategy.*;

import java.util.ArrayList;

class Roulette {

    public static void main(String[] args) {
        ArrayList<Strategy> strategies = new ArrayList<>();
        int startAmount = 1_000_000;
        int rounds = 1;

        RouletteBetTable betTable = new RouletteBetTable();
        RouletteSector winSector;

        strategies.add(new SimpleRandomColorStrategyTypeH(startAmount));
        strategies.add(new SimpleRandomNumberStrategyTypeA(startAmount));
        strategies.add(new SimpleRandomPairsStrategyTypeB(startAmount));
        strategies.add(new SimpleRandomTriplesStrategyTypeC(startAmount));
        strategies.add(new SimpleRandomFoursStrategyTypeD(startAmount));
        strategies.add(new SimpleRandomSixStrategyTypeE(startAmount));
        strategies.add(new SimpleRandomRowStrategyTypeF(startAmount));
        strategies.add(new SimpleRandomTwelveStrategyTypeG(startAmount));
        strategies.add(new SimpleRandomEvenOddStrategyTypeH(startAmount));


        for (int i = 0; i < rounds; i++) {
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

            // notify about wis sector
            System.out.println("Notify strategies:");
            // notify all strategies about win sector
            for (Strategy strategy :
                    strategies) {
                strategy.notification(winSector);
            }

            // show strategies
            // sort by balance
            //Collections.sort(strategies, new StrategyComparator());
            strategies.sort(new StrategyComparator());
            System.out.println("Played round: " + (i + 1));
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
