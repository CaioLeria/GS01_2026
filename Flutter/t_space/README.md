# T-Space



## ✨ Características Principais

- 🎬 **Animações Lottie** - Animações de alta qualidade e eficientes
- 🖼️ **Suporte SVG** - Gráficos vetoriais escaláveis
- 🖱️ **Entrada Flexível** - Suporte para touch, mouse e trackpad
- 🔄 **Sistema de Navegação** - Roteamento eficiente entre telas

## 🛠️ Tecnologias Utilizadas

- **Framework**: Flutter (^3.8.1)
- **Linguagem**: Dart
- **Design**: Material Design 3
- **Animações**: Lottie (^3.1.0)
- **Gráficos Vetoriais**: flutter_svg (^2.0.0)
- **Ícones**: Cupertino Icons (^1.0.8)

## 📂 Estrutura do Projeto

```
lib/
├── main.dart                 # Ponto de entrada da aplicação
├── config/
│   ├── app_navigation.dart   # Configuração de navegação
│   └── app_routes.dart       # Definição de rotas
├── ui/                       # Componentes de interface
├── model/                    # Modelos de dados
├── repository/               # Camada de dados
└── assets/
    ├── animations/           # Arquivos de animação Lottie
    ├── icons/                # Ícones vetoriais
    └── images/               # Imagens do projeto
```

## 🔄 Fluxo da Aplicação

    [Inicializar App] --> [Splash Screen] -->  B{Apresentação do projeto} --> C{Identificação} --> E[Home Screen]
    E --> F{tela da compania}
    E --> G{tela fa viagem} 

## 📐 Arquitetura

O projeto segue uma arquitetura em camadas:

```
┌─────────────────────────────────┐
│         UI Layer                │
│  (Widgets, Screens, Pages)      │
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│      Navigation Layer           │
│  (Routes, Navigation Logic)     │
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│       Models/State Layer        │
│  (Data Classes, State Mgmt)     │
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│    Repository Layer             │
│  (Data Fetching & Caching)      │
└─────────────────────────────────┘
```
## 📦 Dependências Principais

| Dependência | Versão | Propósito |
|------------|--------|----------|
| flutter_svg | ^2.0.0 | Renderização de gráficos SVG |
| lottie | ^3.1.0 | Animações Lottie |
| cupertino_icons | ^1.0.8 | Ícones iOS |
| flutter_lints | ^5.0.0 | Análise de código |


## 👥 Autores

Caio Leria, rm 557833 
Cesar Brasil, rm 556236
Bruno Itikawa, rm: 554924
