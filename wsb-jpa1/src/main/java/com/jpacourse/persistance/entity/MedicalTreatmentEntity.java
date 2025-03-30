package com.jpacourse.persistance.entity;

import com.jpacourse.persistance.enums.TreatmentType;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TreatmentType type;

	// Dwustronna relacja z VisitEntity-rodzic
	@OneToMany(mappedBy = "treatment", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VisitEntity> visits = new ArrayList<>();

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

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	public List<VisitEntity> getVisits() { return visits; }
	public void setVisits(List<VisitEntity> visits) { this.visits = visits; }
}
