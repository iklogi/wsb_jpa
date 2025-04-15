package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {
    public static PatientTO toTO(PatientEntity entity) {
        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setIsInsured(entity.getIsInsured());

        LocalDateTime now = LocalDateTime.now();

        List<VisitTO> pastVisits = entity.getVisits().stream()
                .filter(v -> v.getTime().isBefore(now))
                .map(VisitMapper::toTO)
                .collect(Collectors.toList());

        List<VisitTO> upcomingVisits = entity.getVisits().stream()
                .filter(v -> !v.getTime().isBefore(now))
                .map(VisitMapper::toTO)
                .collect(Collectors.toList());

        List<VisitTO> allVisits = new ArrayList<>();
        allVisits.addAll(pastVisits);
        allVisits.addAll(upcomingVisits);
        to.setVisits(allVisits);

        to.setPastVisits(pastVisits);
        to.setUpcomingVisits(upcomingVisits);

        return to;
    }
}