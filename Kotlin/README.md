# 🚀 T-Space — Turismo e Logística Orbital

> Protótipo funcional Android desenvolvido em Kotlin + Jetpack Compose  
> Global Solution 2026 — Tema: Indústria Espacial  

---

## 📱 Sobre o App

O **T-Space** é uma plataforma mobile de turismo e logística orbital que conecta usuários a empresas espaciais privadas e suas rotas disponíveis. A solução simula um marketplace de viagens espaciais, onde o usuário pode explorar empresas como **SpaceX**, **Blue Origin** e **Virgin Galactic**, visualizar destinos orbitais e suborbitais, e interagir com detalhes de cada missão.

O app se insere no contexto da **logística espacial e exploração comercial do espaço**, representando como a economia orbital está se tornando acessível ao público civil.

---

## 🎯 Objetivo

Demonstrar como uma aplicação Android pode servir como interface de acesso à indústria espacial emergente, apresentando dados de missões, empresas e rotas de forma organizada, interativa e visualmente coerente com o tema proposto.

---

## 🗂️ Estrutura do Projeto

```
t_space/
├── navigation/
│   ├── Routes.kt               # Enum com todas as rotas de navegação
│   └── AppNavigation.kt        # NavHost e configuração do grafo
├── model/
│   ├── Empresa.kt              # Data class da empresa espacial
│   ├── Viagem.kt               # Data class da viagem/missão
│   └── EmpresaViagemRepository.kt  # Dados mockados e funções de busca
├── screens/
│   ├── StartScreen.kt          # Tela inicial
│   ├── MenuScreen.kt           # Lista de viagens com filtro
│   ├── EmpresaScreen.kt        # Detalhes da empresa
│   ├── ViagemScreen.kt         # Detalhes da viagem/missão
│   └── MenuCardButton.kt       # Componente reutilizável de card
└── ui/theme/
    ├── Color.kt                # Paleta de cores (Terra Escura + Nascer do Sol)
    ├── Theme.kt                # TSpaceTheme com MaterialTheme
    └── Type.kt                 # Tipografia do app
```

---

## 📲 Fluxo de Telas


StartScreen - Tela inicial com identidade visual
<img width="1080" height="2400" alt="Print da Tela inicial" src="https://github.com/user-attachments/assets/0450ed09-43a5-458d-8b85-1b9bd1b375ef" />


MenuScreen - Lista todas as viagens disponíveis / Filtro por empresa via dropdown
<img width="1080" height="2400" alt="Print do Menu" src="https://github.com/user-attachments/assets/b998e324-68b2-4569-9198-b8d076db8ae4" />


EmpresaScreen - Detalhes da empresa espacial / Lista de rotas da empresa
<img width="1080" height="2400" alt="Print da tela da Empresa" src="https://github.com/user-attachments/assets/c06e8eb5-ddb4-469b-8de2-f0c0bfe8f2a5" />


ViagemScreen - Detalhes completos da missão com duração, preço, descrição / Botão "Reservar Assento"
<img width="1080" height="2400" alt="Print da tela de Viagem" src="https://github.com/user-attachments/assets/2dfc2f24-809b-47d5-bb06-b7c5cf10766e" />


---

## ✅ Requisitos Atendidos

### 1. Tela Inicial
- Nome da solução: **T-SPACE**
- Tagline: *"Sua porta de entrada para o turismo e logística orbital"*
- Identidade visual com paleta **Terra Escura** (tons de azul sombrio e branco neblina), imagem de fundo espacial e gradiente atmosférico

### 2. Navegação com Navigation Compose
- **4 telas** navegáveis: `Start → Menu → Empresa → Viagem`
- Navegação com argumentos dinâmicos (`empresaId`, `viagemId`)
- Rotas centralizadas no enum `Routes`
- Back stack gerenciado com `popBackStack()`

### 3. Componentes Compose e Organização Visual
- `Column`, `Row`, `Box` para estrutura de layout
- `verticalScroll` + `rememberScrollState` para listas longas
- `DropdownMenu` para filtro interativo
- `Card`-like com `MenuCardButton` reutilizável
- Componente `InfoEspecificacaoRow` para especificações de missão

### 4. Dados Relacionados ao Projeto
Dados mockados no `EmpresaViagemRepository` com **3 empresas** e **9 viagens**:

| Empresa | Viagens |
|---|---|
| SpaceX | Órbita Terrestre Baixa, ISS, Sobrevoo Lunar, Marte |
| Blue Origin | Linha de Kármán, Órbita Lunar |
| Virgin Galactic | VSS Unity, Pacote Delta, Aurora Boreal Espacial |

### 5. Interação com o Usuário
- **Filtro por empresa** via `DropdownMenu` no MenuScreen
- **Navegação por botões** em todos os cards (`Ver Viagem`, `Ver Empresa`)
- **Botão "Reservar Assento"** na tela de detalhes da viagem
- **Botões de voltar** em todas as telas secundárias

### 6. Organização e Boas Práticas
- Separação clara entre `model/`, `screens/`, `navigation/` e `ui/theme/`
- Repository pattern com `EmpresaViagemRepository`
- Enum `Routes` eliminando strings soltas na navegação
- Componentes reutilizáveis (`MenuCardButton`, `InfoEspecificacaoRow`)
- Cores centralizadas em `Color.kt`, tema próprio `TSpaceTheme`
- Nomes em português coerentes com o domínio do projeto

---

## 🛠️ Tecnologias Utilizadas

- **Kotlin**
- **Jetpack Compose** — UI declarativa
- **Navigation Compose** — navegação entre telas
- **Material 3** — componentes e theming
- **Android Studio** — ambiente de desenvolvimento

---

## 📦 Como Executar

1. Abrir o projeto no **Android Studio**
2. Aguardar sincronização do Gradle
3. Executar em emulador ou dispositivo físico com **Android 8.0+ (API 26)**
4. A tela inicial será exibida automaticamente

---

## 🌌 Contexto — Indústria Espacial

O T-Space representa a convergência entre tecnologia mobile e a nova economia espacial. Com empresas como SpaceX, Blue Origin e Virgin Galactic democratizando o acesso ao espaço, aplicações como esta simulam como seria a experiência do usuário num futuro próximo de turismo orbital acessível — conectando a logística espacial ao cotidiano das pessoas através de interfaces intuitivas e modernas.



