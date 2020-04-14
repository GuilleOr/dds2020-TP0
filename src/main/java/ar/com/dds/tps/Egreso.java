package ar.com.dds.tps;

import ar.com.dds.exceptions.OperacionCerradaException;
import ar.com.dds.exceptions.ZeroException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Egreso extends Operacion {
    boolean cerrada;

    public BigDecimal valorDeEgreso() throws ZeroException {
        BigDecimal result = items.stream().map(item -> item.getPrecio())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (result.compareTo(BigDecimal.ZERO) == 0) {
            throw new ZeroException();
        }
        return result;
    }

    public void cerrarOperacion() {
        this.cerrada = true;
    }

    public void addItem(Item item) throws OperacionCerradaException {
        checkEstadoValido();
        items.add(item);
    }

    public void modificarPrecio(Item itemAmodificar) throws OperacionCerradaException {
        checkEstadoValido();
        items.stream().filter(item -> item.getClass().equals(itemAmodificar.getClass()) &&
                item.getId().equals(itemAmodificar.getId()))
                .forEach(item -> item.setPrecio(itemAmodificar.getPrecio()));
    }

    private void checkEstadoValido() throws OperacionCerradaException {
        if (this.isCerrada()) {
            throw new OperacionCerradaException();
        }
    }


}
