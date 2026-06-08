package cesarb98.com.github.t_space.model

object EmpresaViagemRepository {

    val listaDeEmpresas = listOf(
        Empresa(
            id = "e1",
            nome = "SpaceX",
            descricao = "Fundada por Elon Musk, a SpaceX revolucionou a tecnologia aeroespacial com foguetes reutilizáveis, buscando tornar a vida multiplanetária.",
            fundacao = "2002",
            viagensDisponiveis = listOf(
                Viagem(
                    id = "v1",
                    destino = "Órbita Terrestre Baixa",
                    descricao = "Uma visão panorâmica espetacular de cima da Terra a bordo da Crew Dragon. Flutue em microgravidade e observe o nascer do sol a cada 90 minutos.",
                    preco = "U$ 250.000",
                    duracao = "3 Dias"
                ),
                Viagem(
                    id = "v2",
                    destino = "Estação Espacial Internacional (ISS)",
                    descricao = "Viva como um astronauta real por uma semana inteira na ISS. Participe de experimentos científicos e tenha uma vista privilegiada do planeta.",
                    preco = "U$ 20M",
                    duracao = "10 Dias"
                ),
                Viagem(
                    id = "v3",
                    destino = "Sobrevoo Lunar",
                    descricao = "A bordo da Starship, faça um sobrevoo histórico ao redor da Lua sem pousar. Veja a face oculta do satélite e a Terra surgindo no horizonte lunar.",
                    preco = "U$ 120M",
                    duracao = "6 Dias"
                ),
                Viagem(
                    id = "v4",
                    destino = "Marte — Missão Pioneira",
                    descricao = "Seja um dos primeiros humanos a pisar em Marte. A missão inclui treinamento de 6 meses, travessia interplanetária e exploração da superfície marciana.",
                    preco = "U$ 500M",
                    duracao = "2 Anos"
                )
            )
        ),
        Empresa(
            id = "e2",
            nome = "Blue Origin",
            descricao = "Fundada por Jeff Bezos, a Blue Origin foca no desenvolvimento de turismo espacial suborbital seguro e sustentável com o New Shepard.",
            fundacao = "2000",
            viagensDisponiveis = listOf(
                Viagem(
                    id = "v5",
                    destino = "Linha de Kármán (Suborbital)",
                    descricao = "Experimente a gravidade zero real e veja a curvatura do planeta no limite do espaço. Uma janela enorme garante a melhor vista já oferecida num voo espacial.",
                    preco = "U$ 150.000",
                    duracao = "11 Minutos"
                ),
                Viagem(
                    id = "v6",
                    destino = "Órbita Lunar — New Glenn",
                    descricao = "A bordo do New Glenn, entre em órbita ao redor da Lua por 48 horas. Fotografe crateras milenares e experimente o silêncio absoluto do espaço profundo.",
                    preco = "U$ 80M",
                    duracao = "5 Dias"
                )
            )
        ),
        Empresa(
            id = "e3",
            nome = "Virgin Galactic",
            descricao = "Fundada por Richard Branson, a Virgin Galactic é pioneira no turismo espacial com a espaçonave VSS Unity, oferecendo experiências suborbitais únicas com conforto e estilo.",
            fundacao = "2004",
            viagensDisponiveis = listOf(
                Viagem(
                    id = "v7",
                    destino = "Voo Suborbital VSS Unity",
                    descricao = "Decole a bordo da elegante VSS Unity, lançada de um avião-mãe a 15 km de altitude. Alcance o espaço em segundos, flutue por alguns minutos e retorne planando suavemente.",
                    preco = "U$ 450.000",
                    duracao = "90 Minutos"
                ),
                Viagem(
                    id = "v8",
                    destino = "Pacote Delta — 3 Voos Suborbitais",
                    descricao = "Para os entusiastas que desejam repetir a emoção, o Pacote Delta oferece três voos suborbitais ao longo de um ano, com treinamento dedicado e acesso ao clube exclusivo de astronautas Virgin.",
                    preco = "U$ 1.2M",
                    duracao = "3 x 90 Minutos"
                ),
                Viagem(
                    id = "v9",
                    destino = "Aurora Boreal Espacial",
                    descricao = "Um roteiro especial sobre os polos magnéticos da Terra. Observe auroras boreais de cima da atmosfera num espetáculo de luzes impossível de ver de qualquer outro lugar.",
                    preco = "U$ 600.000",
                    duracao = "2 Horas"
                )
            )
        )
    )

    fun buscarEmpresaPorId(id: String): Empresa? {
        return listaDeEmpresas.find { it.id == id }
    }

    fun buscarViagemPorId(id: String): Viagem? {
        return listaDeEmpresas.flatMap { it.viagensDisponiveis }.find { it.id == id }
    }

    fun buscarEmpresaPorViagemId(viagemId: String): Empresa? {
        return listaDeEmpresas.find { empresa ->
            empresa.viagensDisponiveis.any { it.id == viagemId }
        }
    }
}