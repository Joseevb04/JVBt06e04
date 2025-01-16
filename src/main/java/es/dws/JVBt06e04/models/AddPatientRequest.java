package es.dws.JVBt06e04.models;

import java.time.LocalDate;

import es.dws.JVBt06e04.enumerations.VisitReasonEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddPatientRequest {

    @NotBlank(message = "El campo dni no puede estar vacío")
    @Pattern(regexp = "^(\\d{8}[A-HJ-NP-TV-Z])|([XYZ]\\d{7}[A-HJ-NP-TV-Z])$", message = "El campo dni debe tener un documento valido")
    private String dni;

    @NotBlank(message = "El campo nombre no puede estar vacío")
    private String name;

    @Past(message = "La fecha de nacimiento no puede ser mayor a la fecha actual")
    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    private LocalDate birthdate;

    @NotNull(message = "El campo razón de visita no puede estar vacío")
    private VisitReasonEnum visitReason;

    @NotBlank(message = "El campo razón de visita no puede estar vacío")
    private String appointmentReason;

    @NotBlank(message = "El campo medicamentos no puede estar vacío")
    @Pattern(regexp = "^(\\w+(,\\s*\\w+)*)?$", message = "Las palabras deben estar separadas por comas")
    private String recipes;

    @Past(message = "La fecha de la última visita no puede ser mayor a la fecha actual")
    @NotNull(message = "La fecha de la última visita no puede estar vacía")
    private LocalDate previousAppointment;
}
