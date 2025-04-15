package com.jpacourse.service;

import org.junit.jupiter.api.Assertions;
import com.jpacourse.WsbJpaApplication;
import com.jpacourse.persistance.repository.PatientRepository;
import com.jpacourse.persistance.repository.VisitRepository;
import com.jpacourse.persistance.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = WsbJpaApplication.class)
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    void shouldDeletePatientAndCascadeVisits() {
        long initialDoctors = doctorRepository.count();
        long initialVisits = visitRepository.count();

        patientService.deleteById(1L);

        Assertions.assertFalse(patientRepository.findById(1L).isPresent());
        Assertions.assertTrue(visitRepository.findAll().size() < initialVisits);
        Assertions.assertEquals(initialDoctors, doctorRepository.count());
    }

    @Test
    void shouldReturnPatientWithCorrectFields() {
        var patient = patientService.findById(2L);

        Assertions.assertEquals("Anna", patient.getFirstName());
        Assertions.assertFalse(patient.getIsInsured());
        Assertions.assertEquals(2, patient.getVisits().size());
    }
}