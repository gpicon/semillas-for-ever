package ar.edu.unahur.obj2.semillas

abstract class Parcela(val ancho : Int, val largo : Int, val hsDeSol : Int, var plantas : MutableList<Planta>) {

    fun superficie() = ancho * largo

    fun cantidadMaximaDePlantas() : Int {
        var cantidad = (this.superficie() / 3) + largo

        if(ancho > largo) {
            cantidad = this.superficie() / 5
        }

        return cantidad
    }

    fun tieneComplicaciones() = plantas.any{ p -> p.horasSolQueTolera() < hsDeSol }

    fun plantar(planta: Planta) {
        if(plantas.size == this.cantidadMaximaDePlantas()) {
            throw Exception("No hay espacio para plantar otra planta")
        }
        else if(hsDeSol - planta.horasSolQueTolera() >= 2) {
            throw Exception("La planta no tolera tanto sol")
        }
        else {
            plantas.add(planta)
        }
    }
    abstract fun seAsociaBien(planta : Planta) : Boolean

    fun porcentajePlantasBienAsociadas() : Int {
        return 100 * (plantas.count {p -> this.seAsociaBien(p)}) / plantas.size
    }
}

class ParcelaEcologica(ancho: Int, largo: Int, hsDeSol: Int, plantas: MutableList<Planta>) : Parcela(ancho, largo, hsDeSol, plantas) {

    override fun seAsociaBien(planta: Planta): Boolean { //
        return this.tieneComplicaciones().not() && planta.leResultaIdeal(this)
    }
}

class ParcelaIndustrial(ancho: Int, largo: Int, hsDeSol: Int, plantas: MutableList<Planta>) : Parcela(ancho, largo, hsDeSol, plantas) {

    override fun seAsociaBien(planta: Planta): Boolean {
        return this.plantas.size <= 2 && planta.esFuerte()
    }
}
