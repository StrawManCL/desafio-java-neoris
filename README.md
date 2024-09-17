# Desafío Técnico: Creación de Usuario
Desarrollo de una aplicación que permita la creación de usuarios.
## Objetivo
Crear una API RESTful utilizando Spring Boot 3.x que gestione la creación de usuarios, aplicando buenas prácticas y utilizando las tecnologías especificadas.
## Funcionalidad Principal
### Registro
El endpoint recibe un user con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:
```json
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```
## Requerimientos técnicos
- Se utiliza Java 21 para su ejecución.
- Se debe contar con Maven para su compilación.
- Se adjunta script de creación de tablas en src/main/resources/schema.sql
## Indicaciones de uso
Ejecutar en consola:
```shell
mvn clean spring-boot:run
```
En el navegador se puede utilizar la documentación de Swagger:
[localhost:8080/api/doc.html](http://localhost:8080/api/doc.html)

Si fuera necesario revisar la base de datos generada, se debe acceder a:
[localhost:8080/api/h2](http://localhost:8080/api/h2)

Para utilizar la API, se incluye la colección de Postman Usuarios (Usuarios.postman_collection.json).
Se debe importar también las variables de ambientes (DEV.postman_environment.json)
