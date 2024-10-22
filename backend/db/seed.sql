-- Insertar docentes de ejemplo
INSERT INTO docente (nombre, documento, correo) VALUES
('John Doe', '123456789', 'john.doe@example.com'),
('Jane Smith', '987654321', 'jane.smith@example.com'),
('Carlos Pérez', '456789123', 'carlos.perez@example.com');

-- Insertar cursos de ejemplo
INSERT INTO curso (nombre, descripcion, duracion, precio, fecha_inicio, docente_id) VALUES
('Curso de Programación Java', 'Aprende los fundamentos de la programación en Java', 12, 250.00, '2024-11-01 10:00:00', 1),
('Curso de Desarrollo Web', 'Aprende a crear aplicaciones web con HTML, CSS y JavaScript', 10, 180.50, '2024-12-05 09:00:00', 2),
('Curso de Inteligencia Artificial', 'Introducción al mundo de la IA y el aprendizaje automático', 16, 320.75, '2024-10-30 14:00:00', 3);