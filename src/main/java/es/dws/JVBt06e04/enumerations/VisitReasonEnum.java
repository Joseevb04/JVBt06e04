package es.dws.JVBt06e04.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VisitReasonEnum {
    APPOINTMENT("consulta"),
    RECIPE("recetas"),
    REVISION("revisión");

    private final String value;
}
