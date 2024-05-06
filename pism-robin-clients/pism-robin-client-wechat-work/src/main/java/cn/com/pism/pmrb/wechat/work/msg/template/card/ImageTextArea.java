package cn.com.pism.pmrb.wechat.work.msg.template.card;

/**
 * @author perccyking
 * @since 2024/5/6 17:16
 */
public class ImageTextArea {

    /**
     * <p>左图右文样式区域点击事件，0或不填代表没有点击事件，1 代表跳转url，2 代表跳转小程序</p>
     * 必填：否
     */
    private ClickTypeEnum type;

    /**
     * <p>点击跳转的url，image_text_area.type是1时必填</p>
     * 必填：否
     */
    private String url;

    /**
     * <p>点击跳转的小程序的appid，必须是与当前应用关联的小程序，image_text_area.type是2时必填</p>
     * 必填：否
     */
    private String appid;

    /**
     * <p>点击跳转的小程序的pagepath，image_text_area.type是2时选填</p>
     * 必填：否
     */
    private String pagePath;

    /**
     * <p>左图右文样式的标题</p>
     * 必填：否
     */
    private String title;

    /**
     * <p>左图右文样式的描述</p>
     * 必填：否
     */
    private String desc;

    /**
     * <p>左图右文样式的图片url</p>
     * 必填：是
     */
    private String imageUrl;

    public static ImageTextArea instance() {
        return new ImageTextArea();
    }

    public ImageTextArea type(ClickTypeEnum type) {
        this.type = type;
        return this;
    }

    public ImageTextArea url(String url) {
        this.url = url;
        return this;
    }

    public ImageTextArea appid(String appid) {
        this.appid = appid;
        return this;
    }

    public ImageTextArea pagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }

    public ImageTextArea title(String title) {
        this.title = title;
        return this;
    }

    public ImageTextArea desc(String desc) {
        this.desc = desc;
        return this;
    }

    public ImageTextArea imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
