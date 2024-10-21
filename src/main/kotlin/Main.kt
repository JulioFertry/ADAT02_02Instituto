import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence


fun main() {
    val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("unidadMySQL")
    val em: EntityManager = emf.createEntityManager()

    em.transaction.begin()

    val dir1 = Director("Juan", "Nieve", "66312899", null, null)
    val dir2 = Director("Shell", "Portal", "31003100", null, null)

    val inspec = Inspector("Pep", "Guardiola", "101001001", null, null)

    val prov1 = Proveedor("Boligrafos S.A.", null, null)
    val prov2 = Proveedor("Rollos de papel company", null, null)
    val provList = mutableListOf(prov1, prov2)

    val dpto1 = Departamento("Matematicas", null, null)
    val dpto2 = Departamento("Lengua", null, null)
    val dpto3 = Departamento("Ingles", null, null)
    val dpto4 = Departamento("Informatica", null, null)
    val dptoList = mutableListOf(dpto1, dpto2)
    val dptoList2 = mutableListOf(dpto3, dpto4)

    val inst1 = Instituto("Colegio medina sidonia", dir1, inspec, provList, dptoList, null)
    val inst2 = Instituto("Instituto la ola verde", dir2, inspec, provList, dptoList2, null)
    val instList = mutableListOf(inst1, inst2)

    dir1.instituto = inst1
    dir2.instituto = inst2

    inspec.institutos = instList

    prov1.institutos = instList
    prov2.institutos = instList

    dpto1.instituto = inst1
    dpto2.instituto = inst1
    dpto3.instituto = inst2
    dpto4.instituto = inst2

    em.persist(dir1)
    em.persist(dir2)
    em.persist(inspec)
    em.persist(prov1)
    em.persist(prov2)
    em.persist(dpto1)
    em.persist(dpto2)
    em.persist(dpto3)
    em.persist(dpto4)
    em.persist(inst1)
    em.persist(inst2)

    em.transaction.commit()

    em.close()
}