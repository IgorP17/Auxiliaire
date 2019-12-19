package games.roulette;

import java.util.Random;

public interface IntegerGetable {

    default int[] getNumbers(){
        Random random = new Random();
        return new int[]{random.nextInt(37)};
    }
}
