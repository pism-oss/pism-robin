package cn.com.pism.pmrb.core.function;

import cn.com.pism.pmrb.core.model.RobinConfig;
import cn.com.pism.pmrb.core.model.RobinMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author perccyking
 * @since 2024/4/29 17:05
 */
public abstract class AbstractRobinClient<M, C extends RobinConfig> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private C config;

    protected abstract void doSend(RobinMsg<M> msg);

    public void send(M msg, Map<String, Object> params) {
        Long delay = config.getDelay();
        if (delay != null) {
            //延时发送
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                if (logger.isErrorEnabled()) {
                    logger.error(e.getMessage(), e);
                }
                Thread.currentThread().interrupt();
            }
        } else {
            doSend(new RobinMsg<>(msg, params));
        }
    }

    protected AbstractRobinClient(C config) {
        this.config = config;
    }

    public C getConfig() {
        return config;
    }

    public void setConfig(C config) {
        this.config = config;
    }
}
