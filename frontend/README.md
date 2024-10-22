# Frontend - Gestión de Cursos Cesde

Este es el frontend de la aplicación de gestión de cursos y docentes para Cesde. La aplicación se conecta con una API REST implementada en Java (Spring Boot) y permite a los usuarios gestionar la información de los cursos y docentes.

## Funcionalidades

- Listar todos los cursos disponibles.
- Crear, editar y eliminar cursos.
- Validación de formularios al crear y editar cursos.
- Responsive design para adaptarse a diferentes dispositivos.
- Gestión de docentes.

## Requisitos

Para ejecutar este frontend, necesitarás un servidor web estático (puedes usar uno simple como **Live Server** en VSCode, **http-server**, o **Apache**).

También necesitarás tener el backend de la aplicación corriendo. Puedes encontrar la documentación para instalar y ejecutar el backend en el repositorio correspondiente.

## Instalación y ejecución

1. **Clona el repositorio**:

```bash
git clone https://github.com/tu-usuario/cesde-cursos-frontend.git
cd cesde-cursos-frontend
Ejecuta un servidor web para visualizar la aplicación (por ejemplo, usando http-server):
bash
Copiar código
npx http-server
Esto hará que la aplicación esté disponible en http://localhost:8080.

Conecta al backend:
El frontend está diseñado para funcionar con el backend en http://localhost:8080/api, si tu backend está corriendo en otra URL, puedes cambiarla en el archivo assets/scripts.js en la constante baseUrl.