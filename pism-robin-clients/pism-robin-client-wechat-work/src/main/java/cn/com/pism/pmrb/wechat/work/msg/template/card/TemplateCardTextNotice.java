package cn.com.pism.pmrb.wechat.work.msg.template.card;

import static cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsgType.TEMPLATE_CARD;

/**
 * @author perccyking
 * @since 2024/5/6 15:37
 */
public class TemplateCardTextNotice extends TemplateCard {

    public TemplateCardTextNotice() {
        super(TEMPLATE_CARD, CardType.TEXT_NOTICE);
    }

    /**
     * <p>关键数据样式</p>
     * 必填：否
     */
    private EmphasisContent emphasisContent;

    /**
     * <p>二级普通文本，建议不超过112个字。模版卡片主要内容的一级标题main_title.title和二级普通文本sub_title_text必须有一项填写</p>
     * 必填：否
     */
    private String subTitleText;

    public EmphasisContent getEmphasisContent() {
        return emphasisContent;
    }

    public void setEmphasisContent(EmphasisContent emphasisContent) {
        this.emphasisContent = emphasisContent;
    }

    public String getSubTitleText() {
        return subTitleText;
    }

    public void setSubTitleText(String subTitleText) {
        this.subTitleText = subTitleText;
    }

    @Override
    protected String getMsgContent() {
        return "";
    }
}
