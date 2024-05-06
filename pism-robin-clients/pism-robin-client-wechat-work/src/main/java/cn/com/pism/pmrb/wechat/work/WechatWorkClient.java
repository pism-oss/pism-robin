package cn.com.pism.pmrb.wechat.work;


import cn.com.pism.pmrb.core.function.AbstractRobinClient;
import cn.com.pism.pmrb.core.model.RobinHttp;
import cn.com.pism.pmrb.core.model.RobinMsg;
import cn.com.pism.pmrb.wechat.work.msg.WechatWorkMsg;

/**
 * 微信群机器人客户端
 *
 * @author perccyking
 * @since 2024/4/29 17:18
 */
public class WechatWorkClient extends AbstractRobinClient<WechatWorkMsg, WechatWorkConfig> {


    public WechatWorkClient(WechatWorkConfig config) {
        super(config);
    }

    @Override
    protected void doSend(RobinMsg<WechatWorkMsg> msg) {
        WechatWorkMsg wechatWorkMsg = msg.getMsg();
        if (logger.isTraceEnabled()) {
            logger.info("[WechatWorkClient] send msg:{}", wechatWorkMsg);
        }
        String webhook = getConfig().getWebhook();
        RobinHttp httpClient = getConfig().getHttpClient();
        httpClient.doPost(webhook, wechatWorkMsg.toString());
    }
}
