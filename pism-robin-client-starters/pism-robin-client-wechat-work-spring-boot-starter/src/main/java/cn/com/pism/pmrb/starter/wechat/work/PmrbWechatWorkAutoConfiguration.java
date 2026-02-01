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
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author perccyking
 * @since 24-09-16 14:38
 */
@AutoConfiguration
@EnableConfigurationProperties(WechatWorkProperties.class)
public class PmrbWechatWorkAutoConfiguration implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Environment environment;

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

        // 记录是否已经指定了 Primary，防止多个 Primary 冲突
        AtomicBoolean primaryAssigned = new AtomicBoolean(false);

        // 1. 判断外部配置 (Root) 是否不为空
        boolean rootHasConfig = StringUtils.hasText(wechatWorkProperties.getKey())
                || StringUtils.hasText(wechatWorkProperties.getWebhook());

        if (rootHasConfig) {
            // 规则：外部配置不为空，直接设为 Primary
            register(registry, "wechatWorkClient", wechatWorkProperties, true);
            primaryAssigned.set(true);
        }

        // 2. 处理 clients
        Map<String, WechatWorkProperties> clients = wechatWorkProperties.getClients();
        if (!CollectionUtils.isEmpty(clients)) {

            // 如果 Root 没占 Primary，需要判断 clients 里谁当 Primary
            String primaryCandidateName = null;
            if (!primaryAssigned.get()) {
                // 查找是否有显式标记为 primary 的 client
                primaryCandidateName = clients.entrySet().stream()
                        .filter(entry -> entry.getValue().isPrimary())
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);

                // 如果没找有标记的，取第一个作为 Primary
                if (primaryCandidateName == null) {
                    primaryCandidateName = clients.keySet().iterator().next();
                }
            }

            final String finalPrimaryName = primaryCandidateName;

            clients.forEach((name, prop) -> {
                // 如果当前循环的名字就是选定的候选人，或者是 prop 显式设了 primary 且还没分配过
                boolean isPrimary = false;
                if (!primaryAssigned.get() && name.equals(finalPrimaryName)) {
                    isPrimary = true;
                    primaryAssigned.set(true);
                }

                register(registry, name, prop, isPrimary);
            });
        }
    }

    private void register(BeanDefinitionRegistry registry, String name, WechatWorkProperties prop, boolean isPrimary) {
        RootBeanDefinition bd = new RootBeanDefinition(WechatWorkClient.class);
        bd.setInstanceSupplier(() -> buildClient(prop));
        bd.setTargetType(WechatWorkClient.class);

        if (isPrimary) {
            bd.setPrimary(true);
        }

        // 注册原始名称 Bean
        registry.registerBeanDefinition(name, bd);

        // 注册驼峰别名
        if (PropertyNameUtils.shouldConvert(name)) {
            registry.registerAlias(name, PropertyNameUtils.toCamelCase(name));
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