# API Rest de consulta de cidades do Brasil do zero até a produção

Neste projeto foi desenvolvido uma API Rest de consulta de cidades do Brasil com dados comparativos. 
Iremos navegar pelas boas práticas de Java e do Spring, foi usado o popular o bando de dados Postgres e foi criado um serviço para o cálculo de distância entre cidades.

Este projeto foi desenvolvido durante o Bootcamp everis Quality Assurance Beginner. Digital Innovation One.

## Requisitos

- Linux
- Git
- Java 8
- Docker
- Comunidade IntelliJ
- Heroku CLI
- Travis CLI

## Base de dados

### Postgres

- [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```
docker run --name cities-db -d -p 5432: 5432 -e POSTGRES_USER = postgres_user_city -e POSTGRES_PASSWORD = super_password -e POSTGRES_DB = cidades postgres
```

- [Distância Postgres da Terra](https://www.postgresql.org/docs/current/earthdistance.html)
- [earthdistance - 1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
- [OPERADOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
- [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
- [tipo de dados geométrico](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Acesso

```
docker exec -it cities-db / bin / bash

psql -U postgres_user_city cities
```

### Distância da Terra de Consulta

Apontar

```
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cubo

```
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## Spring Boot

- https://start.spring.io/

- Java 8
- Projeto Gradle
- Jarra
- Spring Web
- Spring Data JPA
- Driver PostgreSQL

### Spring Data

- [métodos jpa.query](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Propriedades

- [propriedades do aplicativo apêndice](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
- [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Tipos

- [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
- [Tipo de usuário](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

## Heroku

- [DevCenter](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku)

```
heroku criar dio-cities-api --addons = heroku-postgresql
```

## Qualidade do Código

### PMD

- https://pmd.github.io/pmd-6.8.0/index.html

### Checkstyle

- https://checkstyle.org/
- https://checkstyle.org/google_style.html
- http://google.github.io/styleguide/javaguide.html

```
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
```

## Teste de banco de dados InMemory

- http://www.h2database.com/html/features.html

## Migrações

- https://flywaydb.org/

## CI

### Travis

- https://github.com/travis-ci/travis.rb#readme
- https://docs.travis-ci.com/user/tutorial/

#### extra

- https://docs.travis-ci.com/user/conditional-builds-stages-jobs/
- https://docs.travis-ci.com/user/deployment-v2/conditional
- [Implantação Heroku](https://docs.travis-ci.com/user/deployment/heroku/)