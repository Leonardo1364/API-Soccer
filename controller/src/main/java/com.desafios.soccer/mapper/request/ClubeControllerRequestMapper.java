package com.desafios.soccer.mapper.request;

import com.desafios.soccer.model.request.ClubeControllerRequest;
import com.desafios.soccer.service.model.request.ClubeServiceRequest;

//@Mapper()
public interface ClubeControllerRequestMapper {

    static ClubeServiceRequest toClubeService(ClubeControllerRequest clubeRequest) {
        if (clubeRequest == null) {
            return null;
        }

        return ClubeServiceRequest.builder()
                .id(clubeRequest.getId())
                .nome(clubeRequest.getNome())
                .reputacaoHistorica(clubeRequest.getReputacaoHistorica())
                .saldo(clubeRequest.getSaldo())
                .build();
    }

    /*
    static ClubeServiceRequest toClubeService(ClubeControllerRequest clubeRequest) {
        return Mappers.getMapper(ClubeControllerRequestMapper.class)
                .mapperRequest(clubeRequest);
    }

    ClubeServiceRequest mapperRequest(ClubeControllerRequest clubeRequest);
    */

}
