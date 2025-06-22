package strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LlamadaTest {

    @Test
    public void testLlamadaNacionalSinPromo() {
        var llamada = new Llamada(TipoLlamada.NACIONAL, 20);
        var costo = llamada.calcularCosto();
        assertEquals(22.0F, costo, 0.001F);
    }

    @Test
    public void testLlamadaNacionalConPromo() {
        var llamada = new Llamada(TipoLlamada.NACIONAL, 135);
        var costo = llamada.calcularCosto();
        assertEquals(141.075F, costo, 0.001F);
    }

    @Test
    public void testLlamadaInternacionalSinPromo() {
        var llamada = new Llamada(TipoLlamada.INTERNACIONAL, 15);
        var costo = llamada.calcularCosto();
        assertEquals(22.5F, costo, 0.001F);
    }

    @Test
    public void testLlamadaInternacionalConPromo() {
        var llamada = new Llamada(TipoLlamada.INTERNACIONAL, 135);
        var costo = llamada.calcularCosto();
        assertEquals(192.375F, costo, 0.001F);
    }
}
