package br.com.targettrust;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculoIMCTest {


    @Test
    void calcularIMC() {
        CalculoIMC calculoIMC = new CalculoIMC();
        var imc = calculoIMC.calcularIMC(82.0f, 1.75f, 2);
        assertEquals(26.78f, imc, 0.01);
    }

    @Test
    void calcularIMC_scenario2() {
        CalculoIMC calculadoraIMC = new CalculoIMC();
        var result = calculadoraIMC.calcularIMC(82.0f, 1.75f, 2);
        assertThat(result).isCloseTo(26.78d, Percentage.withPercentage(0.1));

    }

    /*Teste será repetido com oa vlores de cada string separador por ","*/
    @ParameterizedTest
    @CsvSource({"82.0f,1.75f,26.78f", "80.0f,1.79f,24.96f", "75.0f,1.65f,27.54f"})
    void calcularIMC_scenario_valores_corretos(float peso, float altura, double resultadoEsperado) {
        CalculoIMC calculadoraIMC = new CalculoIMC();
        var result = calculadoraIMC.calcularIMC(peso, altura, 2);
        assertEquals(resultadoEsperado, result, 0.01);
    }

/*  @ParameterizedTest
    @MethodSource("calculoIMCOutliner")
       @Disabled
    void calcularIMCOutliner(float peso, float altura, double resultadoEsperado) {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(peso, altura, 2);
        assertEquals(resultadoEsperado, result, 0.01);
    }

    // Gerando aleatoriamente os resultados, não é previsiviel, ou seja o teste pode falhar aleatoriamente.
    private static Stream<Arguments> calculoIMCOutliner() {
        return IntStream.range(1, 100)
                .mapToObj(valor -> Arguments.of(random.nextFloat() * 1000, random.nextFloat()* 1000, 0.0f));

    }*/

    @Test
    void classificarIMC() {
        CalculoIMC calculoIMC = new CalculoIMC();
        var result = calculoIMC.classificarIMC(17.0f);
        assertEquals("Você está magro(a)", result);
    }


}