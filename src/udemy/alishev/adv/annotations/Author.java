package udemy.alishev.adv.annotations;

public @interface Author {
    String name() default "Some name";
    int dateOfBirth() default 2000;
    // аннотировать аннотации -
    // @Target - указывает к чем можно применять FIELD / METHOD / TYPE
    // java.lang.annotation
    // @Retentions
    // политика удержания аннотации - SOURCE / CLASS / RUNTIME - до какого этапа видна аннотация
    // RetentionPolicy
}
