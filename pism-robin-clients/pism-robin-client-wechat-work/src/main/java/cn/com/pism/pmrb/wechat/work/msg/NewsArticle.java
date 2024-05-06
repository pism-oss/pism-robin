package cn.com.pism.pmrb.wechat.work.msg;

/**
 * @author perccyking
 * @since 2024/5/6 10:48
 */
public class NewsArticle {

    /**
     * <p>标题，不超过128个字节，超过会自动截断</p>
     * 必填：是
     */
    private String title;

    /**
     * <P>描述，不超过512个字节，超过会自动截断</P>
     * 必填：否
     */
    private String description;

    /**
     * <p>点击后跳转的链接。</p>
     * 必填：是
     */
    private String url;

    /**
     * <p>图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。</p>
     * 必填：否
     */
    private String picUrl;

    public NewsArticle() {
    }

    public NewsArticle(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public NewsArticle(String title, String description, String url, String picUrl) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public static NewsArticle instance() {
        return new NewsArticle();
    }

    public NewsArticle title(String title) {
        this.title = title;
        return this;
    }

    public NewsArticle description(String description) {
        this.description = description;
        return this;
    }

    public NewsArticle url(String url) {
        this.url = url;
        return this;
    }

    public NewsArticle picUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }
}
