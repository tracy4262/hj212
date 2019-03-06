package com.hj212.format.hbt212.core.deser;

import java.io.IOException;

import com.hj212.format.hbt212.core.T212Parser;
import com.hj212.format.hbt212.exception.T212FormatException;

/**
 * T212反序列化器
 * Created by xiaoyao9184 on 2018/1/4.
 */
public interface T212Deserializer<Target> {

    Target deserialize(T212Parser parser) throws IOException, T212FormatException;
}
