package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.core.model.JsonConcat;

import static cn.com.pism.pmrb.wechat.work.WechatWorkConstant.DESC;
import static cn.com.pism.pmrb.wechat.work.WechatWorkConstant.TITLE;

/**
 * @author perccyking
 * @since 2024/5/6 15:53
 */
public class EmphasisContent {

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
        return JsonConcat.instance()
                .concat(TITLE, title)
                .concat(DESC, desc)
                .toJson();
    }
}
