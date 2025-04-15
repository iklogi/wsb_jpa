package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.Collections;
import java.util.List;

public class VisitMapper {
    public static VisitTO toTO(VisitEntity entity) {
        VisitTO to = new VisitTO();
        to.setTime(entity.getTime());

        if (entity.getDoctor() != null) {
            to.setDoctorFirstName(entity.getDoctor().getFirstName());
            to.setDoctorLastName(entity.getDoctor().getLastName());
        }

        if (entity.getTreatment() != null) {
            to.setTreatmentTypes(List.of(entity.getTreatment().getType().name()));
        } else {
            to.setTreatmentTypes(Collections.emptyList());
        }

        return to;
    }
}
