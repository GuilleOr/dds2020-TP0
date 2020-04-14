package ar.com.dds.tps;

import ar.com.dds.exceptions.NoArticuloException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compra extends Operacion {

    public String generarDocumentacion() throws NoArticuloException {
        if (!sonTodosArticulos()) {
            throw new NoArticuloException();
        };
        return "remito.txt";
    }

    private boolean sonTodosArticulos() {
        return this.getItems().stream().allMatch(Articulo.class::isInstance);
    }
}
