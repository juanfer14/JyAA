# PRÁCTICA N° 2

###### Temas
- Implementación de Servlets usando sesiones.
- Recolección de información (inputs) a través de páginas HTML para la implementación de un changuito de compras simple usando Servlets.

En esta práctica se desarrollará un pequeño sistema Web para realizar compras de golosinas que requiere de una autenticación para ingresar al mismo.
Cree un proyecto Web dinámico de nombre **Practica2**. Asigne como nombre de la aplicación Web: **compras**.

1. La aplicación Web compras debe permitir elegir golosinas desde una lista y comprarlas. La aplicación requiere autenticación. El diagrama de navegación de la aplicación es el siguiente:

![Flujo de los servlets](/Practica2/assets/figura1.png)

Descripción de cada componente:
------------------------------

(Ubique las clases de los servlets en el paquete misservlets.practica2)
- **login.html**: es un formulario HTML con cuatro campos de texto: nombre de usuario, contraseña, apellido y nombres y dirección postal y, un botón submit que permite enviar los datos del formulario al servlet **LoginUsr**. La página debe contener un título. **Recuerde que
este es el punto de entrada para ejecutar la aplicación**.

- **LoginUsr**: es un servlet que autentica al usuario en la aplicación, tiene la misma funcionalidad que el servlet **LoginUsr** del **ejercicio 4 de la práctica 1**: el método init() debe inicializar una variable de instancia del servlet, de tipo Hashtable llamada **logins**, con los parámetros de inicialización del **web.xml**. La tabla **logins** mantendrá como clave el nombre del usuario y como valor la contraseña.
Además de la funcionalidad anterior, este servlet debe:

+ Si el usuario ingresado es **válido** -> se recupera la sesión del usuario, se almacenan todos sus datos y luego se redirecciona el requerimiento http al servlet **Productos**.
+ Si el usuario ingresado es **inválido** -> el requerimiento http se redirecciona nuevamente a **login.html** para permitirle al usuario corregir los datos ingresados.

Ayuda: tenga en cuenta que el método _sendRedirect(URL)_ de la interface _HttpServletResponse_ redirecciona la respuesta a la URL pasada como parámetro. Por ejemplo: **response.sendRedirect(“/compras/productos”);**

2. 
