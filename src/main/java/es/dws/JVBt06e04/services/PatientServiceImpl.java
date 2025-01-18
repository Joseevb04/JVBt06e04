package es.dws.JVBt06e04.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import es.dws.JVBt06e04.models.AddPatientRequest;
import es.dws.JVBt06e04.models.Patient;
import es.dws.JVBt06e04.models.Recipe;
import es.dws.JVBt06e04.repositories.PatientRepository;
import es.dws.JVBt06e04.repositories.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final RecipeRepository recipeRepository;
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientByDni(String dni) {
        return patientRepository
                .findById(dni)
                .orElseThrow(() -> new EntityNotFoundException("Patient with dni: %s".formatted(dni)));
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    @Transactional
    public Patient addPatientFromRequest(AddPatientRequest data) {
        if (data.getRecipes() == null || data.getRecipes().isBlank()) {
            throw new IllegalArgumentException("Recipes cannot be null or empty");
        }

        List<Recipe> recipes = Arrays.stream(data.getRecipes().split(","))
                .map(recipeName -> Recipe.builder()
                        .recipe(recipeName.trim())
                        .build())
                .toList();

        Patient patient = Patient.builder()
                .dni(data.getDni())
                .name(data.getName())
                .birthDate(data.getBirthdate())
                .visitReason(data.getVisitReason())
                .appointmentReason(data.getAppointmentReason())
                .previousVisit(data.getPreviousAppointment())
                .build();

        recipes.forEach(recipe -> recipe.setPatient(patient));
        patient.setRecipes(recipes);

        recipeRepository.saveAll(recipes);
        return patientRepository.save(patient);
    }
}
