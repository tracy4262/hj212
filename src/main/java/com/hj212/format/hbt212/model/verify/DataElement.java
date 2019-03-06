package com.hj212.format.hbt212.model.verify;

import com.hj212.format.hbt212.model.verify.groups.TypeGroup;

/**
 * 数据段 元素
 * Created by xiaoyao9184 on 2017/12/19.
 */
 @SuppressWarnings("rawtypes")
public enum DataElement {
    QN(TypeGroup.YYYYMMDDhhmmsszzz.class),
    PNUM(Group.PNUM.class,false),
    PNO(Group.PNO.class,false),
    ST(Group.ST.class),
    CN(Group.CN.class),
    PW(Group.PW.class),
    MN(Group.MN.class),
    Flag(Group.Flag.class),
    CP(Group.CP.class);

	private Class group;
    private boolean required;

	DataElement(Class group){
        this.group = group;
        this.required = true;
    }

    DataElement(Class group, boolean required){
        this.group = group;
        this.required = required;
    }


    public Class group() {
        return group;
    }

    public boolean isRequired() {
        return required;
    }

    public interface Group {
        interface QN{}
        interface PNUM{}
        interface PNO{}
        interface ST{}
        interface CN{}
        interface PW{}
        interface MN{}
        interface Flag{}
        interface CP{}
    }

}
