package cn.com.pism.pmrb.starter.wechat.work;

import org.jspecify.annotations.NullMarked;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author perccyking
 * @since 26-02-01 11:14
 */
@NullMarked
public class NoMatchConditional extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return ConditionOutcome.noMatch("use default register");
    }
}
