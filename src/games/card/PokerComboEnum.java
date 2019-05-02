package games.card;

public enum PokerComboEnum {

    FLASHROYAL(0),
    STREETFLASH(1),
    CARE(2),
    FULLHOUSE(3),
    FLASH(4),
    STREET(5),
    SET(6),
    PAIRS(7),
    PAIR(8),
    HIGHCARD(9);

    private int priority;

    PokerComboEnum(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static PokerComboEnum getEnum(int priority) {
        switch (priority) {
            case 0:
                return FLASHROYAL;
            case 1:
                return STREETFLASH;
            case 2:
                return CARE;
            case 3:
                return FULLHOUSE;
            case 4:
                return FLASH;
            case 5:
                return STREET;
            case 6:
                return SET;
            case 7:
                return PAIRS;
            case 8:
                return PAIR;
            case 9:
                return HIGHCARD;
            default:
                System.out.println("No such combination with priority: " + priority);
                return null;
        }

    }
}
