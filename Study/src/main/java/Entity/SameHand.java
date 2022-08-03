package Entity;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Date 2022/8/3 13:56
 * @Created by taoyuanyuan
 */
public enum SameHand {

    SAME, DIFF, AVG;

    static final Map<String, SameHand> sameHandMap = Arrays.stream(SameHand.values()).collect(Collectors.toMap(SameHand::name, Function.identity()));

    public static Optional<SameHand> parse(String name) {
        return Optional.ofNullable(sameHandMap.get(name.toUpperCase()));
    }

}
