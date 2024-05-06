package cn.com.pism.pmrb.wechat.work.msg;

import cn.com.pism.pmrb.core.util.CollectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author perccyking
 * @since 2024/5/2 10:32
 */
public class Text extends WechatWorkMsg {

    private static final String TEXT_MSG = "{\"content\":\"%s\",\"mentioned_list\":[%s],\"mentioned_mobile_list\":[%s]}";

    public Text() {
        super(WechatWorkMsgType.TEXT);
    }

    public static Text instance() {
        return new Text();
    }

    /**
     * <p>文本内容，最长不超过2048个字节，必须是utf8编码</p>
     * 必填：是
     */
    private String content;

    /**
     * <p>userid的列表，提醒群中的指定成员(@某个成员)，@all表示提醒所有人，
     * 如果开发者获取不到userid，可以使用mentioned_mobile_list</p>
     * 必填：否
     */
    private List<String> mentionedList;

    /**
     * <p>手机号列表，提醒手机号对应的群成员(@某个成员)，@all表示提醒所有人</p>
     * 必填：否
     */
    private List<String> mentionedMobileList;

    public Text content(String content) {
        this.content = content;
        return this;
    }

    public Text mentionedList(List<String> mentionedList) {
        this.mentionedList = mentionedList;
        return this;
    }

    public Text mentionedList(String... mentionedList) {
        this.mentionedList = new ArrayList<>(Arrays.asList(mentionedList));
        return this;
    }

    public Text mentionedMobileList(List<String> mentionedMobileList) {
        this.mentionedMobileList = mentionedMobileList;
        return this;
    }

    public Text mentionedMobileList(String... mentionedMobileList) {
        this.mentionedMobileList = new ArrayList<>(Arrays.asList(mentionedMobileList));
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getMentionedList() {
        return mentionedList;
    }

    public void setMentionedList(List<String> mentionedList) {
        this.mentionedList = mentionedList;
    }

    public List<String> getMentionedMobileList() {
        return mentionedMobileList;
    }

    public void setMentionedMobileList(List<String> mentionedMobileList) {
        this.mentionedMobileList = mentionedMobileList;
    }

    public Text atAll() {
        if (CollectionUtil.isNotEmpty(mentionedList)) {
            this.mentionedList.add(AT_ALL);
        } else if (CollectionUtil.isNotEmpty(mentionedMobileList)) {
            this.mentionedMobileList.add(AT_ALL);
        } else {
            this.mentionedList = new ArrayList<>();
            this.mentionedList.add(AT_ALL);
        }
        return this;
    }

    @Override
    public String getMsgContent() {
        String mentionedListStr = "";
        String mentionedMobileListStr = "";
        if (CollectionUtil.isNotEmpty(mentionedList)) {
            mentionedListStr = String.join("\",\"", mentionedList);
        }
        if (CollectionUtil.isNotEmpty(mentionedMobileList)) {
            mentionedMobileListStr = String.join("\",\"", mentionedMobileList);
        }

        return String.format(TEXT_MSG, content, String.format(STR, mentionedListStr), String.format(STR, mentionedMobileListStr));
    }

}
