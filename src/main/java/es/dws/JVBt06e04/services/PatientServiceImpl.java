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
    public Patient getAllPatientsByDni(String dni) {
        return patientRepository.findById(dni)
                .orElseThrow(() -> new EntityNotFoundException("Patient with dni: %s".formatted(dni)));
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient addPatientFromRequest(AddPatientRequest data) {
        final List<Recipe> recipes = Arrays.asList(data.getRecipes().split(",")).stream().map(mapper);
    }
}
