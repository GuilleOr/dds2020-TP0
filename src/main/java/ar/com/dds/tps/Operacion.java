package ar.com.dds.tps;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Operacion {
    List<Item> items = new ArrayList<>();
}
