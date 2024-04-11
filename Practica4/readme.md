# PRÁCTICA No 4

#### Temas:
- Patrón DAO. JPA. Hibernate.

Cree un proyecto nuevo llamado Practica4. 

## Presupuestos online de fiestas de casamiento

1.- Realice un sitio que permita obtener presupuestos estimativos de fiestas de casamiento, completando un formulario de ítems a tener en cuenta. La información a manejar es la siguiente:

Cantidad de asistentes
- Salón
- Catering
- Barra libre
- Vino
- Champagne
- Torta
- Animación de la boda y DJ
- Ceremonia
    - (flores, decoración, sillas, mesa, alfombra)
- Invitaciones
- Alianzas
- Servicio de Video y Fotografía

Donde cada ítem tiene un precio asociado.

El sitio debe recuperar la información desde una BD utilizando el patrón DAO y JPA. 

El esquema del sitio es el siguiente:

<p align="center">
  <img src="/Practica4/assets/figura1.png" alt="Form de ejemplo" width="60%" height="60%">
</p>

El formulario debe mostrar los ítems a tener en cuenta para calcular el presupuesto y 2 campos más donde el _visitante_ ingresa su nombre y su email, los cuales deben ser registrados en la BD.
