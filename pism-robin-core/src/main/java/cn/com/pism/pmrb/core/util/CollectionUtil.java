package cn.com.pism.pmrb.core.util;

import java.util.Collection;

/**
 * @author perccyking
 * @since 2024/5/2 11:52
 */
public class CollectionUtil {
    private CollectionUtil() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
