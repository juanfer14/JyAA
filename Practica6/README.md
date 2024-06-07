# PRÁCTICA Nº 6

**Temas**
- Principios REST
- JAX-RS

1. Diseñe un servicio REST para manejo de Usuarios. Se debe contemplar las operaciones de alta, baja, modificación y consulta (de un usuario en particular o varios). 

Para ello:

* a. Defina la URIs para identificar *un usuario particular*.<br>

1. **localhost/Practica6/usuarios/**: para retornar todos los usuarios**
2. **localhost/Practica6/usuarios/<id>**: para CRUD de un usuario en particular**

* b. ¿Para qué operaciones sobre Usuarios utilizaría cada uno de los siguientes métodos HTTP: _GET, POST, PUT y DELETE_?<br>

1. **GET**: para poder leer todos los usuarios o un usuario en particular.
2. **POST**: para poder insertar un nuevos usuario.
3. **PUT**: para actualizar un usuario.
4. **DELETE**: para eliminar un usuario.

* c. ¿Cómo es la petición HTTP para crear un nuevo **Usuario**? Defina el método HTTP, URI, cabecera y cuerpo de la petición.<br>

**La peticion para crear un nuevo usuario es GET**
> GET /Practica6/usuarios/<id> HTTP/1.1

* d. ¿Qué debería responder el servicio luego de crear el **Usuario**? ¿Para qué se utiliza _Location_ en la cabecera de la respuesta?<br>

**Deberia responder con el codigo de respuesta HTTP 201, indicando la creacion de un recurso.**

**_Location_ se utiliza para poder referenciar a la URI del recurso creado.**

* e. Repita los incisos c y d para las siguientes operaciones: Baja de un **Usuario**, Modificación de un **Usuario**, Consulta de un **Usuario** por id, y Listado de todos los **Usuarios**.<br>

2. Desarrolle los servicios REST de las operaciones descriptas en el punto anterior usando alguna de las implementaciones de JAX-RS.

3. Pruebe los servicios implementados en el ejercicio 2 utilizando una herramienta de testeo para generar los requerimientos. Podría usarse Postman (<https://www.postman.com/>).
