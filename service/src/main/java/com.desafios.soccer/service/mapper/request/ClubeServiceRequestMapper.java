package com.desafios.soccer.service.mapper.request;

import com.desafios.soccer.model.entity.Clube;
import com.desafios.soccer.service.model.request.ClubeServiceRequest;

//@Mapper
public interface ClubeServiceRequestMapper {

    static Clube toClubeEntity(ClubeServiceRequest clubeRequest) {
        if (clubeRequest == null) {
            return null;
        }

        return Clube.builder()
                .id(clubeRequest.getId())
                .nome(clubeRequest.getNome())
                .reputacaoHistorica(clubeRequest.getReputacaoHistorica())
                .saldo(clubeRequest.getSaldo())
                .build();
    }

    /*static Clube toClubeEntity(ClubeServiceRequest clubeRequest) {
        return Mappers.getMapper(ClubeServiceRequestMapper.class)
                .mapper(clubeRequest);
    }

    Clube mapper(ClubeServiceRequest clubeRequest);*/

}
