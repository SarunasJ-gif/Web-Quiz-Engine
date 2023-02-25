// do not remove imports
import java.util.*;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T getFirst(T[] array) {
        return Arrays.stream(array).findFirst().orElse(null);
    }
}