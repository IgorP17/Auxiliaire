package udemy.core1.others;

public enum Weather {
    CLOUDY("Cloud", 1),
    SUNNY("Sun", 2),
    RAINY("Rain", 3),
    SNOWY("Snow", 4);

    private final String sValue;
    private final int iValue;

    Weather(String s, int i) {
        this.sValue = s;
        this.iValue = i;
    }

    public String getSValue() {
        return sValue;
    }

    public int getIValue() {
        return iValue;
    }
}
