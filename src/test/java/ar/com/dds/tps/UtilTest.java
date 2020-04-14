package ar.com.dds.tps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UtilTest {

    static final double DELTA = 1e-15;
    static Egreso egreso = new Egreso();
    static Compra compra = new Compra();
    static Item articulo1 = new Articulo("1", new BigDecimal(23.3));
    static Item articulo2 = new Articulo("2", new BigDecimal(56));
    static Item articulo3 = new Articulo("3", new BigDecimal(78.9));


    static Item servicio1 = new Servicio("1", new BigDecimal(34));
    static Item servicio2 = new Servicio("2", new BigDecimal(60.2));

    static Item articulo4 = new Articulo("4", new BigDecimal(0));
    static Item servicio3= new Servicio("3", new BigDecimal(0));

    public static Egreso egresoConItemsVariadosCerrada() {
        egreso.setItems(new ArrayList<>(Arrays.asList(articulo1, articulo2, articulo3, servicio1, servicio2)));
        egreso.setCerrada(Boolean.TRUE);
        return egreso;
    }
    public static Egreso egresoConItemsVariadosAbierta() {
        egreso.setItems(new ArrayList<>(Arrays.asList(articulo1, articulo2, articulo3, servicio1, servicio2)));
        egreso.setCerrada(Boolean.FALSE);
        return egreso;
    }
    public static Egreso egresoConSoloArticulosCerrada() {
        egreso.setItems(new ArrayList<>(Arrays.asList(articulo1, articulo2, articulo3)));
        egreso.setCerrada(Boolean.TRUE);
        return egreso;
    }
    public static Egreso egresoConSoloArticulosAbierta() {
        egreso.setItems(new ArrayList<>(Arrays.asList(articulo1, articulo2, articulo3)));
        egreso.setCerrada(Boolean.FALSE);
        return egreso;
    }

    public static Egreso egresoConItemsConPrecioZero() {
        egreso.setItems(new ArrayList<>(Arrays.asList(articulo4, servicio3)));
        return egreso;
    }

    public static Compra conpraConItemsVariados() {
        compra.setItems(new ArrayList<>(Arrays.asList(articulo1, articulo2, articulo3, servicio1, servicio2)));
        return compra;
    }

    public static Compra compraConItemsSoloDeTipoArticulo() {
        compra.setItems(new ArrayList<>(Arrays.asList(articulo1, articulo2, articulo3)));
        return compra;
    }


}
