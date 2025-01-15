package es.dws.JVBt06e04.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dws.JVBt06e04.models.Patient;
import es.dws.JVBt06e04.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

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

}
