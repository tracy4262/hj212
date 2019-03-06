package com.hj212.format.hbt212.core.validator.clazz;

import javax.validation.ConstraintValidator;

import com.hj212.format.hbt212.core.validator.field.N;
import com.hj212.format.hbt212.core.validator.field.NValidator;
import com.hj212.format.hbt212.model.verify.T212Map;

/**
 * Created by xiaoyao9184 on 2018/1/10.
 */
public class T212MapNValidator
        extends T212MapFieldValidator<FieldN,N>
        implements ConstraintValidator<FieldN,T212Map<String,?>> {

    public T212MapNValidator() {
        super(new NValidator());
    }

    @Override
    public String getField(FieldN fieldN) {
        return fieldN.field();
    }

    @Override
    public N getAnnotation(FieldN fieldN) {
        return fieldN.value();
    }

    @Override
    public boolean isFieldRegex(FieldN fieldN) {
        return fieldN.regex();
    }

    @Override
    public String getFieldMessage(N value) {
        return value.message();
    }
}
