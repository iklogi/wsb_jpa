package com.jpacourse.persistance.dao;

import com.jpacourse.WsbJpaApplication;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.repository.PatientRepository;
import com.jpacourse.persistance.repository.VisitRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = WsbJpaApplication.class)
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Test
    void shouldAddVisitToPatient() {
        Long patientId = 1L;
        Long doctorId = 2L;
        Long treatmentId = 1L;
        LocalDateTime time = LocalDateTime.of(2025, 6, 13, 10, 22);
        String description = "Nowa wizyta testowa";

        int initialVisitCount = visitRepository.findAll().size();

        patientDao.addVisitToPatient(patientId, doctorId, treatmentId, time, description);

        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        assertThat(patient.getVisits())
                .anyMatch(v -> v.getTime().equals(time) && description.equals(v.getDescription()));

        assertThat(visitRepository.findAll().size()).isGreaterThan(initialVisitCount);
    }
}
