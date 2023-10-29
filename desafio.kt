    enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 120)

class Formacao(val nome: String) {
    private val conteudos = mutableListOf<ConteudoEducacional>()
    private val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun matricular(usuario: Usuario) {
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    
    val formacao = Formacao("Ciência da Computação")
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)
    
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1)  // Tentativa de matricular o mesmo usuário novamente
    
    // Você pode adicionar mais testes e interações aqui
}
