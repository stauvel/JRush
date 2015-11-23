package org.jrush;

import org.jrush.spi.ExerciceServiceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ExerciceServiceLoader c() {
        return new ExerciceServiceLoader();
    }
	
}