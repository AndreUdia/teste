package com.tecnodix.festalandix

import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*


@RestController
class ColaboradorControler(private val colaboradorRepository: ColaboradorRepository) {

    @GetMapping(value = ["/", "/index.html"])
    fun festalandix(model: Model): String? {
        return "festalandix"
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