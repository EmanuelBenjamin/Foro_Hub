API Rest ForoHub

ForoHub es una API REST desarrollada con Spring Boot que simula un foro en línea, permitiendo a los usuarios crear, leer, actualizar y eliminar tópicos de discusión.

-Características

CRUD completo para tópicos
Autenticación y autorización con JWT
Base de datos relacional (MySQL)
Migraciones con Flyway
Validaciones de reglas de negocio

-Tecnologías utilizadas

Java 17+

Spring Boot 3+

Maven

MySQL 8+

Spring Security

JWT para autenticación

Flyway para migraciones de base de datos

-Configuración del proyecto

Clona el repositorio
Configura tu base de datos MySQL
Actualiza application.properties con tus credenciales de base de datos
Ejecuta las migraciones de Flyway
Compila y ejecuta el proyecto con Maven

- Endpoints principales

POST /topicos: Crear un nuevo tópico

GET /topicos: Listar todos los tópicos

GET /topicos/{id}: Obtener un tópico específico

PUT /topicos/{id}: Actualizar un tópico

DELETE /topicos/{id}: Eliminar un tópico

POST /login: Autenticar usuario y obtener token JWT

-Seguridad

El acceso a los endpoints está protegido mediante autenticación JWT. Asegúrate de incluir el token en el header de tus peticiones.

-Documentación

La API está documentada usando Swagger. Accede a la documentación en /swagger-ui.html después de iniciar la aplicación.

-Contribución

Las contribuciones son bienvenidas. 