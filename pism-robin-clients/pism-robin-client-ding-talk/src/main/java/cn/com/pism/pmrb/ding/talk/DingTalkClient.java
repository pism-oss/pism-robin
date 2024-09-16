package cn.com.pism.pmrb.ding.talk;

import cn.com.pism.pmrb.core.function.AbstractRobinClient;
import cn.com.pism.pmrb.core.model.RobinMsg;

/**
 * @author perccyking
 * @since 2024/5/7 14:15
 */
public class DingTalkClient extends AbstractRobinClient<Object, DingTalkConfig> {

    protected DingTalkClient(DingTalkConfig config) {
        super(config);
    }

    @Override
    protected void doSend(RobinMsg<Object> msg) {

    }
}
