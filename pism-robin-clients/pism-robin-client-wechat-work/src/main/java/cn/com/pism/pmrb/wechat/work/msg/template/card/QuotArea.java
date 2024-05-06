package cn.com.pism.pmrb.wechat.work.msg.template.card;

/**
 * 引用文献样式，建议不与关键数据共用
 *
 * @author perccyking
 * @since 2024/5/6 17:06
 */
public class QuotArea {

    /**
     * <p>引用文献样式区域点击事件，0或不填代表没有点击事件，1 代表跳转url，2 代表跳转小程序</p>
     * 必填：否
     */
    private Integer type;

    /**
     * <p>点击跳转的url，quote_area.type是1时必填</p>
     * 必填：否
     */
    private String url;

    /**
     * <p>点击跳转的小程序的appid，quote_area.type是2时必填</p>
     * 必填：否
     */
    private String appid;

    /**
     * <p>点击跳转的小程序的pagepath，quote_area.type是2时选填</p>
     * 必填：否
     */
    private String pagePath;

    /**
     * <p>引用文献样式的标题</p>
     * 必填：否
     */
    private String title;

    /**
     * <p>引用文献样式的引用文案</p>
     * 必填：否
     */
    private String quoteText;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }
}
