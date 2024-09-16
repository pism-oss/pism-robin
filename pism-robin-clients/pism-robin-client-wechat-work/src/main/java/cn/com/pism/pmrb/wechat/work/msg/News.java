package cn.com.pism.pmrb.wechat.work.msg;

import cn.com.pism.pmrb.core.util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

import static cn.com.pism.pmrb.wechat.work.msg.enums.WechatWorkMsgTypeEnum.NEWS;

/**
 * @author perccyking
 * @since 2024/5/6 10:43
 */
public class News extends WechatWorkMsg {

    private static final String NEWS_MSG = "{\"articles\":[%s]}";

    private static final String NEWS_MSG_ARTICLE = "{\"title\":\"%s\",\"description\":\"%s\",\"url\":\"%s\",\"picurl\":\"%s\"}";

    /**
     * <p>图文消息，一个图文消息支持1到8条图文</p>
     * 必填：是
     */
    private List<NewsArticle> articles;

    public News() {
        super(NEWS);
    }

    public static News instance() {
        return new News();
    }

    public List<NewsArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticle> articles) {
        this.articles = articles;
    }

    public News addArticle(NewsArticle article) {
        if (CollectionUtil.isEmpty(articles)) {
            this.articles = new ArrayList<>();
        }
        this.articles.add(article);
        return this;
    }

    public News articles(List<NewsArticle> articles) {
        this.articles = articles;
        return this;
    }

    @Override
    public String getMsgContent() {
        if (CollectionUtil.isNotEmpty(articles)) {
            if (articles.size() > 8) {
                articles = articles.subList(0, 7);
            }
            List<String> articleList = new ArrayList<>();
            for (NewsArticle article : articles) {
                articleList.add(String.format(NEWS_MSG_ARTICLE, article.getTitle(), article.getDescription(), article.getUrl(), article.getPicUrl()));
            }
            return String.format(NEWS_MSG, String.join(",", articleList));
        }
        return "";
    }
}
