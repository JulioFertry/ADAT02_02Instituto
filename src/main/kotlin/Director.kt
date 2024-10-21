import jakarta.persistence.*

@Entity
@Table(name = "Director")
data class Director(
    @Column(name = "Nombre",  nullable = false, length = 50)
    val nombre: String,

    @Column(name = "Apellido", nullable = true, length = 100)
    val apellido: String?,

    @Column(name = "Telefono", nullable = true)
    val telefono: String?,

    @OneToOne(mappedBy = "director")
    val instituto: Instituto,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
