import jakarta.persistence.*

@Entity
@Table(name = "Proveedor")
data class Proveedor(
    @Column(nullable = false)
    val nombre: String,

    @ManyToMany(mappedBy = "proveedores", cascade = [CascadeType.ALL])
    var institutos: MutableList<Instituto>? = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
