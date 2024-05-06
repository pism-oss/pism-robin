package cn.com.pism.pmrb.wechat.work.msg.template.card;

/**
 * 图片样式
 * @author perccyking
 * @since 2024/5/6 17:12
 */
public class CardImage {

    /**
     * <p>图片的url</p>
     * 必填：是
     */
    private String url;

    /**
     * 图片的宽高比，宽高比要小于2.25，大于1.3，不填该参数默认1.3
     */
    private Double aspectRatio;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
}
