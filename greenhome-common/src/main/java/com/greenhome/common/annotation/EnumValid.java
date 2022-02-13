package com.greenhome.common.annotation;

/**
 * @Author smart_joker
 * @Date 2022/2/11 2:01 下午
 * @Description
 * @Version 1.0
 */
import com.greenhome.common.constraint.EnumConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EnumConstraintValidator.class})
public @interface EnumValid {
    String message() default "";

    // 作用参考@Validated和@Valid的区别
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 目标枚举类
     */
    Class<?> target() default Class.class;

    /**
     * 是否忽略空值
     */
    boolean ignoreEmpty() default true;
}
