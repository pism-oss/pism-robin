package cn.com.pism.pmrb.wechat.work.msg.template.card;

public class Jump {
    /**
     * <p>跳转链接类型，0或不填代表不是链接，1 代表跳转url，2 代表跳转小程序</p>
     * 必填：否
     */
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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
}