package ar.com.dds.tps;

import ar.com.dds.exceptions.NoArticuloException;
import ar.com.dds.exceptions.OperacionCerradaException;
import ar.com.dds.exceptions.ZeroException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class EgresoTest {

    @DisplayName("Calculo de egreso OK, debería ser igual a 252.4")
    @Test
    public void testCalcularValorDeEgresoOK() throws ZeroException {
        Egreso egreso = UtilTest.egresoConItemsVariadosAbierta();
        assertEquals(252.4, egreso.valorDeEgreso().doubleValue(), UtilTest.DELTA);
    }

    @DisplayName("Calculo de egreso igual a 0, debería arrojar excepcion")
    @Test
    public void testCalcularValorDeEgresoDeberiaArrojarExcepcion() {
        Egreso egreso = UtilTest.egresoConItemsConPrecioZero();
        assertThrows(ZeroException.class, () -> {
            egreso.valorDeEgreso();
        });
    }

    @DisplayName("Agregar item a operacion abierta, debería agregarla OK")
    @Test
    public void testAgregarItemAOperacionAbierta() throws OperacionCerradaException {
        Egreso egreso = UtilTest.egresoConItemsVariadosAbierta();
        Item nuevoItem = new Articulo("8", new BigDecimal(34));

        egreso.addItem(nuevoItem);
        //assertTrue(egreso.items.stream().filter(item -> item.getId().equals(nuevoItem.getId())).findAny().isPresent());
        assertTrue(egreso.items.stream().filter(item -> item == nuevoItem).findAny().isPresent());
    }

    //● Una vez que la operación está cerrada, no se le puede cambiar el precio
    @DisplayName("Agregar item a operacion cerrada, debería arrojar excepcion")
    @Test
    public void testAgregarItemAOperacionCerrada() {
        Egreso egreso = UtilTest.egresoConItemsVariadosCerrada();
        Item nuevoItem = new Articulo("1", new BigDecimal(34));

        assertThrows(OperacionCerradaException.class, () -> {
            egreso.addItem(nuevoItem);
        });
    }

    @DisplayName("Cambiar precio de un item a una operacion abierta, debería terminar OK")
    @Test
    public void testModificarPrecioAItemDeOperacionAbierta() throws OperacionCerradaException, ZeroException {
        Egreso egreso = UtilTest.egresoConItemsVariadosAbierta();
        Articulo articulo = new Articulo("1", new BigDecimal(50));
        egreso.modificarPrecio(articulo);

        assertEquals(279.1, egreso.valorDeEgreso().doubleValue());
    }

    @DisplayName("Compra solo con articulos, debe generar remito OK")
    @Test
    public void testCompraSoloConArticulosGeneraRemitoOK() throws NoArticuloException {
        Compra compra = UtilTest.compraConItemsSoloDeTipoArticulo();

        assertEquals(compra.generarDocumentacion(), "remito.txt");
    }

    @DisplayName("Compra con items variados, debería arrojar excepcion")
    @Test
    public void testCompraConItemsVariadosDeberiaArrojarExcepcion() {
        Compra compra = UtilTest.conpraConItemsVariados();

        assertThrows(NoArticuloException.class, () -> {
            compra.generarDocumentacion();
        });
    }


}
