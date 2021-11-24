package com.desafios.soccer.mapper.response;

import com.desafios.soccer.model.response.ClubeControllerResponse;
import com.desafios.soccer.service.model.response.ClubeServiceResponse;

//@Mapper
public interface ClubeControllerResponseMapper {

    static ClubeControllerResponse toClubeResponseController(ClubeServiceResponse clubeServiceResponse) {
        return ClubeControllerResponse.builder()
                .id(clubeServiceResponse.getId())
                .nome(clubeServiceResponse.getNome())
                .reputacaoHistorica(clubeServiceResponse.getReputacaoHistorica())
                .saldo(clubeServiceResponse.getSaldo())
                .build();
    }

    /*static ClubeControllerResponse toClubeResponseController(ClubeServiceResponse clubeServiceResponse) {
        return Mappers.getMapper(ClubeControllerResponseMapper.class)
                .mapperResponse(clubeServiceResponse);
    }

    ClubeControllerResponse mapperResponse(ClubeServiceResponse clubeServiceResponse);*/

}
