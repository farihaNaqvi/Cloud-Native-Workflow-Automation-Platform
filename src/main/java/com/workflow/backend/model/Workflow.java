package com.workflow.backend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "workflows")
public class Workflow {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private WorkflowStatus status;

    protected Workflow() {}

    public Workflow(String name) {
        this.name = name;
        this.status = WorkflowStatus.CREATED;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public WorkflowStatus getStatus() {
        return status;
    }

    public void setStatus(WorkflowStatus status) {
        this.status = status;
    }

}
