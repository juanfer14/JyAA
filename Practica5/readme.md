# PRÁCTICA Nº 5

#### Temas:
- Implementación de Servlets Filtros.
- Uso de JDBC para conexiones a bases de datos
- DataSource
- Patrón DAO

## 1. Filtro para detectar si un usuario entra a una aplicación sin autorización.

Implemente un servlet Filtro, llamado **FiltroControlaSesion**, el cual debe verificar si el requerimiento HTTP pertenece a una sesión. Si el requerimiento no pertenece a una sesión, debe redireccionar a la página **login.html**, en caso contrario se pasa el control al recurso destino de dicho requerimiento HTTP.<br>
Pruebe el filtro implementado, configurando para que el mismo intercepte los requerimientos HTTP para todos los recursos de la aplicación **compras** de la práctica 2, excepto para el servlet
**LoginUsr**.

## 2. Filtro para llevar estadísticas de acceso al sitio web

Implemente un servlet filtro llamado **FiltroLogDeAccesos** que registre en una base de datos MySQL mediante **JDBC**, todos los requerimientos procesados por el servidor. Son de interés los
siguientes datos:
- Fecha y hora
- Dirección IP del cliente
- Recurso solicitado
- Navegador utilizado

Utilice el patrón **DAO** y establezca la conexión usando Datasource.

## 3. Filtro para detectar el lenguaje utilizado por el cliente.
Realice un servlet llamado **LoginMultilenguaje** que genere una página con un formulario de logueo donde los textos sean obtenidos de un archivo de texto llamado por ejemplo **texto_es.properties**, **texto_en.properties**, etc. De esta manera es posible personalizar los
textos a mostrar eligiendo el archivo con el lenguaje apropiado. Los archivos de texto contendrán pares de valores del tipo clave=valor, por ejemplo

tit=Bienvenidos a Webmail de la Facultad de Informática<br>
usr=Usuario<br>
pwd=Contraseña<br>

Desarrolle un Filtro llamado **FiltroLenguajeDelCliente** que analice el encabezado HTTP de las peticiones y en base al lenguaje especificado por el navegador establezca como atributo del *request* el nombre del archivo utilizado para obtener los textos que mostrarán las páginas.
