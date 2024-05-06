package cn.com.pism.pmrb.wechat.work.msg.template.card;

import static cn.com.pism.pmrb.wechat.work.msg.template.card.DescColorEnum.GREY;

/**
 * @author perccyking
 * @since 2024/5/6 15:21
 */
public class Source {

    /**
     * <p>来源图片的url</p>
     * 必填：否
     */
    private String iconUrl;

    /**
     * <p>来源图片的描述，建议不超过13个字</p>
     */
    private String desc;

    /**
     * <p>来源文字的颜色，目前支持：0(默认) 灰色，1 黑色，2 红色，3 绿色</p>
     */
    private DescColorEnum descColor = GREY;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DescColorEnum getDescColor() {
        return descColor;
    }

    public void setDescColor(DescColorEnum descColor) {
        this.descColor = descColor;
    }
}
