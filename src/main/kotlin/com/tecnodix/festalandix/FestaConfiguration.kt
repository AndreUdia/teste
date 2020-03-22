package com.tecnodix.festalandix

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FestaConfiguration {

    @Bean
    fun databaseInitializer(colaboradorRepository: ColaboradorRepository) = ApplicationRunner {

        colaboradorRepository.save(Colaborador("andre", "andresouto@landix.com.br", "123"))
        colaboradorRepository.save(Colaborador("daniel", "daniel@landix.com.br", "123"))
    }
}