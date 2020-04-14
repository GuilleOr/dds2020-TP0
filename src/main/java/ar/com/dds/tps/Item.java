package ar.com.dds.tps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public abstract class Item {

    private String id;
    private BigDecimal precio;

}
