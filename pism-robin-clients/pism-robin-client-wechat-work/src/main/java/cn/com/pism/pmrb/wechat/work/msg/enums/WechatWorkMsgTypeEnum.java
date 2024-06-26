package cn.com.pism.pmrb.wechat.work.msg.enums;

/**
 * 消息类型
 *
 * @author perccyking
 * @since 2024/5/1 23:31
 */
public enum WechatWorkMsgTypeEnum {
    /**
     * 文本类型
     */
    TEXT("text"),

    /**
     * markdown
     */
    MARKDOWN("markdown"),

    /**
     * 图片
     */
    IMAGE("image"),

    /**
     * 图文
     */
    NEWS("news"),

    /**
     * 模版卡片
     */
    TEMPLATE_CARD("template_card"),
    ;

    private final String type;

    WechatWorkMsgTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
