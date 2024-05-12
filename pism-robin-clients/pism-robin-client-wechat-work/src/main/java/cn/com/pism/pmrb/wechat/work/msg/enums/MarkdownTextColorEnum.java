package cn.com.pism.pmrb.wechat.work.msg.enums;

/**
 * @author perccyking
 * @since 2024/5/5 12:21
 */
public enum MarkdownTextColorEnum {
    /**
     * 绿色
     */
    INFO("info"),

    /**
     * 灰色
     */
    COMMENT("comment"),

    /**
     * 橙红色
     */
    WARNING("warning");

    private final String code;

    public String getCode() {
        return code;
    }

    MarkdownTextColorEnum(String code) {
        this.code = code;
    }
}
