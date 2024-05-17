package com.mahdi.restfullapi.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordValueReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ModelMapper modelMapperBean() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().addValueReader(new RecordValueReader());
        return mapper;
    }
}
