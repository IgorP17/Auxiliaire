package udemy.alishev.adv.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String text = "Hello, people! I send my email joe@gmail.com so we can\n" +
                "keep in touch. Thanks, Joe! That is cool. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";

        Pattern email = Pattern.compile("\\w+@(gmail|yandex)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }

        Pattern email2 = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher matcher2 = email2.matcher(text);

        while (matcher2.find()){
            System.out.println(matcher2.group(1));
            System.out.println(matcher2.group(2));
        }
    }
}
