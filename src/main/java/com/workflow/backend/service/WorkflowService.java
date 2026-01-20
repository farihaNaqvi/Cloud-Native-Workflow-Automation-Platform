package com.workflow.backend.service;

import com.workflow.backend.model.Workflow;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WorkflowService {

    public Workflow createWorkflow(String name) {
        return new Workflow(
                UUID.randomUUID(),
                name,
                "CREATED"
        );
    }
}
