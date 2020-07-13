#language: pt
Funcionalidade: Realizar testes na pagina Google
  Eu como operador devo ter acesso a pagina do Google e realizar pesquisas no site.

  @All
  Esquema do Cenario: Pesquisar por Santos no Google
    Dado a abertura do "<navegador>"
    Quando acesso a url: "<url>"
    E pesquiso por "Santos"
    Entao valido se a pesquisa foi realizada com a palavra: "Santos" com sucesso
    Exemplos:
      | navegador | url                       |
      |  chrome   | https://www.google.com.br  |