package com.workflow.backend.controller;

import com.workflow.backend.dto.CreateWorkflowRequest;
import com.workflow.backend.dto.WorkflowResponse;
import com.workflow.backend.model.Workflow;
import com.workflow.backend.service.WorkflowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping
    public WorkflowResponse create(@RequestBody CreateWorkflowRequest request) {
        Workflow workflow = workflowService.createWorkflow(request.getName());
        return map(workflow);
    }

    @PostMapping("/{id}/start")
    public WorkflowResponse start(@PathVariable UUID id) {
        return map(workflowService.startWorkflow(id));
    }

    @PostMapping("/{id}/complete")
    public WorkflowResponse complete(@PathVariable UUID id) {
        return map(workflowService.completeWorkflow(id));
    }

    @GetMapping
    public List<WorkflowResponse> getAll() {
        return workflowService.getAllWorkflows()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private WorkflowResponse map(Workflow workflow) {
        return new WorkflowResponse(
                workflow.getId(),
                workflow.getName(),
                workflow.getStatus().name()
        );
    }
}
