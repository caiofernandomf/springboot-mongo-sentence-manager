package net.springboot.caio.springbootmongosentencemanager.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class config extends AbstractMongoClientConfiguration {

    @Override
    public boolean autoIndexCreation(){
        return true;
    }

    @Override
    protected String getDatabaseName() {
        return "Words";
    }
}
