package cesarb98.com.github.t_space.navigation

enum class Routes(val route: String) {
    START("start"),
    MENU("menu"),
    EMPRESA("empresa/{empresaId}"),
    DETALHES("detalhes/{viagemId}");

    companion object {
        fun empresaComId(id: String) = "empresa/$id"
        fun detalhesComId(id: String) = "detalhes/$id"
    }
}