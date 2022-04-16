package ar.edu.unahur.obj2.semillas

// PUNTO 1

abstract class Planta(var altura: Double, val anioSemilla: Int) {
    open fun horasSolQueTolera() = 7

    fun esFuerte() = this.horasSolQueTolera() > 9

    open fun daSemillas() = this.esFuerte()

    abstract fun espacioQueOcupa() : Double

    abstract fun leResultaIdeal(parcela: Parcela) : Boolean

}

open class Menta(altura: Double, anioSemilla: Int) : Planta(altura, anioSemilla) {

    override fun daSemillas(): Boolean {
        return super.daSemillas() || altura > 0.4
    }

    override fun espacioQueOcupa() : Double {
        return altura + 1
    }

    override fun leResultaIdeal(parcela: Parcela) : Boolean {
        return parcela.superficie() > 6
    }
}

open class Soja(altura: Double, anioSemilla: Int) : Planta(altura, anioSemilla) {

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

    override fun leResultaIdeal(parcela: Parcela): Boolean {
        return this.horasSolQueTolera() == parcela.hsDeSol
    }

}

class Quinoa(var espacio : Double, altura: Double, anioSemilla: Int) : Planta(altura, anioSemilla) {

    override fun espacioQueOcupa() = espacio

    override fun horasSolQueTolera(): Int {
        var horas = super.horasSolQueTolera()
        if(espacioQueOcupa() < 0.3) {
            horas = 10
        }
        return horas
    }

    override fun daSemillas(): Boolean {
        return super.daSemillas() || (anioSemilla > 2001 && anioSemilla < 2008)
    }

    override fun leResultaIdeal(parcela: Parcela): Boolean {
        return (parcela.plantas.any { p -> p.altura > 1.5 }).not()
    }

}

// PUNTO 2

class SojaTransgenica (altura: Double, anioSemilla: Int) : Soja(altura, anioSemilla) {
    override fun daSemillas() = false

    override fun leResultaIdeal(parcela: Parcela): Boolean {
        return parcela.cantidadMaximaDePlantas() == 1
    }
}

class Peperina(altura: Double, anioSemilla: Int) : Menta(altura, anioSemilla) {
    override fun espacioQueOcupa(): Double {
        return super.espacioQueOcupa() * 2
    }
}

