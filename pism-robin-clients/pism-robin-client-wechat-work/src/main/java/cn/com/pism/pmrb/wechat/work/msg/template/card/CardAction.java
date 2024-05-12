package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.core.util.EnhanceUtil;

import static cn.com.pism.pmrb.core.util.EnhanceUtil.isNotNull;

public class CardAction {

    private static final String MSG = "{\"type\":%s,\"url\":\"%s\",\"appid\":\"%s\",\"pagepath\":\"%s\"}";

    /**
     * <p>卡片跳转类型，1 代表跳转url，2 代表打开小程序。news_notice模版卡片中该字段取值范围为[1,2]</p>
     * 必填：是
     */
    private ClickTypeEnum type;

    /**
     * <p>跳转事件的url，card_action.type是1时必填</p>
     * 必填：否
     */
    private String url;

    /**
     * <p>跳转事件的小程序的appid，card_action.type是2时必填</p>
     * 必填：否
     */
    private String appid;

    /**
     * <p>跳转事件的小程序的pagepath，card_action.type是2时选填</p>
     * 必填：否
     */
    private String pagePath;

    public static CardAction instance() {
        return new CardAction();
    }

    public CardAction type(ClickTypeEnum type) {
        this.type = type;
        return this;
    }

    public CardAction url(String url) {
        this.url = url;
        return this;
    }

    public CardAction appid(String appid) {
        this.appid = appid;
        return this;
    }

    public CardAction pagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }


    public ClickTypeEnum getType() {
        return type;
    }

    public void setType(ClickTypeEnum type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String toJson() {
        return String.format(MSG, isNotNull(type, Enum::ordinal, ""),
                EnhanceUtil.isNotNullOrDef(url),
                EnhanceUtil.isNotNullOrDef(appid),
                EnhanceUtil.isNotNullOrDef(pagePath));
    }
}