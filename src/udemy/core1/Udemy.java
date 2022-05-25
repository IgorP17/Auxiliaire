package udemy.core1;

public class Udemy {

    /**
     * Find minimum of 3 params
     * @param i1 param 1
     * @param i2 param 2
     * @param i3 param 3
     * @return String represent of min
     */
    public static String min(int i1, int i2, int i3) {
        // 1
        if (i1 < i2) {
            if (i1 < i3){
                return String.format("1st = %d", i1);
            } else if (i1 == i3){
                return String.format("1st and 3d = %d", i1);
            }
        }
        // 2
        if (i2 < i3) {
            if (i2 < i1){
                return String.format("2nd = %d", i2);
            } else if (i2 == i1){
                return String.format("1st and 2nd = %d", i2);
            }
        }
        // 3
        if (i3 < i1) {
            if (i3 < i2){
                return String.format("3d = %d", i3);
            } else if (i3 == i2){
                return String.format("2nd and 3d = %d", i3);
            }
        }
        // all eq
        if (i1 == i2 && i1 == i3){
            return String.format("all eq = %d", i3);
        }
        // should never happens
        return null;
    }

}
