package com.jpacourse.dto;

import java.util.List;


public class PatientTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isInsured;

    private List<VisitTO> pastVisits;
    private List<VisitTO> upcomingVisits;
    private List<VisitTO> visits;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Boolean getIsInsured() { return isInsured; }
    public void setIsInsured(Boolean insured) { isInsured = insured; }

    public List<VisitTO> getPastVisits() { return pastVisits; }
    public void setPastVisits(List<VisitTO> pastVisits) { this.pastVisits = pastVisits; }

    public List<VisitTO> getUpcomingVisits() { return upcomingVisits; }
    public void setUpcomingVisits(List<VisitTO> upcomingVisits) { this.upcomingVisits = upcomingVisits; }

    public List<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitTO> visits) {
        this.visits = visits;
    }
}


