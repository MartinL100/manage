package com.cong.checktime.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConf {
    public ObjectMapper objectMapper(){
        return  new ObjectMapper();
    }
}
