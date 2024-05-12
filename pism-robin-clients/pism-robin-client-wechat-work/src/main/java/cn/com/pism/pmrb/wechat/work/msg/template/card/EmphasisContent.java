package cn.com.pism.pmrb.wechat.work.msg.template.card;

import static cn.com.pism.pmrb.core.util.EnhanceUtil.isNotNullOrDef;

/**
 * @author perccyking
 * @since 2024/5/6 15:53
 */
public class EmphasisContent {

    public static final String MSG = "{\"title\":\"%s\",\"desc\":\"%s\"}";

    /**
     * <p>关键数据样式的数据内容，建议不超过10个字</p>
     * 必填：否
     */
    private String title;

    /**
     * <p>关键数据样式的数据描述内容，建议不超过15个字</p>
     * 必填：否
     */
    private String desc;

    public static EmphasisContent instance() {
        return new EmphasisContent();
    }

    public EmphasisContent title(String title) {
        this.title = title;
        return this;
    }

    public EmphasisContent desc(String desc) {
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

    public String toJson() {
        return String.format(MSG, isNotNullOrDef(title), isNotNullOrDef(desc));
    }
}
