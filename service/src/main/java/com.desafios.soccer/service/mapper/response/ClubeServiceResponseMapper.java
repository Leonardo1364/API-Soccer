package com.desafios.soccer.service.mapper.response;

import com.desafios.soccer.model.entity.Clube;
import com.desafios.soccer.service.model.response.ClubeServiceResponse;

//@Mapper
public interface ClubeServiceResponseMapper {

    static ClubeServiceResponse toClubeResponse(Clube clubeResponse) {
        if (clubeResponse == null) {
            return null;
        }

        return ClubeServiceResponse.builder()
                .id(clubeResponse.getId())
                .nome(clubeResponse.getNome())
                .reputacaoHistorica(clubeResponse.getReputacaoHistorica())
                .saldo(clubeResponse.getSaldo())
                .build();
    }

    /*static ClubeServiceResponse toClubeResponse(Clube clubeRequest) {
        return Mappers.getMapper(ClubeServiceResponseMapper.class)
                .mapper(clubeRequest);
    }

    ClubeServiceResponse mapper(Clube clubeRequest);*/

}
