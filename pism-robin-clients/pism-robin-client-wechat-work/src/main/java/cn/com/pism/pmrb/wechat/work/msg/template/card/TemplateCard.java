package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsg;
import cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsgType;

import java.util.List;

/**
 * 模版卡片
 *
 * @author perccyking
 * @since 2024/5/6 15:18
 */
public abstract class TemplateCard extends WechatWorkMsg {

    protected TemplateCard(WechatWorkMsgType msgType, CardType cardType) {
        super(msgType);
        this.cardType = cardType;
    }

    /**
     * <p>模版卡片的模版类型，文本通知模版卡片的类型为text_notice</p>
     * 必填：是
     */
    private CardType cardType;

    /**
     * <p>卡片来源样式信息，不需要来源样式可不填写</p>
     * 必填：否
     */
    private Source source;

    /**
     * <p>模版卡片的主要内容，包括一级标题和标题辅助信息</p>
     * 必填：否
     */
    private MainTitle mainTitle;

    /**
     * <p>引用文献样式，建议不与关键数据共用</p>
     * 必填：否
     */
    private QuotArea quotArea;

    /**
     * <p>二级标题+文本列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6</p>
     * 必填：否
     */
    private List<HorizontalContent> horizontalContentList;

    /**
     * <p>跳转指引样式的列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3</p>
     * 必填：否
     */
    private List<Jump> jumpList;

    /**
     * 整体卡片的点击跳转事件，news_notice模版卡片中该字段为必填项
     */
    private CardAction cardAction;

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public MainTitle getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(MainTitle mainTitle) {
        this.mainTitle = mainTitle;
    }

    public QuotArea getQuotArea() {
        return quotArea;
    }

    public void setQuotArea(QuotArea quotArea) {
        this.quotArea = quotArea;
    }

    public List<HorizontalContent> getHorizontalContentList() {
        return horizontalContentList;
    }

    public void setHorizontalContentList(List<HorizontalContent> horizontalContentList) {
        this.horizontalContentList = horizontalContentList;
    }

    public List<Jump> getJumpList() {
        return jumpList;
    }

    public void setJumpList(List<Jump> jumpList) {
        this.jumpList = jumpList;
    }

    public CardAction getCardAction() {
        return cardAction;
    }

    public void setCardAction(CardAction cardAction) {
        this.cardAction = cardAction;
    }
}
