package com.hj212.format.hbt212.core.ser;

import javax.validation.Validator;

import com.hj212.format.hbt212.core.T212Generator;
import com.hj212.format.hbt212.core.VerifyUtil;
import com.hj212.format.hbt212.exception.T212FormatException;
import com.hj212.format.hbt212.model.verify.PacketElement;
import com.hj212.format.segment.base.cfger.Configurator;
import com.hj212.format.segment.base.cfger.Configured;
import com.hj212.format.segment.core.SegmentGenerator;
import com.hj212.format.segment.core.ser.SegmentSerializer;
import com.hj212.format.segment.exception.SegmentFormatException;

import static com.hj212.format.hbt212.core.feature.VerifyFeature.DATA_LEN_RANGE;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * 数据区 级别 序列化器
 * Created by xiaoyao9184 on 2017/12/15.
 */
public class CpDataLevelMapDataSerializer
        implements T212Serializer<Map<String,Object>>, Configured<CpDataLevelMapDataSerializer> {

    private int verifyFeature;
    private Configurator<SegmentGenerator> segmentGeneratorConfigurator;
    private SegmentSerializer<Map<String,Object>> segmentSerializer;
    @SuppressWarnings("unused")
	private Validator validator;

    @Override
    public void configured(Configurator<CpDataLevelMapDataSerializer> configurator){
        configurator.config(this);
    }

    @Override
    public void serialize(T212Generator generator, Map<String,Object> data) throws IOException, T212FormatException {
        generator.writeHeader();

        char[] segment = serialize(data);

        if(DATA_LEN_RANGE.enabledIn(verifyFeature)){
            int segmentLen = segment.length;
            VerifyUtil.verifyRange(segmentLen,0,1024, PacketElement.DATA_LEN);
        }
        generator.writeDataAndLenAndCrc(segment);
        generator.writeFooter();
    }

    public char[] serialize(Map<String, Object> data) throws IOException, T212FormatException {
        StringWriter writer = new StringWriter();
        SegmentGenerator generator = new SegmentGenerator(writer);
        generator.configured(segmentGeneratorConfigurator);

        try {
            segmentSerializer.serialize(generator,data);
        } catch (SegmentFormatException e) {
            T212FormatException.segment_exception(e);
        }
        return writer.toString().toCharArray();
    }

    public void setVerifyFeature(int verifyFeature) {
        this.verifyFeature = verifyFeature;
    }

    public void setSegmentGeneratorConfigurator(Configurator<SegmentGenerator> segmentGeneratorConfigurator) {
        this.segmentGeneratorConfigurator = segmentGeneratorConfigurator;
    }

    public void setSegmentSerializer(SegmentSerializer<Map<String, Object>> segmentSerializer) {
        this.segmentSerializer = segmentSerializer;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

}
