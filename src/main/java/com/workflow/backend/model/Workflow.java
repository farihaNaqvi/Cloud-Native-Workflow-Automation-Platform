package com.workflow.backend.model;

import java.util.UUID;

public class Workflow {

    private UUID id;
    private String name;
    private String status;

    public Workflow(UUID id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
