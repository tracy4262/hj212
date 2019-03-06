package com.hj212.format.segment.core.ser;

import java.io.IOException;
import java.util.Map;

import com.hj212.format.segment.core.SegmentGenerator;
import com.hj212.format.segment.exception.SegmentFormatException;

/**
 * Created by xiaoyao9184 on 2017/12/15.
 */
public class StringMapSegmentSerializer
        implements SegmentSerializer<Map<String,String>> {

    @Override
    public void serialize(SegmentGenerator generator, Map<String, String> data) throws IOException, SegmentFormatException {
        if(generator.nextToken() == null){
            generator.initToken();
        }
        writeMap(generator,data);
    }

    private void writeMap(SegmentGenerator generator, Map<String, String> result) throws IOException, SegmentFormatException {
        for (Map.Entry<String, String> kv : result.entrySet()) {
            generator.writeKey(kv.getKey());
            generator.writeValue(kv.getValue());
        }
    }

}
