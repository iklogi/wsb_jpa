package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// Dwustronna relacja- VisitEntity zna pacjenta, a Patient ma listę wizyt
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient;

	// Dwustronna relacja- VisitEntity zna lekarza, a Doctor ma listę wizyt
	@ManyToOne
	@JoinColumn(name= "doctor_id", nullable = false)
	private DoctorEntity doctor;

	// Dwustronna relacja- VisitEntity zna leczenie, a MedicalTreatment ma listę wizyt
	@ManyToOne
	@JoinColumn(name = "treatment_id", nullable = false)
	private MedicalTreatmentEntity treatment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public PatientEntity getPatient() {return patient; }
	public void setPatient(PatientEntity patient) { this.patient = patient; }

	public DoctorEntity getDoctor() { return doctor; }
	public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }

	public MedicalTreatmentEntity getTreatment() { return treatment; }
	public void setTreatment(MedicalTreatmentEntity treatment) { this.treatment = treatment; }
}
