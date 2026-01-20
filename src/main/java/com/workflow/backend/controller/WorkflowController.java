package com.workflow.backend.controller;

import com.workflow.backend.model.Workflow;
import com.workflow.backend.service.WorkflowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping
    public Workflow createWorkflow(@RequestParam String name) {
        return workflowService.createWorkflow(name);
    }
}
