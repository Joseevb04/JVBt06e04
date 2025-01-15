package es.dws.JVBt06e04.models;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import es.dws.JVBt06e04.enumerations.VisitReasonEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @Column(name = "dni", nullable = false, unique = true)
    @NotBlank(message = "El campo dni no puede estar vacío")
    private String dni;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "El campo nombre no puede estar vacío")
    private String name;

    @Past(message = "La fecha de nacimiento no puede ser anterior a la fecha actual")
    @Column(name = "birth_date", nullable = false)
    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    private LocalDate birthDate;

    @Column(name = "visit_reason", nullable = false)
    @NotNull(message = "El campo razón de visita no puede estar vacío")
    @Enumerated(EnumType.STRING)
    private VisitReasonEnum visitReason;

    @Column(name = "appointment_reason", nullable = false)
    @NotBlank(message = "El campo razón de visita no puede estar vacío")
    private String appointmentReason;

    @Builder.Default
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipes = new LinkedList<>();

    @Past(message = "La fecha de la última visita no puede ser anterior a la fecha actual")
    @Column(name = "previous_visit", nullable = true)
    private LocalDate previousVisit;
}
