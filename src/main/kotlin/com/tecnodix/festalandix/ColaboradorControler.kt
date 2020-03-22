package com.tecnodix.festalandix

import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@RestController
class ColaboradorControler(private val colaboradorRepository: ColaboradorRepository) {

    @GetMapping("/")
    fun pagina(model: Model): String {
        model["titulo"] = "Festa Landix 2021"
        return "festalandix"
    }

    @GetMapping("/todos")
    fun all(): MutableIterable<Colaborador> = this.colaboradorRepository.findAll()

    @GetMapping("/{nome}")
    fun byName(@PathVariable(value = "nome") nome: String): List<Colaborador> {
        val colaboradorPorNome = this.colaboradorRepository.findByNome(nome)
        return colaboradorPorNome
    }

    @PostMapping("/cadastrar")
    fun checkIn(@RequestBody novoCadastro: Colaborador) {
        val colaborador = Colaborador(novoCadastro._nome, novoCadastro._email, novoCadastro._senha)
        this.colaboradorRepository.save(colaborador)
        println("Log ColaboradorControler linha 22: Cadastro de novo colaborador efetuado")
    }
}