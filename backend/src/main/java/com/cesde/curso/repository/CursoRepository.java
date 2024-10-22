@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNombreContaining(String nombre);
    List<Curso> findByDocenteNombre(String docenteNombre);
    List<Curso> findByPrecioBetween(BigDecimal min, BigDecimal max);
}