package games.roulette;

import java.util.ArrayList;

public class Roulette {

    public static void main(String[] args) {
        RouletteBetTable betTable = new RouletteBetTable();
        RouletteSector winSector;
        ArrayList<Strategy> strategies = new ArrayList<>();
        strategies.add(new SimpleRandomStrategy());

        for (Strategy strategy:
             strategies) {
            // strategy bet
            if (!strategy.bet(betTable)){
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
                // need notify strategy
                item.getStrategy();
            }
        }

    }


}