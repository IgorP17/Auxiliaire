package games.roulette;

class SimpleRandomTriplesStrategyTypeC extends Strategy {

    SimpleRandomTriplesStrategyTypeC(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = RouletteBetTypesEnum.TYPE_B.getMinAmount();

        return betTable.doBetTypeC(
                RandomEnum.randomEnum(RouletteTriplesEnum.class),
                betAmount,
                this);
    }
}
