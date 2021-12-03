package com.desafios.soccer.repository;

import com.desafios.soccer.model.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface TeamRepository extends MongoRepository<Team, String> {

}
