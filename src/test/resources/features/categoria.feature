#language:pt

  @categoria
  Funcionalidade: Consulta Categoria

    Cenario: Realizar Consulta Categoria com Sucesso
      Dado que tenha realizado login com dados validos
      E que tenha um payload da API de Categoria
      Quando realizado uma requisicao do tipo GET de Categoria
      Entao valido que recebo status 200 no response
      E valido que no campo "tipo[2]" possui o valor "Terror"

    Cenario: Realizar Consulta Categoria sem o token
      Quando realizado uma requisicao do tipo GET de Categoria
      Entao valido que recebo status 403 no response
      E valido que no campo "message" possui o valor "Access Denied"

    Cenario: Realizar Consulta Categoria com token invalido
      Dado que altere o campo "Authorization" para "invalido" do header de Categoria
      Quando realizado uma requisicao do tipo GET de Categoria
      Entao valido que recebo status 403 no response
      E valido que no campo "message" possui o valor "Access Denied"