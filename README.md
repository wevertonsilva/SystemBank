# SystemBank

Banco de dados utilizado: MySQL

Arquivo de configuração Spring (application.properties) recomendado:

spring.datasource.url=jdbc:mysql://localhost:3306/systembank?useTimeZone=true

spring.datasource.username=root

spring.datasource.password=

spring.jpa.show-sql=true

spring.jpa.hibernate.ddl-auto=create

spring.main.allow-bean-definition-overriding=true

server.port=8080

Rotas:

GET - http://localhost:8080/pessoa (retorna pessoas com suas respectivas contas, limite de cheque especial e cartão de credito) 

GET - http://localhost:8080/contas (retorna contas com seus respectivos limite de cheque especial e cartão de credito)

POST - http://localhost:8080/pessoa (cadastra uma nova pessoa, cria conta, verifica o limite de cheque especial e cria cartão de credito)

Body recomendado para POST:

{
    "nome": "Armando",
    "tipoPessoa":  "PJ", ("PJ" ou "PF")
    "numeroDocumento": 14150345589123, (11 digitos para PF e 14 digitos para PJ)
    "score": 1 (numeros entre 0 e 9 (inclusos))
}
