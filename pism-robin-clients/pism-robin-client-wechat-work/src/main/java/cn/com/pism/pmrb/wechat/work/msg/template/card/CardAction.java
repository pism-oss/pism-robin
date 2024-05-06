package cn.com.pism.pmrb.wechat.work.msg.template.card;

public class CardAction {
    /**
     * <p>卡片跳转类型，1 代表跳转url，2 代表打开小程序。news_notice模版卡片中该字段取值范围为[1,2]</p>
     * 必填：是
     */
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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
}