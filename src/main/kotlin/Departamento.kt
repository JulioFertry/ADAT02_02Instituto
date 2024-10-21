import jakarta.persistence.*

@Entity
@Table(name = "Departamento")
data class Departamento(
    @Column(name = "Nombre", nullable = false, length = 50)
    val nombre: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_instituto")
    var instituto: Instituto?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
