package com.desafios.soccer.service.mapper.common;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class TeamMapperToLeagueConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
