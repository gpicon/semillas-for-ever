package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class IntaTest : DescribeSpec ({
    describe("test de Inta") {
        val soja1 = Soja(1.5, 2015)
        val soja2 = Soja(1.0, 2012)
        val menta1 = Menta(1.0, 2010)
        val quinoa1 = Quinoa(3.3, 0.7, 2017)
        val peperina1 = Peperina(1.2, 2018)
        val sojaTrans1 = SojaTransgenica(1.9, 2020)
        val parcela1 = ParcelaEcologica(2, 3, 9, mutableListOf(soja1, soja2, menta1, quinoa1, peperina1))
        val parcela2 = ParcelaIndustrial(3, 4, 13, mutableListOf(quinoa1, peperina1, sojaTrans1, menta1, soja1))

        Inta.parcelas.add(parcela1)
        Inta.parcelas.add(parcela2)

        it("probamos el promedio de plantas por parcela") {
            Inta.promedioPlantasPorParcela().shouldBe(5)
        }

        it("probamos la parcela mas autosustentable") {
            Inta.parcelaMasAutosustentable().shouldBe(parcela1)
        }
    }
})