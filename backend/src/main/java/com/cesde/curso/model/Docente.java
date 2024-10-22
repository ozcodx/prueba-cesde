@Entity
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String documento;
    private String correo;

    @OneToMany(mappedBy = "docente")
    private List<Curso> cursos;

}