# FAMETRO - Pós-Graduação em Engenharia de Software - Projeto SPA em React

## Visão Geral do Projeto

Este repositório contém um projeto de Aplicação de Página Única (SPA) em React chamado `xpto-page.html`. Ele serve como uma interface de manutenção para o gerenciamento de "xptos". Além disso, você encontrará outros arquivos de exemplo React na pasta `exemplos`, com o objetivo de proporcionar uma experiência de aprendizagem sobre as estruturas básicas do React.

O projeto destaca como o React pode ser usado como uma biblioteca sem dependência de gerenciadores de pacotes como o NPM, simplificando assim a compreensão dos fundamentos do React.

## Demonstração do Projeto

Veja abaixo um GIF demonstrando como abrir e executar o projeto `xpto-page.html` tanto em um navegador web quanto no Visual Studio Code.

![Demonstração do Projeto](animacao.gif)


## Conteúdo

- `xpto-page.html`: Arquivo principal do projeto para a manutenção de xptos.
- `exemplos/`: Pasta contendo exemplos básicos de código React para fins educacionais.

## Executando o Projeto

Para executar o arquivo `xpto-page.html`:

1. Clone ou baixe o repositório para sua máquina local.
2. Abra o arquivo `xpto-page.html` em um navegador da web para ver a aplicação em ação.
3. Alternativamente, para editar e inspecionar o código, abra o arquivo em um editor de código como o Visual Studio Code (VS Code).

### Abrindo o Arquivo do Projeto em um Navegador

1. Navegue até o diretório que contém `xpto-page.html`.
2. Dê um duplo clique no arquivo ou clique com o botão direito e selecione "Abrir com" seguido pelo seu navegador da web preferido.

### Abrindo o Projeto no VS Code

1. Clique com o botão direito no arquivo `xpto-page.html`.
2. Selecione "Abrir com o Code" para começar a editar no Visual Studio Code.

## Entendendo o Código

### `xpto-page.html`

Este arquivo define um componente React `XptoPageComponent` que gerencia uma lista de xptos. O componente lida com operações como buscar, adicionar, editar e remover xptos. Ele utiliza funções assíncronas para fazer requisições a um serviço de backend que, presumivelmente, está sendo executado em `localhost:8080`.

- **Busca de Dados**: Utiliza o método de ciclo de vida `componentDidMount` para buscar xptos existentes quando o componente é renderizado.
- **Gerenciamento de Estado**: O estado contém a lista de xptos, um novo objeto xpto para adicionar novas entradas e um estado de edição para modificações no local.
- **Manipuladores de Eventos**: Funções como `cadastrarXpto`, `removerXpto` e `editarXpto` são definidas para lidar com as respectivas operações CRUD.

### `helloword-page.html`

Este arquivo é um exemplo básico que ilustra como criar um componente React simples e renderizá-lo no DOM sem etapas complexas de build.

## Suporte

Para quaisquer dúvidas ou suporte relacionado a este projeto, por favor, entre em contato com o instrutor do curso ou assistentes de ensino.

