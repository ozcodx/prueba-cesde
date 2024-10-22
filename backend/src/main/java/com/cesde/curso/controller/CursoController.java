@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Curso curso = cursoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Curso not found for this id :: " + id));

        curso.setNombre(cursoDetails.getNombre());
        curso.setDescripcion(cursoDetails.getDescripcion());
        curso.setDuracion(cursoDetails.getDuracion());
        curso.setPrecio(cursoDetails.getPrecio());
        curso.setFechaInicio(cursoDetails.getFechaInicio());

        final Curso updatedCurso = cursoRepository.save(curso);
        return ResponseEntity.ok(updatedCurso);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Curso not found for this id :: " + id));

        cursoRepository.delete(curso);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}