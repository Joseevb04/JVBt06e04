package es.dws.JVBt06e04.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.dws.JVBt06e04.services.PatientService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PatientService patientService;

    @GetMapping({ "/", "/home" })
    public String showHome(
            @RequestParam(name = "success") Optional<String> success,
            final Model model) {

        success.ifPresent(code -> model.addAttribute("success",
                switch (code) {
                    case "1" -> "Paciente agreagado correctamente";
                    default -> "Codigo inesperado";
                }));

        model.addAttribute("patients", patientService.getAllPatients());
        return "indexView";
    }

}
