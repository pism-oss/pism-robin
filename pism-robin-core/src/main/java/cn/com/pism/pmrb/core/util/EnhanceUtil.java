package cn.com.pism.pmrb.core.util;

import java.util.function.Function;

/**
 * @author perccyking
 * @since 2024/5/12 11:07
 */
public class EnhanceUtil {
    private EnhanceUtil() {
    }

    public static <R, I> R isNotNull(I obj, Function<I, R> function, R defaultValue) {
        if (obj != null) {
            return function.apply(obj);
        }
        return defaultValue;
    }

    public static <R, I> R isNotNull(I obj, Function<I, R> function) {
        return isNotNull(obj, function, null);
    }

    public static <I> I isNotNull(I obj, I defaultValue) {
        return isNotNull(obj, item -> item, defaultValue);
    }

    public static String isNotNullOrDef(String str) {
        return isNotNull(str, "");
    }

}
