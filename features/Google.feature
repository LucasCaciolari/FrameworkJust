#language: pt
Funcionalidade: Realizar testes na pagina Google
  Eu como operador devo ter acesso a pagina do Google e realizar pesquisas no site.

  @All
  Esquema do Cenario: Pesquisar por times no Google
    Dado a abertura do "<navegador>"
    Quando acesso a url: "<url>"
    E pesquiso por "<time>"
    Entao valido se a pesquisa foi realizada com a palavra: "<time>" com sucesso
    Exemplos:
      | navegador | url                        | time         |
      |  chrome   | https://www.google.com.br  | santos       |
      |  chrome   | https://www.google.com.br  | corinthians  |
      |  chrome   | https://www.google.com.br  | são paulo    |