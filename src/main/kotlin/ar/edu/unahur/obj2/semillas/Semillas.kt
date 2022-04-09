package ar.edu.unahur.obj2.semillas

    abstract class Planta(var altura: Double, val anioSemilla: Int) {
    open fun horasSolQueTolera() = 7

    fun esFuerte() = this.horasSolQueTolera() > 9

    open fun daSemillas() = this.esFuerte()

    abstract fun espacioQueOcupa() : Double

}

class Menta(altura: Double, anioSemilla: Int) : Planta(altura, anioSemilla) {

    override fun daSemillas(): Boolean {
        return super.daSemillas() || altura > 0.4
    }

    override fun espacioQueOcupa() : Double {
        return altura + 1
    }
}

class Soja(altura: Double, anioSemilla: Int) : Planta(altura, anioSemilla) {

    override fun horasSolQueTolera() : Int {
        var tolerancia = 6
        if(altura <= 1 && altura >= 0.5) {
            tolerancia = 8
        }
        if(altura > 1) {
            tolerancia = 12
        }
        return tolerancia
    }

    override fun daSemillas(): Boolean{
        return super.daSemillas() || (anioSemilla > 2007 && (altura > 0.75 && altura < 0.9))
    }

    override fun espacioQueOcupa() = altura / 2


}

class Quinoa(var espacio : Double, altura: Double, anioSemilla: Int) : Planta(altura, anioSemilla) {

    override fun espacioQueOcupa() = espacio

    override fun horasSolQueTolera(): Int { // NO SABEMOS SI ESTÁ BIEN
        var horas = super.horasSolQueTolera()
        if(espacioQueOcupa() < 0.3) {
            horas = 10
        }
        return horas
    }

    override fun daSemillas(): Boolean {
        return super.daSemillas() || (anioSemilla > 2001 && anioSemilla < 2008)
    }

}

