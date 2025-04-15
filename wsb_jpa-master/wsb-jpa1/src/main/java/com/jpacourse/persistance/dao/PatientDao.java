package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.repository.DoctorRepository;
import com.jpacourse.persistance.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

    @Repository
    public class PatientDao {

        @Autowired
        private PatientRepository patientRepository;

        @Autowired
        private DoctorRepository doctorRepository;

        @Autowired
        private EntityManager entityManager;

        @Transactional
        public void addVisitToPatient(Long patientId, Long doctorId, Long treatmentId, LocalDateTime time, String description) {
            PatientEntity patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

            DoctorEntity doctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

            var treatment = entityManager.find(com.jpacourse.persistance.entity.MedicalTreatmentEntity.class, treatmentId);
            if (treatment == null) {
                throw new IllegalArgumentException("Treatment not found");
            }

            VisitEntity visit = new VisitEntity();
            visit.setTime(time);
            visit.setDoctor(doctor);
            visit.setPatient(patient);
            visit.setDescription(description);
            visit.setTreatment(treatment); // ← DODANE!

            patient.getVisits().add(visit);

            entityManager.merge(patient);
        }
    }
