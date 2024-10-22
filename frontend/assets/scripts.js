const baseUrl = 'http://localhost:8080/api';  // Cambia según la URL de tu API

// Fetch cursos
async function fetchCourses() {
    const response = await fetch(`${baseUrl}/cursos`);
    const courses = await response.json();
    
    const courseList = document.getElementById('course-list');
    courseList.innerHTML = '';
    courses.forEach(course => {
        const div = document.createElement('div');
        div.innerHTML = `
            <h2>${course.nombre}</h2>
            <p>${course.descripcion}</p>
            <p>Duración: ${course.duracion} semanas</p>
            <p>Precio: $${course.precio}</p>
            <button onclick="editCourse(${course.id})">Editar</button>
            <button onclick="deleteCourse(${course.id})">Eliminar</button>
        `;
        courseList.appendChild(div);
    });
}

// Cargar docentes en el formulario
async function loadDocentes() {
    const response = await fetch(`${baseUrl}/docentes`);
    const docentes = await response.json();
    
    const docenteSelect = document.getElementById('docente');
    docentes.forEach(docente => {
        const option = document.createElement('option');
        option.value = docente.id;
        option.textContent = docente.nombre;
        docenteSelect.appendChild(option);
    });
}

// Guardar o editar curso
async function submitCourse(event) {
    event.preventDefault();
    
    const form = event.target;
    const formData = new FormData(form);
    const curso = Object.fromEntries(formData.entries());

    const response = await fetch(`${baseUrl}/cursos`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(curso)
    });

    if (response.ok) {
        alert('Curso guardado exitosamente');
        window.location.href = 'index.html';
    } else {
        alert('Error al guardar el curso');
    }
}

// Eliminar curso
async function deleteCourse(courseId) {
    const confirmDelete = confirm('¿Estás seguro de eliminar este curso?');
    if (confirmDelete) {
        const response = await fetch(`${baseUrl}/cursos/${courseId}`, { method: 'DELETE' });
        if (response.ok) {
            fetchCourses();
        } else {
            alert('Error al eliminar el curso');
        }
    }
}