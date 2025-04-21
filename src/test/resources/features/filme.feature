#language:pt

  @filme
  Funcionalidade: CRUD Filme

    Contexto:
      Dado que tenha realizado login com dados validos
      E que tenha um payload da API de Filme

    @cadastroFilme
    Cenario: Cadastro Filme
      Quando realizado uma requisicao do tipo POST de Filme
      Entao valido que recebo status 201 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
      E armazeno o id que recebo do response de Filme

    Cenario: Consulta Filme
      Quando realizado uma requisicao do tipo GET de Filme atraves do nome
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"

    Cenario: Alteracao Filme
      E altero o indice 1 da lista de categorias de filme com os valores
      | tipo | Terror |
      Quando realizado uma requisicao do tipo PUT de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

    Cenario: Consulta Filme apos alteracao
      Quando realizado uma requisicao do tipo GET de Filme atraves do nome
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

    Cenario: Exclusao Filme
      Quando realizado uma requisicao do tipo Delete de Filme
      Entao valido que recebo status 200 no response

    Cenario: Consulta Filme apos exclusao
      Quando realizado uma requisicao do tipo GET de Filme atraves do nome
      Entao valido que recebo status 200 no response
      E valido que recebo uma lista vazia o response