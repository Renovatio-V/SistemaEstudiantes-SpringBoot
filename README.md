# Aplicación de Sistema de Estudiantes con Spring Boot y MySQL

## Descripción
Esta aplicación es un sistema de gestión de estudiantes desarrollado con Spring Boot y MySQL. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos de estudiantes. 

## Características
- **Listar Estudiantes**: Muestra una lista de todos los estudiantes registrados.
- **Buscar Estudiante**: Permite buscar un estudiante por su ID.
- **Agregar Estudiante**: Permite añadir un nuevo estudiante a la base de datos.
- **Modificar Estudiante**: Permite actualizar la información de un estudiante existente.
- **Eliminar Estudiante**: Permite eliminar un estudiante de la base de datos.

## Requisitos
- Java 11 o superior
- Maven
- MySQL

## Instalación
1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git

## Mas Detalles 
Configura la base de datos MySQL. Crea una base de datos llamada estudiantes_db y actualiza el archivo application.properties con tus credenciales de MySQL:
  ```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/estudiantes_db
  spring.datasource.username=tu_usuario
  spring.datasource.password=tu_contraseña
  spring.jpa.hibernate.ddl-auto=update
  ```
Compila y ejecuta la aplicación usando Maven:
  ```bash
  mvn spring-boot:run


