package com.desafios.soccer.service.mapper.response;

import com.desafios.soccer.model.entity.Clube;
import com.desafios.soccer.service.model.response.ClubeServiceResponse;

//@Mapper
public interface ClubeServiceResponseMapper {

    static ClubeServiceResponse toClubeResponse(Clube clubeRequest) {
        return ClubeServiceResponse.builder()
                .id(clubeRequest.getId())
                .nome(clubeRequest.getNome())
                .reputacaoHistorica(clubeRequest.getReputacaoHistorica())
                .saldo(clubeRequest.getSaldo())
                .build();
    }

    /*static ClubeServiceResponse toClubeResponse(Clube clubeRequest) {
        return Mappers.getMapper(ClubeServiceResponseMapper.class)
                .mapper(clubeRequest);
    }

    ClubeServiceResponse mapper(Clube clubeRequest);*/

}
