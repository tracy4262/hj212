package com.hj212.format.segment.core.deser;


import java.io.IOException;

import com.hj212.format.segment.core.SegmentParser;
import com.hj212.format.segment.core.SegmentToken;

/**
 * Created by xiaoyao9184 on 2017/12/15.
 */
public class StringSegmentDeserializer
        implements SegmentDeserializer<String> {

    @Override
    public String deserialize(SegmentParser parser) throws IOException {
        String result = null;
        SegmentToken token = parser.currentToken();
        switch (token){
            case NOT_AVAILABLE:
            case NULL_VALUE:
                break;
            case END_ENTRY:
            case END_SUB_ENTRY:
            case END_PART_KEY:
            case END_OBJECT_VALUE:
                result = parser.readKey();
                break;
            case END_KEY:
                result = parser.readValue();
                break;
            case START_OBJECT_VALUE:
                //遇到Object Value读Value
                result = parser.readObjectValue();
                break;
        }

        return result;
    }

}
