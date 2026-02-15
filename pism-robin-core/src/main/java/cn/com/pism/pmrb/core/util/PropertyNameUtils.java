package cn.com.pism.pmrb.core.util;

/**
 * @author perccyking
 * @since 26-02-01 10:28
 */
public class PropertyNameUtils {

    private PropertyNameUtils() {
    }


    /**
     * 将带有特殊字符的字符串转换为驼峰命名
     * 规则：
     * 1. 如果没有特殊字符，保持原样（不改变大小写）
     * 2. 如果有特殊字符，去掉特殊字符，并将后一个字符转大写
     *
     * @param input 原始字符串
     * @return 转换后的字符串
     */
    public static String toCamelCase(String input) {
        if (!shouldConvert(input)) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        boolean nextUpperCase = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 如果不是字母或数字，判定为特殊字符（包括 - _ . 空格等）
            if (!Character.isLetterOrDigit(c)) {
                // 标记下一个字符需要大写，当前特殊字符不 append
                if (!sb.isEmpty()) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否包含特殊字符（即是否可以/需要转驼峰）
     *
     * @param input 字符串
     * @return true 表示包含特殊字符，需要处理
     */
    public static boolean shouldConvert(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
