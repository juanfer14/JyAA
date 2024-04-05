# Practica Nº 3

Temas
- Invocación de componentes web usando el método _forward()_ de RequestDispatcher
- Redireccionamiento de la respuesta al cliente usando el método _sendRedirect()_
- Servlet listeners de contexto
- Servlet Context

Cree un proyecto nuevo llamado **Practica3** y asígnele como nombre del contexto (root/context path): **pruebas**.

#### Ejercicio 1)

Escriba un servlet llamado **controla** en el paquete **misservlets**. La funcionalidad de este servlet es leer parámetros del requerimiento http y usarlos para determinar que recurso invocar.

En este ejercicio, debe escribir una página HTML llamada **inicio.html**, que contenga, un formulario con **3 radio_buttons** (Servlet Hola, Productos, Google), **un campo de texto** con la etiqueta **Ingrese su nombre** y un **botón** de tipo _submit_ para enviar los datos ingresados. Los datos del formulario se envían al servlet **controla** para su procesamiento.

<p align="center">
  <img src="/Practica3/assets/figura1.png" alt="Form de ejemplo" width="60%" height="60%">
</p>

El servlet **controla** redirecciona el requerimiento de acuerdo a la selección del usuario:

<p align="center">
  <img src="/Practica3/assets/figura2.png" alt="Form de ejemplo" width="50%" height="50%">
</p>

Si el radio seleccionado es “**Servlet Hola**”: se redirecciona a **holaservlet** (un servlet que se está ejecutando en el mismo contexto que el servlet **controla**). El servlet **/holaservlet** simplemente debe devolver una página HTML con el mensaje “Bienvenida”+nombre (tomado del parámetro del requerimiento). ¿Qué mecanismo utilizó? ¿Existe alguna otra manera de hacerlo?

* **El forward, a traves de un dispatcher.**

* **No, ya que es necesario que reciba los mismos parametros que recibio el servlet "controla"**

Si el radio seleccionado es “**Productos**”: se debe redireccionar al Servlet **/productos**, que está en el mismo servidor que el servlet **controla** pero en el contexto **compras** (proyecto **Practica2** creado en la práctica anterior). ¿Qué mecanismo utilizó? ¿Existe alguna otra manera de hacerlo? ¿Qué es el acceso CrossContext?

* **El forward, a traves de un dispatcher.**

* **Si, a traves de una redireccion con "sendRedirect()"**

* **CrossContext es el acceso desde el contexto de una aplicacion web, hacia otro, para poder obtener un determinado recurso.**

Si el radio seleccionado es “**Google**”: se debe redireccionar al sitio de Google (<http://www.google.com.ar>). Este sitio está en otro Servidor. ¿Qué mecanismo utilizó? ¿Existe alguna otra manera de hacerlo? 

* **El de redireccion, a traves de "sendRedirect()"**

* **No, ya que se le debe indicar al navegador que rediriga la pagina hacia "Google"**

Si el dato ingresado no es ninguno de los de arriba, se invoca nuevamente a **inicio.html**.

### Ejercicio 2)

Realice modificaciones al ejercicio de la práctica 2 de manera de cargar los datos de las golosinas desde un archivo de texto. Para ello realice lo siguiente:

- a) Cree un archivo de texto llamado **stock.txt** en la carpeta WEB-INF. Inicialícelo de la siguiente manera: en cada línea escriba el nombre de una golosina y su precio unitario separado por una coma (“,”). Cargue por lo menos 10 productos.<br>
##### Ejemplo

<p align="center">
  <img src="/Practica3/assets/figura3.png" alt="Archivo stock.txt con el nombre y precio de las golosinas" width="40%" height="40%">
</p>

- b) Agregue al archivo **web.xml** el siguiente parámetros de inicialización de la aplicación web (antes del primer tag \<servlet\>.. \</servlet\>:
```xml
<context-param>
<param-name>stock</param-name>
<param-value>/WEB-INF/recursos/stock.txt</param-value>
</context-param>
```

- c) Cree un _servlet listener_ llamado **InicializaStock**, cuya funcionalidad es inicializar los objetos necesarios para mantener en memoria las golosinas y precios del stock. Para crear el listener, seleccione la opción **New …** elija dentro de la categoría **Web Tier -> Servlet -> Servlet Listener**. Implemente únicamente la interface javax.servlet.ServletContextListener.<br>
En el método **contextInitialized(ServletContextEvent event)** se deben crear los objetos necesarios a partir de los datos leídos del archivo de texto **stock.txt**, cuya ubicación debe obtenerse del parámetro de contexto “stock” declarado en el archivo **web.xml**.<br>
Los objetos creados se deben ligar al contexto de la aplicación, invocando al método **_setAttribute(clave,Objeto)_** del objeto ServletContext. De esta forma, cada vez que desde un servlet de su aplicación, necesite usar el stock de golosinas, deberá invocar al método **_getAttribute()_** del ServletContext para obtener dicho objeto.<br><br>
**Ayuda**: Para leer del archivo de texto use el método **getResourseAsStream()** de ServletContext que devuelve un objeto InputStream. Luego cree un objeto BufferedReader a partir del objeto InputStream obtenido y así podrá leer de a líneas el archivo de texto.<br><br>
Observe el archivo **_web.xml_**, ¿qué modificación o nuevo tag encuentra, luego de haber agregado el servlet listener?<br>
  * **Se agrego el tag \<listener\> que contiene el tag \<listener-class\> indicando donde se encuentra ubicada la clase del listener.**


- d) Modifique el servlet **Productos**, eliminando el código del método init() y modificando el método doGet()/doPost() de manera de obtener la información para armar la página usando los objetos del contexto de la aplicación creados en el servlet listener.<br>
**Nota**: recuerde que el método **_getAttribute(clave)_** le permite recuperar del ServletContext el objeto ligado previamente con la **__clave_** pasada como parámetro. El objeto obtenido debe castearlo al tipo que corresponda.

- e) Modifique servlet **Facturar** para obtener los precios de las golosinas que el usuario compró, del objeto del contexto aplicación creado en el servlet listener.
