package cn.com.pism.pmrb.wechat.work.msg.template.card;

public class VerticalContent {
    /**
     * <p>卡片二级标题，建议不超过26个字</p>
     * 必填：是
     */
    private String title;

    /**
     * <p>二级普通文本，建议不超过112个字</p>
     * 必填：否
     */
    private String desc;

    public static VerticalContent instance() {
        return new VerticalContent();
    }

    public VerticalContent title(String title) {
        this.title = title;
        return this;
    }

    public VerticalContent desc(String desc) {
        this.desc = desc;
        return this;
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
}