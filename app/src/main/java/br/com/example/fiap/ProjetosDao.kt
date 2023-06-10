package br.com.example.fiap
class ProjetosDao {

    fun add(projeto: Projeto) {
        projetos.add(projeto)
    }

    fun buscaTodos() : List<Projeto> {
        return Companion.projetos.toList()
    }

    companion object {
        private val projetos = mutableListOf<Projeto>()
    }
}