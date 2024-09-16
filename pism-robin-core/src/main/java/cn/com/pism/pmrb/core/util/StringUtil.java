package cn.com.pism.pmrb.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author perccyking
 * @since 2024/5/2 16:30
 */
public class StringUtil {

    protected static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    private StringUtil() {
    }

    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 按字节截取UTF-8编码的字符串，确保不会在字符中间截断
     *
     * @param str       原始字符串
     * @param maxLength 截取的最大字节长度
     * @return 截取后的字符串
     */
    public static String cutUTF8StringByBytes(String str, int maxLength) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            if (length > maxLength) {
                // 查找最后一个完整字符的结束位置
                int endIndex = maxLength;
                while (endIndex > 0 && (bytes[endIndex] & 0xC0) == 0x80) {
                    endIndex--;
                }
                // 截取到最后一个完整字符
                byte[] newBytes = new byte[endIndex];
                System.arraycopy(bytes, 0, newBytes, 0, endIndex);
                return new String(newBytes, StandardCharsets.UTF_8);
            }
            return str;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
