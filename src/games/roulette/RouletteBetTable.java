package games.roulette;

import java.util.ArrayList;

public class RouletteBetTable {

    private ArrayList<RouletteBetItem> bets = new ArrayList<>();


    /**
     * Direct bet on the number
     *
     * @param number    - roulette number
     * @param amount    - amount
     * @param className - name of calling class
     */
    void doBetTypeA(int number, int amount, String className) {
        if (amount < RouletteBetTypesEnum.TYPE_A.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_A.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type A");
            return;
        }
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(number),
                RouletteBetTypesEnum.TYPE_A,
                amount,
                amount * RouletteBetTypesEnum.TYPE_A.getPayRoll(),
                className));
    }

    /**
     * Bet on RED or BLACK
     *
     * @param color     - RED or BLACK
     * @param amount    - amount
     * @param className - name of calling class
     */
    void doBetTypeHRedBlack(RouletteColorsEnum color, int amount, String className) {
        if (amount < RouletteBetTypesEnum.TYPE_H.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_H.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type H");
            return;
        }
        // make a bet on all number which has the same color
        // do not include ZERO
        RouletteSector sector;
        for (int i = 1; i < 37; i++) {
            sector = RouletteSector.getSectorByNumber(i);
            assert sector != null;
            if (color == sector.getColorsEnum()) {
                bets.add(new RouletteBetItem(
                        sector,
                        RouletteBetTypesEnum.TYPE_H,
                        amount,
                        amount * RouletteBetTypesEnum.TYPE_H.getPayRoll(),
                        className));
            }
        }
    }

    // getters


    private ArrayList<RouletteBetItem> getBets() {
        return bets;
    }

    // psvm
    public static void main(String[] args) {
        RouletteBetTable betTable = new RouletteBetTable();
        betTable.doBetTypeA(0, 100, RouletteBetTable.class.getName());
        betTable.doBetTypeA(1, 200, RouletteBetTable.class.getName());
        betTable.doBetTypeA(2, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeA(3, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeA(4, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeA(5, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeA(6, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeA(7, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeA(8, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeA(9, 300, RouletteBetTable.class.getName());
        betTable.doBetTypeHRedBlack(RouletteColorsEnum.BLACK, 100, "All black");

        System.out.println("Bets are:");
        for (RouletteBetItem item :
                betTable.getBets()) {
            System.out.println(item);
        }
//        RouletteSector winSector = RouletteSector.getRandomSector();
        RouletteSector winSector = RouletteSector.getSectorByNumber(8);
        System.out.println("Win sector:");
        System.out.println(winSector);
        System.out.println("Winners are:");
        for (RouletteBetItem item :
                betTable.getBets()) {
            if (item.compare(winSector)) {
                System.out.println(item);
            }
        }


    }

}
