package games.roulette;

import java.util.ArrayList;

public class RouletteBetTable {

    private static ArrayList<RouletteSector> rouletteSectors = new ArrayList<>();
    // static
    static {
        for (int i = 0; i < 37; i++) {
            rouletteSectors.add(RouletteSector.getSectorByNumber(i));
        }
    }


    // psvm
    public static void main(String[] args) {
        System.out.println("===Print all");
        for (RouletteSector rs:
             rouletteSectors) {
            System.out.println(rs);
        }
        System.out.println("Print some rand");
        for (int i = 0; i < 3; i++) {
            System.out.println(RouletteSector.getRandomSector());
        }
    }

}
