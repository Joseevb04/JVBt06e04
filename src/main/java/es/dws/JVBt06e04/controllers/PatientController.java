package es.dws.JVBt06e04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.dws.JVBt06e04.enumerations.VisitReasonEnum;
import es.dws.JVBt06e04.models.AddPatientRequest;
import es.dws.JVBt06e04.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/add")
    public String showForm(final Model model) {

        model.addAttribute("visitReasons", VisitReasonEnum.values());
        return "addPatientView";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute @Valid AddPatientRequest data) {

        return "redirect:/patient/add?name=%s".formatted(data.getName());
    }

}
