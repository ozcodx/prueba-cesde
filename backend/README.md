## Cesde Cursos - Gestión de Cursos y Docentes

### Descripción
Esta aplicación web permite a los administradores gestionar los cursos y docentes ofrecidos por Cesde. Las principales funcionalidades incluyen agregar, editar y eliminar cursos, así como administrar los docentes que los dictarán. También se puede buscar cursos usando filtros personalizados.

### Requisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- **Java 17+**: [Descargar Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Gradle**: [Instalar Gradle](https://gradle.org/install/)
- **MySQL**: [Instalar MySQL](https://dev.mysql.com/downloads/installer/)

### Configuración de la base de datos

1. **Crear la base de datos en MySQL**:
   - Abre tu consola de MySQL o un cliente como MySQL Workbench.
   - Ejecuta el script `cesde_db.sql` para crear la base de datos y las tablas necesarias. El archivo se encuentra en la carpeta `db`.

```bash
mysql -u root -p < db/cesde_db.sql
```

2. **Poblar la base de datos con datos de ejemplo**:
   - Ejecuta el script `seed.sql` para insertar datos iniciales (docentes y cursos de ejemplo).

```bash
mysql -u root -p < db/seed.sql
```

### Configuración de la aplicación

1. **Clonar el repositorio**:
   Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tu-usuario/cesde-cursos.git
cd cesde-cursos
```

2. **Configuración de la base de datos en la aplicación**:
   Modifica el archivo `src/main/resources/application.properties` para incluir la configuración de la base de datos MySQL:

```properties
# Configuración de MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/cesde_db
spring.datasource.username=root
spring.datasource.password=yourpassword

# Mostrar las consultas SQL en la consola
spring.jpa.show-sql=true

# Sincronización de los cambios de la entidad con la base de datos
spring.jpa.hibernate.ddl-auto=update
```

Reemplaza `yourpassword` con la contraseña de la base de datos MySQL.

### Compilación y ejecución de la aplicación

1. **Instalar dependencias**:
   Si es la primera vez que ejecutas el proyecto, instala las dependencias de Gradle ejecutando:

```bash
./gradlew build
```

2. **Ejecutar la aplicación**:
   Ejecuta la aplicación con el siguiente comando:

```bash
./gradlew bootRun
```

3. **Acceso a la aplicación**:
   La aplicación estará disponible en `http://localhost:8080`.

### Pruebas de la API

Para probar la API, puedes usar herramientas como **Postman** o **cURL**. Aquí hay algunos ejemplos usando `cURL`:

- **Listar todos los cursos**:
```bash
curl -X GET http://localhost:8080/api/cursos
```

- **Crear un nuevo curso**:
```bash
curl -X POST http://localhost:8080/api/cursos \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Nuevo Curso",
  "descripcion": "Descripción del curso",
  "duracion": 8,
  "precio": 150.00,
  "fechaInicio": "2024-11-10T10:00:00",
  "docente": { "id": 1 }
}'
```

- **Actualizar un curso**:
```bash
curl -X PUT http://localhost:8080/api/cursos/1 \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Curso Actualizado",
  "descripcion": "Nueva descripción",
  "duracion": 10,
  "precio": 200.00,
  "fechaInicio": "2024-11-15T12:00:00",
  "docente": { "id": 2 }
}'
```

- **Eliminar un curso**:
```bash
curl -X DELETE http://localhost:8080/api/cursos/1
```

### Filtros de búsqueda

Se implementaron tres filtros de búsqueda para los cursos:

- **Buscar por nombre de curso**: `/api/cursos/search?nombre=Java`
- **Buscar por nombre de docente**: `/api/cursos/search?docenteNombre=John Doe`
- **Buscar por rango de precios**: `/api/cursos/search?min=100&max=300`