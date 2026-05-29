package cesarb98.com.github.t_space.model

object EmpresaViagemRepository {

    val listaDeEmpresas = listOf(
        Empresa(
            id = "e1",
            nome = "SpaceX",
            descricao = "Fundada por Elon Musk, a SpaceX revolucionou a tecnologia aeroespacial com foguetes reutilizáveis, buscando tornar a vida multiplanetária.",
            fundacao = "2002",
            viagensDisponiveis = listOf(
                Viagem("v1", "SpaceX", "Órbita Terrestre Baixa", "Uma visão panorâmica espetacular de cima da Terra a bordo da Crew Dragon.", "U$ 250.000", "3 Dias"),
                Viagem("v2", "SpaceX", "Estação Espacial Internacional (ISS)", "Viva como um astronauta real por uma semana inteira na ISS.", "U$ 20M", "10 Dias")
            )
        ),
        Empresa(
            id = "e2",
            nome = "Blue Origin",
            descricao = "Fundada por Jeff Bezos, a Blue Origin foca no desenvolvimento de turismo espacial suborbital seguro e sustentável com o New Shepard.",
            fundacao = "2000",
            viagensDisponiveis = listOf(
                Viagem("v3", "Blue Origin", "Linha de Kármán (Suborbital)", "Experimente a gravidade zero real e veja a curvatura do planeta no limite do espaço.", "U$ 150.000", "11 Minutos")
            )
        )
    )

    fun buscarEmpresaPorId(id: String): Empresa? {
        return listaDeEmpresas.find { it.id == id }
    }

    fun buscarViagemPorId(id: String): Viagem? {
        return listaDeEmpresas.flatMap { it.viagensDisponiveis }.find { it.id == id }
    }
}