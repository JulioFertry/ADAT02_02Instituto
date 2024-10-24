import jakarta.persistence.*

@Entity
@Table(name = "Inspector")
data class Inspector(
    @Column(name = "Nombre", nullable = false, length = 50)
    val nombre: String,

    @Column(name = "Apellido", nullable = true, length = 100)
    val apellido: String?,

    @Column(name = "DNI", nullable = false, length = 9, unique = true)
    val dni: String,

    @OneToMany(cascade = [CascadeType.ALL])
    var institutos: MutableList<Instituto>? = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
