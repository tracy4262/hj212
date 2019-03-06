package com.hj212.format.hbt212.model.verify;

import java.util.Map;

import com.hj212.format.hbt212.core.validator.clazz.FieldC;
import com.hj212.format.hbt212.core.validator.clazz.FieldN;
import com.hj212.format.hbt212.core.validator.clazz.FieldValidDate;
import com.hj212.format.hbt212.core.validator.field.C;
import com.hj212.format.hbt212.core.validator.field.N;
import com.hj212.format.hbt212.core.validator.field.ValidDate;
import com.hj212.format.hbt212.model.verify.groups.ModeGroup;
import com.hj212.format.hbt212.model.verify.groups.T212MapLevelGroup;

/**
 * T212 Map
 * 解决无法对MAP进行验证定义问题
 * Created by xiaoyao9184 on 2018/1/10.
 */
@SuppressWarnings("serial")
@FieldValidDate(field = "QN",
        value = @ValidDate(format = "yyyyMMddHHmmssSSS"))
@FieldC(field = "ST",
        value = @C(len = 2))
@FieldC(field = "CN",
        value = @C(len = 4))
@FieldC(field = "PW",
        value = @C(len = 6))
@FieldC(field = "MN",
        value = @C(len = 14))
@FieldN(field = "Flag",
        value = @N(integer = 3))
@FieldN(field = "PNUM", groups = ModeGroup.UseSubPacket.class,
        value = @N(integer = 4, optional = false))
@FieldN(field = "PNO", groups = ModeGroup.UseSubPacket.class,
        value = @N(integer = 4, optional = false))
@FieldC(field = "CP", groups = { T212MapLevelGroup.DataLevel.class },
        value = @C(len = 950))

@Deprecated
public class T212MapV2005<K,V>
        extends T212Map<K,V> {

    public T212MapV2005(Map<K, V> m) {
        super(m);
    }
}
