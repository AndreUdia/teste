package com.tecnodix.festalandix

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Colaborador (
        var nome: String,
        var email: String,
        var senha: String,
        @Id @GeneratedValue var id: Long? = null
)