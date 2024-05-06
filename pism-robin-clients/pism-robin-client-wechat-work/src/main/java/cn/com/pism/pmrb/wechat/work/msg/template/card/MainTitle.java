package cn.com.pism.pmrb.wechat.work.msg.template.card;

/**
 * @author perccyking
 * @since 2024/5/6 15:26
 */
public class MainTitle {

    /**
     * <p>一级标题，建议不超过26个字。模版卡片主要内容的一级标题main_title.title和二级普通文本sub_title_text必须有一项填写</p>
     * 必填：否
     */
    private String title;

    /**
     * <p>标题辅助信息，建议不超过30个字</p>
     * 必填：否
     */
    private String desc;

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
