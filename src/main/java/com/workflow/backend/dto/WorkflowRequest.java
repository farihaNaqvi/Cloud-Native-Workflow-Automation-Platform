package com.workflow.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class WorkflowRequest {

    @NotBlank(message = "Workflow name must not be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
