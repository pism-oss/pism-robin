package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.core.model.JsonConcat;
import cn.com.pism.pmrb.wechat.work.msg.enums.ClickTypeEnum;

import static cn.com.pism.pmrb.core.util.EnhanceUtil.isNotNull;
import static cn.com.pism.pmrb.wechat.work.WechatWorkConstant.*;

public class Jump {

    /**
     * <p>跳转链接类型，0或不填代表不是链接，1 代表跳转url，2 代表跳转小程序</p>
     * 必填：否
     */
    private ClickTypeEnum type;

    /**
     * <p>跳转链接样式的文案内容，建议不超过13个字</p>
     * 必填：是
     */
    private String title;

    /**
     * <p>跳转链接的url，jump_list.type是1时必填</p>
     * 必填：否
     */
    private String url;

    /**
     * <p>跳转链接的小程序的appid，jump_list.type是2时必填</p>
     * 必填：否
     */
    private String appid;

    /**
     * <p>跳转链接的小程序的pagepath，jump_list.type是2时选填</p>
     * 必填：否
     */
    private String pagePath;

    public static Jump instance() {
        return new Jump();
    }

    public Jump type(ClickTypeEnum type) {
        this.type = type;
        return this;
    }

    public Jump title(String title) {
        this.title = title;
        return this;
    }

    public Jump url(String url) {
        this.url = url;
        return this;
    }

    public Jump appid(String appid) {
        this.appid = appid;
        return this;
    }

    public Jump pagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }

    public ClickTypeEnum getType() {
        return type;
    }

    public void setType(ClickTypeEnum type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return JsonConcat.instance()
                .concat(TYPE, isNotNull(type, Enum::ordinal, 0))
                .concat(APP_ID, appid)
                .concat(PAGE_PATH, pagePath)
                .concat(URL, url)
                .concat(TITLE, title)
                .toJson();
    }
}