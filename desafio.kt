enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val email: String, val whatsapp: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario : Usuario) {
        inscritos.add(usuario)
    }
    
    fun matricular(usuarios : Collection<Usuario>){
        inscritos.addAll(usuarios)
    }
   
}


fun gerarSaidaDeInformacao(formacao: Formacao) {
    println("Formação:  ${formacao.nome} (inscrições: ${formacao.inscritos?.size ?: 0})")
    formacao.inscritos?.forEach{ i -> println(i.nome)}

}

fun main() {
 
    //criando formação Desbravando Kotlin
    var desbravandoKotlin : Formacao = Formacao("Desbravando Kotlin", 
                                                listOf(	ConteudoEducacional("modulo 1", Nivel.BASICO, 2),
                         			            		ConteudoEducacional("Modulo 2", Nivel.INTERMEDIARIO, 12),
                                    					ConteudoEducacional("Modulo 3", Nivel.AVANCADO, 3)
    ))
    
    gerarSaidaDeInformacao(desbravandoKotlin)
    //adicionando matrículas / usuários à formação já criada
    desbravandoKotlin.matricular(Usuario("José Espedito", "jose@gmail", "62991100000")).also{
        gerarSaidaDeInformacao(desbravandoKotlin)
    }
    
    desbravandoKotlin.matricular(listOf(Usuario("João", "joao@gmail", "62999999999"), 
                                        Usuario("Maria", "maria@outlook", "2199999999"),
                                        Usuario("Bartolomeu", "barto@gmail.com", "1198888888"))).also{
        gerarSaidaDeInformacao(desbravandoKotlin)
    }
    
}