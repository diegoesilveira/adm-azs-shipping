# Desafio AZShip

Este é um projeto para gerenciar fretes.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Docker
- PostgreSQL

## Instruções de Uso

Antes de executar o Docker Compose, é necessário construir o projeto e gerar o JAR executável. Siga as instruções abaixo:

1. Certifique-se de ter o Maven instalado na sua máquina.
2. Abra um terminal e navegue até o diretório raiz do projeto.
3. Execute o comando `mvn package` para construir o projeto e gerar o JAR.

Após executar o comando acima com sucesso, você pode prosseguir para executar o Docker Compose.

## Executando com Docker Compose

Para executar a aplicação usando Docker Compose, siga as etapas abaixo:

1. Certifique-se de ter o Docker e o Docker Compose instalados na sua máquina.
2. Abra um terminal e navegue até o diretório raiz do projeto.
3. Execute o comando `docker-compose up --build` para construir e iniciar os contêineres Docker.

Isso iniciará a aplicação e o banco de dados PostgreSQL em contêineres Docker.

## Exemplos de Uso

### Cadastro de Frete

Endpoint: POST 127.0.0.01:8080/v1/fretes

Payload:
```json
{
    "id": 1,
    "descricao": "Diego Evaldt",
    "dataCadastro": "2024-04-10T14:56:54.355182",
    "cliente": {
        "id": 1,
        "nome": "Nome do cliente",
        "email": "cliente@example.com",
        "telefone": "cliente@example.com",
        "enderecoDtoList": [
            {
                "id": 1,
                "rua": "Rua do cliente",
                "numero": 123,
                "complemento": "Complemento do endereco",
                "cep": "12345-678",
                "bairro": "Bairro do cliente",
                "uf": "UF",
                "cidade": "Cidade do cliente",
                "isAtivo": true
            }
        ]
    }
}

Busca de Fretes
Endpoint: GET /v1/fretes

Parâmetros:

termoBusca (opcional): Termo de busca para filtrar os fretes. O padrão é uma string vazia.
page (opcional): Número da página a ser retornada. O padrão é 0.
size (opcional): Tamanho da página. O padrão é 10.

Atualização de Frete
Endpoint: PUT 127.0.0.01:8080/v1/fretes/{id}

Payload:

{
    "id": 1,
    "descricao": "Nova descrição",
    "dataCadastro": "2024-04-10T14:56:54.355182",
    "cliente": {
        "id": 1,
        "nome": "Novo nome do cliente",
        "email": "novo_email@example.com",
        "telefone": "novo_telefone@example.com",
        "enderecoDtoList": [
            {
                "id": 1,
                "rua": "Nova rua do cliente",
                "numero": 123,
                "complemento": "Novo complemento do endereco",
                "cep": "54321-876",
                "bairro": "Novo bairro do cliente",
                "uf": "SP",
                "cidade": "Nova cidade do cliente",
                "isAtivo": true
            }
        ]
    }
}
Remoção de Frete
Endpoint: DELETE 127.0.0.01:8080/v1/fretes/{id}