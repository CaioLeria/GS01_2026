package cesarb98.com.github.t_space.model

data class Empresa(
    val id: String,
    val nome: String,
    val descricao: String,
    val fundacao: String,
    val viagensDisponiveis: List<Viagem>
)

