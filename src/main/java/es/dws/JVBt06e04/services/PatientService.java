package es.dws.JVBt06e04.services;

import java.util.List;

import es.dws.JVBt06e04.models.AddPatientRequest;
import es.dws.JVBt06e04.models.Patient;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientByDni(final String dni);

    Patient addPatient(final Patient patient);

    Patient addPatientFromRequest(final AddPatientRequest data);
}
