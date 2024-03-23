# Continuación Practica 1

2. Escriba un *servlet* llamado __Bienvenida__ que tome el nombre del usuario del requerimiento http que recibe como parámetro y devuelve una página HTML que dice “Bienvenido ” + nombre (donde nombre es el dato recibe como entrada).\
La clase del *servlet* debe residir en el paquete __misservlets__. Sobreescriba solo el método __doGet()__.\
Debe escribir una página HTML llamada __saludo.html__, que contenga un formulario con un campo de entrada de texto, en donde el usuario escribirá su nombre y un botón de tipo *submit* para enviar los datos del formulario al *servlet* __Bienvenida__ para su procesamiento. 

	a) Ejecute el servlet y pruebe desde el navegador. 

	b) Modifique el archivo saludo.html y utilice el método “POST” para enviar los datos del formulario al *servlet* Bienvenida. ¿Necesita hacer algún cambio en el código del servlet?  
	
	__Se debe definir el metodo doPost() para poder responder el metodo “POST”__

	c) Analice nuevamente las carpetas WEB-INF\classes 

	__La carpeta “WEB-INF\classes\misservlets\” contiene el archivo “Bienvenida.class”__

	d) Pruebe acceder a su página saludo.html desde el navegador de su compañero. ¿Funciono? ¿Por qué?

	e) ¿Cuáles son las diferencias entre: la estructura del proyecto que está desarrollando con el IDE y la estructura de la aplicación Web que está ejecutándose en el servidor? Confeccione un diagrama jerárquico de cada una de las estructuras y muestre la relación de contenido que existe entre ellos. 
3. Escriba un *servlet* llamado __ContadorVisitas__ que mantiene actualizada la cantidad de requerimientos o visitas que recibe. Cada vez que recibe un requerimiento incrementa la cantidad y devuelve una página HTML que dice: “Este servlet lo visitaron: X usuario/s” (X es la cantidad de visitas). La clase del servlet debe residir en el paquete __misservlets__. No utilice variables de clase para mantener la cantidad de visitas.\
__Nota__: ejecute el *servlet* desde el navegador Web. Mantenga abiertas al menos tres instancias del navegador. Ejecute el *servlet* varias veces desde cada una de las ventanas. Ejecútelo desde el navegador de su compañero. 
Si no llega a obtener los resultados esperados, analice la configuración del navegador (uso de archivos temporales).

4. Escriba un *servlet* llamado __LoginUsr__ que tome del requerimiento http los datos de un usuario: identificación de usuario y contraseña y los valide. Si los datos son válidos devuelve como respuesta una página html de éxito en donde se informa que se trata de un usuario válido; en otro caso devuelve una página html de error en donde se informa que los datos ingresados no son válidos y un *link* a la página de __login.html__, para que el usuario vuelva a ingresar su login. La clase del *servlet* debe residir en el paquete __misservlets__.\
Para validar los datos defina e inicialice dos variables de instancia del servlet (de tipo Vector o arreglo de Strings) que contengan nombres de usuarios y sus respectivas contraseñas.\
En este ejercicio, debe escribir una página HTML llamada __login.html__, que contenga al menos: un título y un formulario con dos campos de texto con las etiquetas __Usuario__ y __Contraseña__ en donde el usuario ingresará su login y un __botón__ de tipo *submit* para enviar los datos ingresados. Los datos del formulario se envían al *servlet* __LoginUsr__ para su procesamiento. Ejecute el *servlet* desde el navegador. Abra más de un navegador. 

5. Escriba un *servlet* llamado __Encuesta__ que toma del requerimiento http datos acerca de los gustos de los usuarios por las mascotas, incrementa un total de acuerdo al tipo de mascota elegida y muestra una página de resultados de la encuesta. La clase del servlet debe residir en el paquete __misservlets__.\
En este ejercicio, debe escribir una página HTML llamada __mascotas.html__, que contenga al menos: un título y un formulario con al menos 6 objetos de tipo check-box cuya etiqueta tenga tipos de mascotas (perro, gato, hamster, tortuga, etc.) seleccionables y un __botón__ de tipo *submit* para enviar los datos ingresados. El nombre de los *check-boxes* debe ser el mismo (por ejemplo, mascotas). Los datos del formulario se envían al *servlet* __Encuesta__ para su procesamiento.\
La página que devuelve el servlet debe contener: 
* un título. 
* una tabla HTML con dos columnas (mascota, cantidad de votos) y tantas filas como tipos de animales. 
* un texto indicando el animal más votado y el porcentaje de votos sobre el total.
* un *link* a la página de __mascotas.html__. 

a) Ejecute el servlet desde el navegador. Abra más de un navegador.  Modifique la página __mascotas.html__ reemplazando los *check-boxes* por una lista de selección múltiple HTML con el mismo nombre que le asignó a los *check-boxes*. 

b) ¿Necesita modificar el código del servlet?
__Si es necesario modificar el código del servlet, ya que ahora debe obtener una lista de múltiples opciones. El método que permite obtener las opciones elegidas es “getParameterValues()”.__

