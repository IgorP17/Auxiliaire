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

    PokerComboEnum(int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }
}
