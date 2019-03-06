package com.hj212.format.hbt212.core.ser;

import java.io.IOException;

import com.hj212.format.hbt212.core.T212Generator;
import com.hj212.format.hbt212.exception.T212FormatException;

/**
 * T212序列化器
 * Created by xiaoyao9184 on 2018/2/24.
 */
public interface T212Serializer<Target> {

    void serialize(T212Generator generator, Target target) throws IOException, T212FormatException;
}
