package games.roulette;

import games.roulette.strategy.*;

import java.util.ArrayList;

class Roulette {

    private ArrayList<Strategy> strategies = new ArrayList<>();
    private int startAmount = 1_000_000;
    private int rounds = 1_000;


    public static void main(String[] args) {
        Roulette roulette = new Roulette();
        RouletteBetTable betTable = new RouletteBetTable();
        RouletteSector winSector;

        roulette.strategies.add(new SimpleRandomColorStrategyTypeH(roulette.startAmount));
        roulette.strategies.add(new SimpleRandomNumberStrategyTypeA(roulette.startAmount));
        roulette.strategies.add(new SimpleRandomPairsStrategyTypeB(roulette.startAmount));
        roulette.strategies.add(new SimpleRandomTriplesStrategyTypeC(roulette.startAmount));


        for (int i = 0; i < roulette.rounds; i++) {
            for (Strategy strategy :
                    roulette.strategies) {
                // strategy bet
                if (!strategy.makeBet(betTable)) {
                    System.out.println("!!! Strategy " + strategy.getClass().getSimpleName()
                            + " make no bet");
                }
            }
            // bets
            roulette.showBets(betTable);

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
            roulette.notifyWinSector(roulette, winSector);

            // show strategies
            // sort by balance
            //Collections.sort(strategies, new StrategyComparator());
            roulette.strategies.sort(new StrategyComparator());
            System.out.println("Played round: " + (i + 1));
            System.out.println("Strategies:");
            for (Strategy strategy :
                    roulette.strategies) {
                System.out.println(strategy);
            }

            // clean table for next round
            betTable.cleanBets();
        }
    }

    /**
     * Show bets
     *
     * @param betTable - bet table
     */
    private void showBets(RouletteBetTable betTable) {
        System.out.println("Bets are:");
        for (RouletteBetItem item :
                betTable.getBets()) {
            System.out.println(item);
        }
    }

    /**
     * Notify strategies about win sector
     *
     * @param roulette  - roulette
     * @param winSector - win sector
     */
    private void notifyWinSector(Roulette roulette, RouletteSector winSector) {
        System.out.println("Notify strategies:");
        // notify all strategies about win sector
        for (Strategy strategy :
                roulette.strategies) {
            strategy.notification(winSector);
        }
    }


}
