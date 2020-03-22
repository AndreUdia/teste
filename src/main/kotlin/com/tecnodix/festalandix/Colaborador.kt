package com.tecnodix.festalandix

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Colaborador (var _nome: String, var _email: String, var _senha: String){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var nome = _nome
    var email = _email
    var senha = _senha

    constructor(): this("", "", "")
}