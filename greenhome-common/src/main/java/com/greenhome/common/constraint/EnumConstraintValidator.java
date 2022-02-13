package com.greenhome.common.constraint;

import com.greenhome.common.annotation.EnumValid;
import com.greenhome.common.base.DefinitionException;
import com.greenhome.common.constant.Constant;
import com.greenhome.common.constant.GreenHomeEnum;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author smart_joker
 * @Date 2022/2/11 1:59 下午
 * @Description
 * @Version 1.0
 */
public class EnumConstraintValidator implements ConstraintValidator<EnumValid, Object> {
    private List<Object> values = new ArrayList<>();
    @Override
    public void initialize(EnumValid enumValidator) {
        Class<?> clz = enumValidator.target();
        Object[] objects = clz.getEnumConstants();
        try {
            Method method = clz.getMethod("getCode");
            if (Objects.isNull(method)) {
                throw new DefinitionException(GreenHomeEnum.ENUM_ERROR.getErrorCode(),String.format(Constant.StringFormatType.ENUM_ERROR,
                        clz.getName()));
            }
            Object value = null;
            for (Object obj : objects) {
                value = method.invoke(obj);
                values.add(value);
            }
        } catch (Exception e) {
            throw new DefinitionException(GreenHomeEnum.ENUM_ERROR);
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return Objects.isNull(value) || values.contains(value) ? true : false;
    }
}
