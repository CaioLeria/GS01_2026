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

    <img width="1914" height="941" alt="image" src="https://github.com/user-attachments/assets/3b719ff0-4603-473d-b4bf-e398b99ca405" />
    <img width="1915" height="946" alt="image" src="https://github.com/user-attachments/assets/1780490e-1121-44ee-b5d0-46a1fb84ec7c" />
    <img width="1908" height="946" alt="image" src="https://github.com/user-attachments/assets/59ca84e4-f971-4a25-a5c8-f0d99fc7bc9c" />
    <img width="1892" height="943" alt="image" src="https://github.com/user-attachments/assets/491bad9c-9d4b-4683-8d82-6492b5a69f60" />
    <img width="1913" height="947" alt="image" src="https://github.com/user-attachments/assets/87e6a62b-de93-4923-8e93-b61ebbf7abc0" />
    <img width="1912" height="943" alt="image" src="https://github.com/user-attachments/assets/f7b8e853-c15d-43c6-91c8-440ccfd253e0" />







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
