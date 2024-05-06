package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsgType;

import java.util.List;

/**
 * @author perccyking
 * @since 2024/5/6 15:42
 */
public class TemplateCardNewsNotice extends TemplateCard<TemplateCardNewsNotice> {

    public TemplateCardNewsNotice() {
        super(WechatWorkMsgType.TEMPLATE_CARD, CardTypeEnum.NEWS_NOTICE);
    }

    /**
     * <p>图片样式</p>
     * 必填：是
     */
    private CardImage cardImage;

    /**
     * <p>左图右文样式</p>
     * 必填：否
     */
    private ImageTextArea imageTextArea;

    public static TemplateCardNewsNotice instance() {
        return new TemplateCardNewsNotice();
    }

    public TemplateCardNewsNotice cardImage(CardImage cardImage) {
        this.cardImage = cardImage;
        return this;
    }

    public TemplateCardNewsNotice imageTextArea(ImageTextArea imageTextArea) {
        this.imageTextArea = imageTextArea;
        return this;
    }

    /**
     * <p>卡片二级垂直内容，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过4</p>
     * 必填：否
     */
    private List<VerticalContent> verticalContentList;

    public CardImage getCardImage() {
        return cardImage;
    }

    public void setCardImage(CardImage cardImage) {
        this.cardImage = cardImage;
    }

    public ImageTextArea getImageTextArea() {
        return imageTextArea;
    }

    public void setImageTextArea(ImageTextArea imageTextArea) {
        this.imageTextArea = imageTextArea;
    }

    public List<VerticalContent> getVerticalContentList() {
        return verticalContentList;
    }

    public void setVerticalContentList(List<VerticalContent> verticalContentList) {
        this.verticalContentList = verticalContentList;
    }

    @Override
    protected String getMsgContent() {
        return "";
    }

    @Override
    protected TemplateCardNewsNotice getInstance() {
        return this;
    }
}
