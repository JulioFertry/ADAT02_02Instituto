import jakarta.persistence.*

@Entity
@Table(name = "Instituto")
data class Instituto(
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_director")
    val director: Director,

    @ManyToOne
    @JoinColumn(name = "id_inspector")
    val inspector: Inspector?,

    @Column(name = "Proveedores")
    val proveedores: MutableList<Proveedor>? = mutableListOf(),

    @OneToMany(mappedBy = "dpto", cascade = [CascadeType.ALL])
    val departamentos: List<Departamento>? = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: Long?
)
