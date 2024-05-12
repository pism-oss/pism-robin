package cn.com.pism.pmrb.wechat.work;

import cn.com.pism.pmrb.core.model.RobinConfig;
import cn.com.pism.pmrb.core.util.StringUtil;

/**
 * @author perccyking
 * @since 2024/5/1 18:46
 */
public class WechatWorkConfig extends RobinConfig {

    /**
     * url
     */
    private String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=";

    /**
     * key
     */
    private String key;

    /**
     * webhook
     * <pre>
     *     优先级最高，如果设置了webhook
     *     url 和 token 会失效
     * </pre>
     */
    private String webhook;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWebhook() {
        if (StringUtil.isNotBlank(webhook)) {
            return webhook;
        }
        return url + key;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }
}
