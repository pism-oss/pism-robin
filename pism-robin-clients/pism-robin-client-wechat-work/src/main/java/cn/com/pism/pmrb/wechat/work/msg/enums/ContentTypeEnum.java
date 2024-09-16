package cn.com.pism.pmrb.wechat.work.msg.enums;

/**
 * @author perccyking
 * @since 2024/5/6 20:54
 */
public enum ContentTypeEnum {

    /**
     * url
     */
    URL(1),

    /**
     * 附件
     */
    ATTACHMENT(2);

    private final int code;

    public int getCode() {
        return code;
    }

    ContentTypeEnum(int code) {
        this.code = code;
    }
}
