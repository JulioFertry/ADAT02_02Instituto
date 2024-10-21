import jakarta.persistence.*

@Entity
@Table(name = "Departamento")
data class Departamento(
    @Column(nullable = false)
    val nombre: String,

    @ManyToOne
    @JoinColumn(name = "id_instituto")
    val instituto: Instituto,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
