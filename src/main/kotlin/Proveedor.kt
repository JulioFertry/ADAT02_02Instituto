import jakarta.persistence.*

data class Proveedor(
    @Column(nullable = false)
    val nombre: String,

    @ManyToMany
    @JoinTable(
        name = "proveedor_instituto",
        joinColumns = [JoinColumn(name="id_proveedor")],
        inverseJoinColumns = [JoinColumn(name = "id_instituto")]
    )
    val instituto: MutableList<Instituto> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
