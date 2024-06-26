package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.core.model.JsonConcat;
import cn.com.pism.pmrb.wechat.work.msg.enums.ClickTypeEnum;

import static cn.com.pism.pmrb.core.util.EnhanceUtil.isNotNull;
import static cn.com.pism.pmrb.wechat.work.WechatWorkConstant.*;

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
    private ClickTypeEnum type;

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

    public static QuotArea instance() {
        return new QuotArea();
    }

    public QuotArea type(ClickTypeEnum type) {
        this.type = type;
        return this;
    }

    public QuotArea url(String url) {
        this.url = url;
        return this;
    }

    public QuotArea appid(String appid) {
        this.appid = appid;
        return this;
    }

    public QuotArea pagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }

    public QuotArea title(String title) {
        this.title = title;
        return this;
    }

    public QuotArea quoteText(String quoteText) {
        this.quoteText = quoteText;
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

    public String toJson() {
        return JsonConcat.instance()
                .concat(TYPE, isNotNull(type, Enum::ordinal, 0))
                .concat(URL, url)
                .concat(APP_ID, appid)
                .concat(PAGE_PATH, pagePath)
                .concat(TITLE, title)
                .concat(QUOTE_TEXT, quoteText)
                .toJson();
    }
}
