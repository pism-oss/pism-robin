package cn.com.pism.pmrb.wechat.work.msg.template.card;

public class HorizontalContent {
    /**
     * <p>模版卡片的二级标题信息内容支持的类型，1是url，2是文件附件</p>
     * 必填：否
     */
    private Integer type;

    /**
     * <p>二级标题，建议不超过5个字</p>
     * 必填：是
     */
    private String keyName;

    /**
     * <p>二级文本，如果horizontal_content_list.type是2，该字段代表文件名称（要包含文件类型），建议不超过26个字</p>
     * 必填：否
     */
    private String value;

    /**
     * <p>链接跳转的url，horizontal_content_list.type是1时必填</p>
     * 必填：否
     */
    private String url;

    /**
     * <p>附件的media_id，horizontal_content_list.type是2时必填</p>
     * 必填：否
     */
    private String mediaId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}