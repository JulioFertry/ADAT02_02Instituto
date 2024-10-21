import jakarta.persistence.*

@Entity
@Table(name = "Instituto")
data class Instituto(
    @Column(name = "Nombre", nullable = false, length = 50)
    val nombre: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_director")
    val director: Director,

    @ManyToOne
    @JoinColumn(name = "id_inspector")
    val inspector: Inspector?,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "instituto_proveedor",
        joinColumns = [JoinColumn(name = "id_instituto")],
        inverseJoinColumns = [JoinColumn(name = "id_proveedor")]
    )
    val proveedores: MutableList<Proveedor>? = mutableListOf(),

    @OneToMany(mappedBy = "instituto", cascade = [CascadeType.ALL])
    val departamentos: List<Departamento>? = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)
