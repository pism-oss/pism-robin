package cn.com.pism.pmrb.starter.wechat.work;

import cn.com.pism.pmrb.wechat.work.WechatWorkClient;
import cn.com.pism.pmrb.wechat.work.WechatWorkConfig;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author perccyking
 * @since 24-09-16 14:38
 */
@AutoConfiguration
@EnableConfigurationProperties(WechatWorkProperties.class)
public class PmrbWechatWorkAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(WechatWorkClient.class)
    public WechatWorkClient wechatWorkClient(WechatWorkProperties wechatWorkProperties) {
        WechatWorkConfig wechatWorkConfig = new WechatWorkConfig();
        wechatWorkConfig.setKey(wechatWorkProperties.getKey());
        wechatWorkConfig.setWebhook(wechatWorkProperties.getWebhook());
        wechatWorkConfig.setDelay(wechatWorkProperties.getDelay());
        return new WechatWorkClient(wechatWorkConfig);
    }

    @Bean
    public Map<String, WechatWorkClient> wechatWorkClientMap(WechatWorkProperties wechatWorkProperties, ConfigurableListableBeanFactory beanFactory) {
        Map<String, WechatWorkClient> clientMap = new HashMap<>();
        Map<String, WechatWorkProperties> clients = wechatWorkProperties.getClients();
        if (!CollectionUtils.isEmpty(clients)) {
            clients.forEach((k, v) -> clientMap.put(k, wechatWorkClient(v)));
        }

        clientMap.forEach(beanFactory::registerSingleton);

        return clientMap;

    }
}
