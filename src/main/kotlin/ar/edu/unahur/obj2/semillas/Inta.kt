package ar.edu.unahur.obj2.semillas

object Inta {
    var parcelas = mutableListOf<Parcela>()

    fun totalPlantasEnParcela() : Int {
        return parcelas.sumOf { p -> p.plantas.size }
    }

    fun promedioPlantasPorParcela() = this.totalPlantasEnParcela() / parcelas.size

    fun parcelaMasAutosustentable() = parcelas.filter { p -> p.plantas.size > 4 }.maxBy { p -> p.porcentajePlantasBienAsociadas()  }

}