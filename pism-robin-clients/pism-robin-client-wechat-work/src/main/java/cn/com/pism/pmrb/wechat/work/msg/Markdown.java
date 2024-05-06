package cn.com.pism.pmrb.wechat.work.msg;

import static cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsgType.MARKDOWN;

/**
 * @author perccyking
 * @since 2024/5/5 10:35
 */
public class Markdown extends WechatWorkMsg {

    private static final String MARKDOWN_MSG = "{\"content\":\"%s\"}";

    private static final String HASH = "#";

    private static final String BOLD = "**%s**";

    private static final String LINK = "[%s](%s)";

    private static final String CODE = "`%s`";

    private static final String COLOR_TEXT = "<font color=%s>%s</font>";

    private static final String LINE_BREAK = "\n";

    public Markdown() {
        super(MARKDOWN);
    }

    public static Markdown instance() {
        return new Markdown();
    }

    /**
     * <p>markdown内容，最长不超过4096个字节，必须是utf8编码</p>
     * 必填：是
     */
    private String content = "";

    public Markdown content(String content) {
        this.content = content;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getMsgContent() {
        return String.format(MARKDOWN_MSG, getContent());
    }

    /**
     * <p>
     * 添加一行
     * </p>
     * by PerccyKing
     *
     * @param line : 行
     * @return {@link Markdown}
     * @since 2024/5/5 11:27
     */
    public Markdown addLine(String line) {
        this.content = this.content + LINE_BREAK + line;
        return this;
    }

    /**
     * <p>
     * 追加文本
     * </p>
     * by PerccyKing
     *
     * @param text : 文本
     * @return {@link Markdown}
     * @since 2024/5/5 11:58
     */
    public Markdown append(String text) {
        this.content = this.content + text;
        return this;
    }

    /**
     * <p>
     * 添加标题，默认1级
     * </p>
     * by PerccyKing
     *
     * @param title : 标题
     * @return {@link Markdown} markdown
     * @since 2024/5/5 11:13
     */
    public Markdown addTitle(String title) {
        return addTitle(title, 1);
    }

    /**
     * <p>
     * 添加标题，支持1-6级，如果大于6，默认6级
     * </p>
     * by PerccyKing
     *
     * @param title : 标题
     * @param level : 等级
     * @return {@link Markdown} markdown
     * @since 2024/5/5 11:13
     */
    public Markdown addTitle(String title, int level) {
        StringBuilder titleLevel = new StringBuilder();
        if (level > 6) {
            level = 6;
        }
        for (int i = 0; i < level; i++) {
            titleLevel.append(HASH);
        }
        return addLine(titleLevel + " " + title);
    }

    /**
     * <p>
     * 添加加粗文本
     * </p>
     * by PerccyKing
     *
     * @param text      : 文本
     * @param breakLine : 是否换行 true:换行,false:不换行
     * @return {@link Markdown}
     * @since 2024/5/5 11:31
     */
    public Markdown addBoldText(String text, boolean breakLine) {
        String boldText = String.format(BOLD, text);
        if (breakLine) {
            return addLine(boldText);
        } else {
            return append(boldText);
        }
    }

    /**
     * <p>
     * 添加链接
     * </p>
     * by PerccyKing
     *
     * @param link      : 链接
     * @param linkName  : 链接名称
     * @param breakLine : 是否换行 true:换行,false:不换行
     * @return {@link Markdown}
     * @since 2024/5/5 11:37
     */
    public Markdown addLink(String link, String linkName, boolean breakLine) {
        String linkText = String.format(LINK, linkName, link);
        if (breakLine) {
            return addLine(linkText);
        } else {
            return append(linkText);
        }
    }

    /**
     * <p>
     * 添加代码片段
     * </p>
     * by PerccyKing
     *
     * @param code : 代码片段
     * @return {@link Markdown}
     * @since 2024/5/5 11:54
     */
    public Markdown addCodeSnippet(String code) {
        return addLine(String.format(CODE, code));
    }

    public static String colorText(String text, MarkdownTextColor color) {
        return String.format(COLOR_TEXT, color.getCode(), text);
    }

    public static String bold(String text) {
        return String.format(BOLD, text);
    }

}
