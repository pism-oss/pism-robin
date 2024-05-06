package cn.com.pism.pmrb.core.model;

import java.util.concurrent.TimeUnit;

/**
 * 通用配置
 *
 * @author perccyking
 * @since 2024/5/1 18:55
 */
public class RobinConfig {

    /**
     * 延时发送时间，默认null 不延时发送，毫秒
     */
    private Long delay;

    /**
     * http客户端，默认为robin 实现
     */
    private RobinHttp httpClient = new RobinHttpClient();

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    public void setDelay(long delay, TimeUnit timeUnit) {
        this.delay = timeUnit.toMillis(delay);
    }

    public RobinHttp getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(RobinHttp httpClient) {
        this.httpClient = httpClient;
    }
}
