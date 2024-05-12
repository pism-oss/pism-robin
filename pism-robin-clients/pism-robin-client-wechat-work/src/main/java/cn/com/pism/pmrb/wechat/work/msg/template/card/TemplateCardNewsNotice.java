package cn.com.pism.pmrb.wechat.work.msg.template.card;

import cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsgType;

import java.util.List;
import java.util.stream.Collectors;

import static cn.com.pism.pmrb.core.util.EnhanceUtil.isNotNull;

/**
 * @author perccyking
 * @since 2024/5/6 15:42
 */
public class TemplateCardNewsNotice extends TemplateCard<TemplateCardNewsNotice> {

    private static final String CARD_NEWS_NOTICE_MSG = "{\"card_image\":%s,\"image_text_area\":%s,\"vertical_content_list\":[%s], %s}";

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

    /**
     * <p>卡片二级垂直内容，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过4</p>
     * 必填：否
     */
    private List<VerticalContent> verticalContentList;

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

    public TemplateCardNewsNotice verticalContentList(List<VerticalContent> verticalContentList) {
        this.verticalContentList = verticalContentList;
        return this;
    }

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
    public String getMsgContent() {
        return String.format(CARD_NEWS_NOTICE_MSG,
                isNotNull(getCardImage(), CardImage::toJson, JSON_BRACKETS),
                isNotNull(getImageTextArea(), ImageTextArea::toJson, JSON_BRACKETS),
                isNotNull(getVerticalContentList(), vcList -> vcList.stream().map(VerticalContent::toJson).collect(Collectors.joining(",")), ""),
                super.toJson()
        );
    }

    @Override
    protected TemplateCardNewsNotice getInstance() {
        return this;
    }
}
