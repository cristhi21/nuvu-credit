# Prueba Backend
***

### Información general
***
El nombre del proyecto es Nuvu-credit, son un conjunto de APIRest pensadas en el manejo básico de la información 
de personas con sus tarjetas de crédito.


### Tecnologías
***
* Tech: Open JDK 11.0.9.1
* Framework: Spring Boot 2.4.5
* Dependency Manager: Gradle
* IDE: IntelliJ


### Uso
***
1. Descargar proyecto y ejecutarlo
2. se debe ingresar al siguiente endPoint: [Authenticate](http://localhost:8070/nuvu-credit/api/authenticate)
3. Ingresar las siguientes credenciales en el cuerpo de la petición:

```
{
    "username": "foo",
    "password": "foo"
}
```
   
4. Ingresar a la documentación: [Ver Documentacion de la API](http://localhost:8070/nuvu-credit/api/swagger-ui.html)
5. verificar los endpoint e ingresar el Header, 

| Clave         |Valor         |
|---------------|--------------|
| Authorization | Bearer (jwt) |

Server
```sh
localhost:8070/nuvu-credit/api
```


### Autor

    Cristhian Andres Vargas Cuero