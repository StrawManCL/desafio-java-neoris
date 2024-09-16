# Desafío Técnico: Creación de Usuario
Desarrollo de una aplicación que permita la creación de usuarios.
## Objetivo
Crear una API RESTful utilizando Spring Boot 3.x que gestione la creación de usuarios, aplicando buenas prácticas y utilizando las tecnologías especificadas.
## Funcionalidad Principal
### Registro
El endpoint recibe un usuario con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:
```json
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```
## Requerimientos técnicos
- Se utiliza Java 21 para su ejecución.
- Se debe contar con Maven para su compilación.
- Se adjunta script de creación de tablas.
## Indicaciones de uso
Ejecutar en consola:
```shell
mvn clean spring-boot:run
```
En el navegador se puede utilizar la documentación de Swagger:
```
http://localhost:8080/swagger-ui.html
```
Si fuera necesario revisar la base de datos generada, se debe acceder a:
```
http://localhost:8080/h2
```

Para utilizar la API, se incluye la colección de Postman: Usuarios. Se debe importar también las variables de ambientes.
