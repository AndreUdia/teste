package com.tecnodix.festalandix

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.util.*
import kotlin.collections.List
import kotlin.collections.MutableIterable
import kotlin.collections.MutableMap
import kotlin.collections.set


@RestController
class ColaboradorControler(private val colaboradorRepository: ColaboradorRepository) {

    @GetMapping("/")
    fun index(): ModelAndView? {
        val model: MutableMap<String, String?> = HashMap()
        model["title"] = "Festa Landix 2021"
        return ModelAndView("index", model)
    }
    @GetMapping("/todos")
    fun todos(): MutableIterable<Colaborador> = this.colaboradorRepository.findAll()

    @GetMapping("/{nome}")
    fun porNome(@PathVariable(value = "nome") nome: String): List<Colaborador> {
        val colaboradorPorNome = this.colaboradorRepository.findByNome(nome)
        return colaboradorPorNome
    }

    @PostMapping("/cadastrar")
    fun cadastrar(@RequestBody novoCadastro: Colaborador) {
        val colaborador = Colaborador(novoCadastro.nome, novoCadastro.email, novoCadastro.senha)
        this.colaboradorRepository.save(colaborador)
        println("Log ColaboradorControler linha 22: Cadastro de novo colaborador efetuado")
    }
}