package com.workflow.backend.service;

import com.workflow.backend.model.Workflow;
import com.workflow.backend.model.WorkflowStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WorkflowService {

    private final Map<UUID, Workflow> workflowStore = new ConcurrentHashMap<>();

    public Workflow createWorkflow(String name) {
        Workflow workflow = new Workflow(
                UUID.randomUUID(),
                name,
                WorkflowStatus.CREATED
        );
        workflowStore.put(workflow.getId(), workflow);
        return workflow;
    }

    public Workflow startWorkflow(UUID id) {
        Workflow workflow = workflowStore.get(id);
        workflow.setStatus(WorkflowStatus.RUNNING);
        return workflow;
    }

    public Workflow completeWorkflow(UUID id) {
        Workflow workflow = workflowStore.get(id);
        workflow.setStatus(WorkflowStatus.COMPLETED);
        return workflow;
    }

    public Collection<Workflow> getAllWorkflows() {
        return workflowStore.values();
    }
}
