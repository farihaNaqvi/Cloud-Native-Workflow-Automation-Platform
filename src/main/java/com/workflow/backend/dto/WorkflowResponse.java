package com.workflow.backend.dto;

import java.util.UUID;

public class WorkflowResponse {

    private UUID id;
    private String name;
    private String status;

    public WorkflowResponse(UUID id, String name, String status) {
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
