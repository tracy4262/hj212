package com.hj212.format.segment.core.ser;

import java.io.IOException;

import com.hj212.format.segment.core.SegmentGenerator;
import com.hj212.format.segment.exception.SegmentFormatException;

/**
 * Created by xiaoyao9184 on 2018/2/24.
 */
public interface SegmentSerializer<Target> {

    void serialize(SegmentGenerator generator, Target target) throws IOException, SegmentFormatException;
}
