package cn.com.pism.pmrb.starter.wechat.work;

import cn.com.pism.pmrb.core.util.PropertyNameUtils;
import cn.com.pism.pmrb.wechat.work.WechatWorkClient;
import cn.com.pism.pmrb.wechat.work.WechatWorkConfig;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

/**
 * @author perccyking
 * @since 24-09-16 14:38
 */
@AutoConfiguration
@EnableConfigurationProperties(WechatWorkProperties.class)
@AutoConfigureAfter(WechatWorkProperties.class)
public class PmrbWechatWorkAutoConfiguration implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Environment environment;

    @Override
    public void postProcessBeanDefinitionRegistry(@NonNull BeanDefinitionRegistry registry) throws BeansException {
        WechatWorkProperties wechatWorkProperties = Binder.get(environment)
                .bind(WechatWorkProperties.PREFIX, WechatWorkProperties.class)
                .orElse(null);
        if (wechatWorkProperties == null || CollectionUtils.isEmpty(wechatWorkProperties.getClients())) {
            return;
        }

        wechatWorkProperties.getClients().forEach((name, prop) -> {
            RootBeanDefinition bd = new RootBeanDefinition(WechatWorkClient.class);
            bd.setInstanceSupplier(() -> buildClient(prop));
            registry.registerBeanDefinition(name, bd);

            if (PropertyNameUtils.shouldConvert(name)) {
                registry.registerAlias(name, PropertyNameUtils.toCamelCase(name));
            }
        });
    }

    private static WechatWorkClient buildClient(WechatWorkProperties properties) {
        WechatWorkConfig cfg = new WechatWorkConfig();
        cfg.setKey(properties.getKey());
        cfg.setWebhook(properties.getWebhook());
        cfg.setDelay(properties.getDelay());
        return new WechatWorkClient(cfg);
    }

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        this.environment = environment;
    }
}
