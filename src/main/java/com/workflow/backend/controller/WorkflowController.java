package com.workflow.backend.controller;

import com.workflow.backend.dto.CreateWorkflowRequest;
import com.workflow.backend.dto.WorkflowRequest;
import com.workflow.backend.dto.WorkflowResponse;
import com.workflow.backend.model.Workflow;
import com.workflow.backend.service.WorkflowService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }


    @PostMapping("/{id}/start")
    public ResponseEntity<WorkflowResponse> start(@PathVariable UUID id) {
        return ResponseEntity.ok(map(workflowService.startWorkflow(id)));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<WorkflowResponse> complete(@PathVariable UUID id) {
        return ResponseEntity.ok(map(workflowService.completeWorkflow(id)));
    }

    @GetMapping
    public ResponseEntity<List<WorkflowResponse>> getAll() {
        return ResponseEntity.ok(
                workflowService.getAllWorkflows()
                        .stream()
                        .map(this::map)
                        .toList()
        );
    }

    @PostMapping
    public ResponseEntity<WorkflowResponse> create(
            @Valid @RequestBody WorkflowRequest request) {

        Workflow workflow = workflowService.create(request.getName());
        return ResponseEntity.ok(mapToResponse(workflow));
    }

    private WorkflowResponse map(Workflow workflow) {
        return new WorkflowResponse(
                workflow.getId(),
                workflow.getName(),
                workflow.getStatus().name()
        );
    }
    private WorkflowResponse mapToResponse(Workflow workflow) {
        return new WorkflowResponse(
                workflow.getId(),
                workflow.getName(),
                workflow.getStatus().name()
        );
    }

}
//http://localhost:8080/swagger-ui.html
