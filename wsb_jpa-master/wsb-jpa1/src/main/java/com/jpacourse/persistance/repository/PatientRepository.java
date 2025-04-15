package com.jpacourse.persistance.repository;

import com.jpacourse.persistance.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findByIsInsuredTrue();

    List<PatientEntity> findByLastName(String lastName);

    PatientEntity findByPatientNumber(String patientNumber);

    List<PatientEntity> findByIsInsuredFalse();

    boolean existsByPatientNumber(String patientNumber);
    }
