package cn.com.pism.pmrb.wechat.work.msg.template.card;

/**
 * @author perccyking
 * @since 2024/5/6 15:28
 */
public enum CardType {
    /**
     * 文本通知模版卡片
     */
    TEXT_NOTICE("text_notice"),
    /**
     * 图文展示模版卡片
     */
    NEWS_NOTICE("news_notice"),
    ;

    private final String code;

    public String getCode() {
        return code;
    }

    CardType(String code) {
        this.code = code;
    }
}
