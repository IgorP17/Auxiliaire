package udemy.alishev.base;

public enum AnimalEnum {
    DOG(5, "собака"), CAT(6, "кошка"), FROG(7, "лягушка");
    private final int id;
    private final String ruName;

    AnimalEnum(int id, String ruName) {
        this.id = id;
        this.ruName = ruName;
    }

    int getId(){
        return id;
    }

    String getRuName(){
        return ruName;
    }

    @Override
    public String toString() {
        return "AnimalEnum{" +
                "id=" + id +
                ", ruName='" + ruName + '\'' +
                '}';
    }
}
