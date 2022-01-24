package com.soccer.repository;

import com.soccer.model.entity.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<TeamEntity, String> {

}
