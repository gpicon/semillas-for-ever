package ar.edu.unahur.obj2.semillas

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec({
    describe("Tests de parcelas") {
        val soja1 = Soja(1.2, 2005)
        val soja2 = Soja(1.7, 2007)
        val soja3 = Soja(1.5, 2009)
        val soja4 = Soja(1.3, 2015)
        val soja5 = Soja(0.7, 2010)
        val quinoa = Quinoa(0.2, 2.2, 2015)

        val parcela = ParcelaEcologica(20, 1, 10, mutableListOf(soja1, soja2, soja3, soja4))
        val parcelaEco = ParcelaEcologica(10, 3, 8, mutableListOf(soja1, soja2))
        val parcelaInd = ParcelaIndustrial(5, 3, 10, mutableListOf(soja3, soja4))

        it("Cantidad máxima de plantas que tolera") {
            parcela.cantidadMaximaDePlantas().shouldBe(4)
        }

        it("Superficie") {
            parcela.superficie().shouldBe(20)
        }

        it("Tiene complicaciones") {
            parcela.tieneComplicaciones().shouldBeFalse()
        }

        it("No se puede agregar una quinta planta") {
            shouldThrow<Exception> {  parcela.plantar(Menta(.5, 202))}
        }

        it("pruebo que la soja5 se asocia bien a la parcela Ecologica") {
            parcelaEco.seAsociaBien(soja5).shouldBeTrue()
        }

        it("pruebo que la quinoa se asocia bien a la parcela Industrial") {
            parcelaInd.seAsociaBien(quinoa).shouldBeTrue()
        }
    }
})