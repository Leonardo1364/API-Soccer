package com.soccer.embeddedmongo;

import com.mongodb.client.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.Objects;

@Configuration
public class MongoConfig {

    private static final String MONGO_DB_URL = "127.0.0.1";
    private static final Integer MONGO_DB_PORT = 22022;
    private static final String MONGO_DB_NAME = "embedded_db";

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(MONGO_DB_URL);
        mongo.setPort(MONGO_DB_PORT);
        MongoClient mongoClient = (MongoClient) mongo.getObject();
        return new MongoTemplate(Objects.requireNonNull(mongoClient), MONGO_DB_NAME);
    }

}
