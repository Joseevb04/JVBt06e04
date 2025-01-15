package es.dws.JVBt06e04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dws.JVBt06e04.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
}
