# Aplicacion de administracion de partidos de futbol - UNAB

<p align="center">
  <img src="https://user-images.githubusercontent.com/78517969/142133621-0b331bae-3b32-403b-9f1e-d8a7c497ccbb.png" alt="DB_Model" />
</p>

Aplicacion que permite gestionar los partidos jugados por diferentes equipos

<p align="center">
  <img src="https://user-images.githubusercontent.com/78517969/143323094-161c4685-87bf-4cf0-84f6-829c6840487c.png" />
</p>

## 💻 Requisitos

* Java 17
* PostgreSQL
* Docker

## 🛠️ Guia de configuracion

El proyecto se encuentra corriendo bajo un host de docker, es posible utilizar el proyecto de manera local utilizando Java o utilizando docker


### Configuracion del archivo application.properties

Se debe crear un archivo llamado **application.properties** en la ruta /src/main/resources/ dentro de la carpeta resources, este archivo es el encargado de configurar la base de datos de la aplicación.

```
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:h2:mem:rides
spring.datasource.username=admin
spring.datasource.password=admin

spring.h2.console.enabled=true
spring.datasource.driverClassName=org.h2.Driver

# Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Configuración tradicional

La guia de configuracion esta creada bajo comandos de Windows. Todos los comandos se deben realizar en la raiz del proyecto (carpeta del proyecto) a la altura del archivo mvnw.

#### 1️⃣ Iniciar el servidor del proyecto
```console
./mvnw spring-boot:run
```

### Configuracion via Docker

La guia de configuracion esta creada bajo comandos de Windows. Todos los comandos se deben realizar en la raiz del proyecto (carpeta del proyecto) a la altura del archivo mvnw.

#### 1️⃣ Inicio del servidor Docker
```console
docker-compose up
```

Para cerrar el servidor una vez inicializado se debe usar el comando:

#### ⏹️ Cerrar servidor Docker
```console
docker-compose down
```


## 💾 Base de Datos
El proyecto esta configurado con una base de datos H2 para el ambiente de desarrollo, esta tiene disponible una interfaz grafica en donde se puede manipular y ver la información de la misma. Se puede acceder a esta mediante la ruta:

```
http://localhost:8080/h2-console
```

Con los siguientes datos:

<ul>
    <li>JDBC URL = jdbc:h2:mem:rides</li>
    <li>User Name: admin</li>
    <li>Password: admin</li>
</ul>

## ⚙️ API

La aplicacion esta formada por dos subsistemas, el subsistema de ciudades y el subsistemma de trayectos

#### 🟢 Login
Devuelve un token

```
http://localhost:8000/api/login
```

Ejemplo:

```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFsb3Blem1vIiwiZXhwIjoxNjYxOTQ0ODYxLCJpYXQiOjE2NjE5MDg4NjF9.PsahtUZ5Zhn_JdVlZj4GE9D_2rs9wDczfgvUOy1c-FI"
}
```

#### 🟢 Listar usuario por username
Devuelve una usuario que coincida con el username especificado

```
http://localhost:8000/api/user/<str:username>
```
```
http://localhost:8000/api/user/jualopezmo
```
Ejemplo:

```json
{
    "id": 1,
    "username": "jualopezmo",
    "password": "abcd1234",
    "first_name": "Juan",
    "last_name": "Motta",
    "email": "jualopezmo@example.com",
    "active": true,
    "enabled": true,
    "authorities": null,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "accountNonLocked": true
}
```

#### 🟢 Crear usuario
Crea un usuario con la informacion suministrada

```
http://localhost:8000/api/user
```

Ejemplo:
```
http://localhost:8000/api/user
```
```json
{
    "username": "jhon",
    "password": "abcd1234",
    "first_name": "Jhon",
    "last_name": "Doe",
    "email": "jhon@example.com"
}
```

#### 🟢 Crear equipo
Crea un equipo con la informacion suministrada

```
http://localhost:8000/api/team/
```
Ejemplo:
```
http://localhost:8000/api/team/
```

```json
{
    "id": 10,
    "abbreviation": "UNABa",
    "name": "Equipo UNABa"
}
```

#### 🟢 Crear partido
Crea un partido en base a la informacion suministrada

Ejemplo:
```
http://localhost:8000/api/match/
```

```json
{
    "user": {
        "id": 1
    },
    "local_team": {
        "id": 1
    },
    "away_team": {
        "id": 2
    },
    "date": "2019-11-11T21:21:21",
    "local_team_goals": 0,
    "away_team_goals": 0
}
```

#### 🟢 Editar partido
Edita los goles de un partido

```
http://localhost:8000/api/match/<int:id>
```

Ejemplo:
```
http://localhost:8000/api/match/1
```
```json
{
    "local_team_goals": 1,
    "away_team_goals": 2
}
```
