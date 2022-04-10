package ar.edu.unahur.obj2.semillas

class Parcela(val ancho : Int, val largo : Int, val hsDeSol : Int, var plantas : MutableList<Planta>) {
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
}