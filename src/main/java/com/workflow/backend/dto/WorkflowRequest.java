package com.workflow.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WorkflowRequest {

    @NotBlank(message = "Workflow name is required")
    @Size(min = 3, message = "Workflow name must be at least 3 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
