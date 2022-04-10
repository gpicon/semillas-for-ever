package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val sojaTransgenica = SojaTransgenica(0.8, 2005)
        val peperina = Peperina(1.0, 2021)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
            mentita.altura.shouldBe(0.3)
            mentita.anioSemilla.shouldBe(2021)
            soja.altura.shouldBe(0.6)
            soja.anioSemilla.shouldBe(2009)
            sojaTransgenica.altura.shouldBe(0.8)
            sojaTransgenica.anioSemilla.shouldBe(2005)
            peperina.altura.shouldBe(1.0)
            peperina.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            mentita.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
            sojaTransgenica.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacioQueOcupa().shouldBe(2.0)
            mentita.espacioQueOcupa().shouldBe(1.3)
            soja.espacioQueOcupa().shouldBe(0.3)
            peperina.espacioQueOcupa().shouldBe(4)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacioQueOcupa(),
                menta.espacioQueOcupa(),
                mentita.espacioQueOcupa()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }
    }
})