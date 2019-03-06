package com.hj212.format.segment.core.deser;

import java.io.IOException;

import com.hj212.format.segment.core.SegmentParser;
import com.hj212.format.segment.exception.SegmentFormatException;

/**
 * Created by xiaoyao9184 on 2018/1/4.
 */
public interface SegmentDeserializer<Target> {

    Target deserialize(SegmentParser parser) throws IOException, SegmentFormatException;
}
