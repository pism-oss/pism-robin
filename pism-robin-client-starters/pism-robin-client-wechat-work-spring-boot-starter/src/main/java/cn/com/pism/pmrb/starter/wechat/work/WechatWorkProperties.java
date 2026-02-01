package cn.com.pism.pmrb.starter.wechat.work;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author perccyking
 * @since 24-09-16 14:32
 */
@Data
@ConfigurationProperties(prefix = WechatWorkProperties.PREFIX)
@Component
public class WechatWorkProperties {

    public static final String PREFIX = "spring.robin.wechat-work";

    /**
     * 客户端
     */
    private Map<String, WechatWorkProperties> clients;

    /**
     * key
     */
    private String key;

    /**
     * webhook
     * <pre>
     *     优先级最高，设置后，key会失效
     * </pre>
     */
    private String webhook;

    /**
     * 延时发送时间，默认null 不延时发送，毫秒
     */
    private Long delay;
}
