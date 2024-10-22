-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS cesde_db;
USE cesde_db;

-- Crear la tabla 'docente'
CREATE TABLE docente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    UNIQUE (documento),
    UNIQUE (correo)
);

-- Crear la tabla 'curso'
CREATE TABLE curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    duracion INT NOT NULL, -- duración en semanas
    precio DECIMAL(10, 2) NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    docente_id INT,
    FOREIGN KEY (docente_id) REFERENCES docente(id) ON DELETE SET NULL
);