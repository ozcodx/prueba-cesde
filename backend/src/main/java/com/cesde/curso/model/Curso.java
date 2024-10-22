@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String descripcion;
    private int duracion;
    private BigDecimal precio;
    private LocalDateTime fechaInicio;
    
    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;

}