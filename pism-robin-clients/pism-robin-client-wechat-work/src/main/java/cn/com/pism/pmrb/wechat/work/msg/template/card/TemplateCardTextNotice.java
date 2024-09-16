package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.core.model.JsonConcat;
import cn.com.pism.pmrb.core.util.StringUtil;
import cn.com.pism.pmrb.wechat.work.msg.enums.CardTypeEnum;

import static cn.com.pism.pmrb.core.model.RobinConstant.JSON;
import static cn.com.pism.pmrb.core.util.EnhanceUtil.isNotNull;
import static cn.com.pism.pmrb.wechat.work.WechatWorkConstant.EMPHASIS_CONTENT;
import static cn.com.pism.pmrb.wechat.work.WechatWorkConstant.SUB_TITLE_TEXT;
import static cn.com.pism.pmrb.wechat.work.msg.enums.WechatWorkMsgTypeEnum.TEMPLATE_CARD;

/**
 * @author perccyking
 * @since 2024/5/6 15:37
 */
public class TemplateCardTextNotice extends TemplateCard<TemplateCardTextNotice> {

    private static final String CARD_TEXT_NOTICE_MSG = "{%s,%s}";

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
        String textNotice = JsonConcat.instance()
                .concat(EMPHASIS_CONTENT, isNotNull(emphasisContent, EmphasisContent::toJson))
                .concat(SUB_TITLE_TEXT, subTitleText)
                .concat();
        if (StringUtil.isBlank(textNotice)) {
            return String.format(JSON, super.toJson());
        }
        return String.format(CARD_TEXT_NOTICE_MSG,
                super.toJson(),
                textNotice

        );
    }

    @Override
    protected TemplateCardTextNotice getInstance() {
        return this;
    }
}
