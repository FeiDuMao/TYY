import java.util.Arrays;

public enum date {
    YEAR,MOUTH,DAY;
    String val;

    public static date getFromName(String name){
        return Arrays.stream(date.values())
                .filter(value->value.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(""));

    }
}
