package com.jpacourse.service;

import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.repository.PatientRepository;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.PatientEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::toTO)
                .collect(Collectors.toList());
    }

    public List<PatientTO> getInsuredPatients() {
        return patientRepository.findByIsInsuredTrue().stream()
                .map(PatientMapper::toTO)
                .collect(Collectors.toList());
    }

    public PatientTO getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(PatientMapper::toTO)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Transactional
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientTO findById(Long id) {
        return patientRepository.findById(id)
                .map(PatientMapper::toTO)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}