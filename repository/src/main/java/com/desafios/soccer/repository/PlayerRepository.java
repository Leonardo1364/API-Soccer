package com.desafios.soccer.repository;

import com.desafios.soccer.model.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface PlayerRepository extends MongoRepository<Player, String> {

}
