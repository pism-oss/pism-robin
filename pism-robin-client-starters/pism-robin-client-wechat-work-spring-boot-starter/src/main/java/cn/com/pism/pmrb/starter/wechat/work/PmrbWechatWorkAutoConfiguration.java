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
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author perccyking
 * @since 24-09-16 14:38
 */
@AutoConfiguration
@EnableConfigurationProperties(WechatWorkProperties.class)
public class PmrbWechatWorkAutoConfiguration implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Environment environment;

    /**
     * 保底或特殊条件下的 Bean 注册
     * 注意：由于 postProcessBeanDefinitionRegistry 运行非常早，
     * 如果那里注册了名为 "wechatWorkClient" 的 Bean，这里的 @Bean 可能会被跳过或覆盖
     */
    @Bean
    @Conditional(NoMatchConditional.class)
    public WechatWorkClient wechatWorkClient(WechatWorkProperties wechatWorkProperties) {
        return buildClient(wechatWorkProperties);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(@NonNull BeanDefinitionRegistry registry) throws BeansException {
        WechatWorkProperties wechatWorkProperties = Binder.get(environment)
                .bind(WechatWorkProperties.PREFIX, WechatWorkProperties.class)
                .orElse(null);

        if (wechatWorkProperties == null) {
            return;
        }

        boolean rootHasConfig = StringUtils.hasText(wechatWorkProperties.getKey())
                || StringUtils.hasText(wechatWorkProperties.getWebhook());

        if (rootHasConfig) {
            register(registry, "wechatWorkClient", wechatWorkProperties);
        }

        // 处理 clients
        Map<String, WechatWorkProperties> clients = wechatWorkProperties.getClients();
        if (!CollectionUtils.isEmpty(clients)) {
            clients.forEach((name, prop) -> register(registry, name, prop));
        }
    }

    /**
     * 通用注册方法，去掉了 isPrimary 参数
     */
    private void register(BeanDefinitionRegistry registry, String name, WechatWorkProperties prop) {
        // 如果容器中已经存在同名 Bean 定义，则跳过，防止重复注册
        if (registry.containsBeanDefinition(name)) {
            return;
        }

        RootBeanDefinition bd = new RootBeanDefinition(WechatWorkClient.class);
        bd.setInstanceSupplier(() -> buildClient(prop));
        bd.setTargetType(WechatWorkClient.class);

        // 注册原始名称 Bean
        registry.registerBeanDefinition(name, bd);

        // 注册驼峰别名
        if (PropertyNameUtils.shouldConvert(name)) {
            String alias = PropertyNameUtils.toCamelCase(name);
            if (!name.equals(alias)) {
                registry.registerAlias(name, alias);
            }
        }
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