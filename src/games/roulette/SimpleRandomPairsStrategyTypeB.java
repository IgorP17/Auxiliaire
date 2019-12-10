package games.roulette;

class SimpleRandomPairsStrategyTypeB extends Strategy {

    SimpleRandomPairsStrategyTypeB(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = RouletteBetTypesEnum.TYPE_B.getMinAmount();

        return betTable.doBetTypeB(
                RandomEnum.randomEnum(RoulettePairsEnum.class),
                betAmount,
                this);
    }
}
