# Teste para Backend

### Requistos para executar

* Maven instalado
* Mysql ou MariaDB
* Aplicativo para testar Requisições API (Postman, Insomnia, etc...)
* Executar o Script tabelas.sql no Banco de Dados
* Configurar o arquivo de propriedades com as credencias do banco de dados localizado no diretório: "src/main/resources/application.properties"

Depois de baixar o repositório e configurar execute o comando no terminal: 
```
mvn spring-boot:run
```
o projeto irá compilar e rodar na porta 8080.

ou em Docker
```
mvn package
```
para criar o arquivo .jar

```
docker build -t backend .
docker run -dp 8080:8080 backend
```

a documentação das APIs se encontra no arquivo: documentacaoApi.yaml que pode ser aberto através do site do Swagger: https://editor.swagger.io/ .

<br>

### Tempo de desenvolvimento do projeto:

- Criação do projeto, parametrização, Banco de dados, configuração da IDE (Intellij) e desenvolvimento do código: 50 minutos;
- Criar documentação Swagger + README.md : 1h e 30 minutos.
