package cn.com.pism.pmrb.wechat.work.msg.template.card;

import static cn.com.pism.pmrb.core.util.EnhanceUtil.isNotNull;
import static cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsgType.TEMPLATE_CARD;

/**
 * @author perccyking
 * @since 2024/5/6 15:37
 */
public class TemplateCardTextNotice extends TemplateCard<TemplateCardTextNotice> {

    private static final String CARD_TEXT_NOTICE_MSG = "{\"emphasis_content\":%s,\"sub_title_text\":\"%s\",%s}";

    public TemplateCardTextNotice() {
        super(TEMPLATE_CARD, CardTypeEnum.TEXT_NOTICE);
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

    public static TemplateCardTextNotice instance() {
        return new TemplateCardTextNotice();
    }

    public TemplateCardTextNotice emphasisContent(EmphasisContent emphasisContent) {
        this.emphasisContent = emphasisContent;
        return this;
    }

    public EmphasisContent getEmphasisContent() {
        return emphasisContent;
    }

    public TemplateCardTextNotice subTitleText(String subTitleText) {
        this.subTitleText = subTitleText;
        return this;
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
    public String getMsgContent() {
        return String.format(CARD_TEXT_NOTICE_MSG,
                isNotNull(getEmphasisContent(), EmphasisContent::toJson, JSON_BRACKETS),
                isNotNull(getSubTitleText(), item -> item, ""),
                super.toJson()
        );
    }

    @Override
    protected TemplateCardTextNotice getInstance() {
        return this;
    }
}
