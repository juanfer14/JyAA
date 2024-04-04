# Practica Nº 3

Temas
- Invocación de componentes web usando el método _forward()_ de RequestDispatcher
- Redireccionamiento de la respuesta al cliente usando el método _sendRedirect()_
- Servlet listeners de contexto
- Servlet Context

Cree un proyecto nuevo llamado **Practica3** y asígnele como nombre del contexto (root/context path): **pruebas**.

**Ejercicio 1)**

Escriba un servlet llamado **controla** en el paquete **misservlets**. La funcionalidad de este servlet es leer parámetros del requerimiento http y usarlos para determinar que recurso invocar.

En este ejercicio, debe escribir una página HTML llamada **inicio.html**, que contenga, un formulario con **3 radio_buttons** (Servlet Hola, Productos, Google), **un campo de texto** con la etiqueta **Ingrese su nombre** y un **botón** de tipo _submit_ para enviar los datos ingresados. Los datos del formulario se envían al servlet **controla** para su procesamiento.

El servlet **controla** redirecciona el requerimiento de acuerdo a la selección del usuario:

<p align="center">
  <img src="/Practica3/assets/figura1.png" alt="Form de ejemplo" width="50%" height="50%">
</p>
