package es.dws.JVBt06e04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.dws.JVBt06e04.services.PatientService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PatientService patientService;

    @GetMapping({ "/", "/home" })
    public String showHome(final Model model) {

        model.addAttribute("patients", patientService.getAllPatients());
        return "indexView";
    }

}
