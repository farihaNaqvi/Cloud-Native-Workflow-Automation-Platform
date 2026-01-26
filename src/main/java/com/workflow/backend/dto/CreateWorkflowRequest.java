package com.workflow.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateWorkflowRequest {

    @NotBlank(message = "Workflow name is required")
    @Size(min = 3, max = 50, message = "Workflow name must be between 3 and 50 characters")
    private String name;

    public CreateWorkflowRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
