package es.dws.JVBt06e04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.dws.JVBt06e04.enumerations.VisitReasonEnum;
import es.dws.JVBt06e04.models.AddPatientRequest;
import es.dws.JVBt06e04.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{dni}")
    public String showPatient(
            @PathVariable(name = "dni", required = true) String dni,
            final Model model) {

        log.info("Showing view for patient {}", dni);
        model.addAttribute("patient", patientService.getPatientByDni(dni));
        return "patientView";
    }

    @GetMapping("/add")
    public String showForm(final Model model) {

        model.addAttribute("visitReasons", VisitReasonEnum.values());
        return "addPatientView";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute @Valid AddPatientRequest data) {

        patientService.addPatientFromRequest(data);
        return "redirect:/home?success=1";
    }

}
