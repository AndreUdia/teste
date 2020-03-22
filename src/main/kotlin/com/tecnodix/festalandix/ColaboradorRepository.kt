package com.tecnodix.festalandix

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ColaboradorRepository : CrudRepository<Colaborador, Long> {
    fun findByNome(nome: String): List<Colaborador>
}