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

**La peticion para crear un nuevo usuario es POST**
> POST /Practica6/usuarios/ HTTP/1.1<br>
> Content-type: application/json<br>
> {<br>
>   "nombre": "juan"<br>
>   "apellido": "campodonico"<br>
>   "email": "juan@gmail.com"<br>
> }<br>

* d. ¿Qué debería responder el servicio luego de crear el **Usuario**? ¿Para qué se utiliza _Location_ en la cabecera de la respuesta?<br>

**Deberia responder con el codigo de respuesta HTTP 201, indicando la creacion de un recurso y el JSON del usuario que se creo**
> HTTP/1.1 201 Created<br>
> Content-Type: application/json<br>
> Location: http://localhost/Practica6/usuarios/1<br>
>
> {<br>
>   "id": "1",<br>
>   "url": "http://localhost/Practica6/usuarios/1",<br>
>   "nombre": "juan"<br>
>   "apellido": "campodonico"<br>
>   "email": "juan@gmail.com"<br>
> }


**_Location_ se utiliza para poder referenciar a la URI del recurso creado.**

* e. Repita los incisos c y d para las siguientes operaciones: Baja de un **Usuario**, Modificación de un **Usuario**, Consulta de un **Usuario** por id, y Listado de todos los **Usuarios**.<br>

<ins>Baja de un usuario</ins>

**La operacion para dar de baja un usuario es DELETE**
> DELETE /Practica6/usuarios/1 HTTP/1.1<br>

**Luego de la operacion, deberia responder con el codigo de respuesta 204, si no encontro el usuario o 200, para indicar que se borro el usuario.**

> HTTP/1.1 204 No Content

> HTTP/1.1 200 OK<br>
> Content-Type: application/json<br>
>
> {<br>
>   "id": "1"<br>
>   "url": "http://localhost/Practica6/usuarios/1"<br>
>   "nombre": "juan"<br>
>   "apellido": "campodonico"<br>
>   "email": "juan@gmail.com"<br>
> }

<ins>Modificacion de un usuario</ins>

**La operacion para modificar un usuario es PUT**
> PUT /Practica6/usuarios/1 HTTP/1.1<br>
> Content-Type: application/json<br>
>
> {<br>
>   "id": "1"<br>
>   "url": "http://localhost/Practica6/usuarios/1"<br>
>   "nombre": "tom"<br>
>   "apellido": "campodonico"<br>
>   "email": "tom@gmail.com"<br>
> }

**Luego de la operacion, la respuesta debe ser un 204 o un 200, para indicar que se modifico el usuario.**

>HTTP/1.1 204 No Content

>HTTP/1.1 200 OK
>Content-Type: application/json
>
> {<br>
>   "id": "1"<br>
>   "url": "http://localhost/Practica6/usuarios/1"<br>
>   "nombre": "tom"<br>
>   "apellido": "campodonico"<br>
>   "email": "tom@gmail.com"<br>
> }

<ins>Consulta de un usuario</ins>

**La operacion para consultar un usuario particular es GET**

> GET /Practica6/usuarios/1 HTTP/1.1

**La respuesta a esta operacion, puede ser un 204 o un 200, para indicar que se encontro al usuario.**

> HTTP/1.1 200 OK
> Content-Type: application/json
>
> {<br>
>   "id": "1"<br>
>   "url": "http://localhost/Practica6/usuarios/1"<br>
>   "nombre": "juan"<br>
>   "apellido": "campodonico"<br>
>   "email": "juan@gmail.com"<br>
> }

<ins>Listado de todos los usuarios</ins>

**La operacion apra consultar a todos los usuarios es GET**

> GET /Practica6/usuarios/ HTTP/1.1

**La respuesta a esta operacion es un 200, indicando que se encontraron todos los usuarios o 204 si no hay ninguno.**

> HTTP/1.1 200 OK
> Content-Type: application/json
>
> [
>   {<br>
>     "id": "1"<br>
>     "url": "http://localhost/Practica6/usuarios/1"<br>
>     "nombre": "juan"<br>
>     "apellido": "campodonico"<br>
>     "email": "juan@gmail.com"<br>
>   },<br>
>   {<br>
>     "id": "2"<br>
>     "url": "http://localhost/Practica6/usuarios/2"<br>
>     "nombre": "lio"<br>
>     "apellido": "campodonico"<br>
>     "email": "lion@gmail.com"<br>
>   },<br>
>   ...
> ]

2. Desarrolle los servicios REST de las operaciones descriptas en el punto anterior usando alguna de las implementaciones de JAX-RS.

3. Pruebe los servicios implementados en el ejercicio 2 utilizando una herramienta de testeo para generar los requerimientos. Podría usarse Postman (<https://www.postman.com/>).
