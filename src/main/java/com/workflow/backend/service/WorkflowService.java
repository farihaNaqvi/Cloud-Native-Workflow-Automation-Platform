package com.workflow.backend.service;

import com.workflow.backend.model.Workflow;
import com.workflow.backend.model.WorkflowStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import com.workflow.backend.exception.WorkflowNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WorkflowService {

    private final Map<UUID, Workflow> workflowStore = new ConcurrentHashMap<>();
    private static final Logger log = LoggerFactory.getLogger(WorkflowService.class);

    public Workflow createWorkflow(String name) {
        log.info("Creating workflow with name={}", name);
        Workflow workflow = new Workflow(
                UUID.randomUUID(),
                name,
                WorkflowStatus.CREATED
        );
        workflowStore.put(workflow.getId(), workflow);
        return workflow;
    }

    public Workflow startWorkflow(UUID id) {
        log.info("Starting workflow id={}", id);
        Workflow workflow = workflowStore.get(id);
        if (workflow == null) {
            throw new WorkflowNotFoundException(id);
        }
        workflow.setStatus(WorkflowStatus.RUNNING);
        return workflow;
    }


    public Workflow completeWorkflow(UUID id) {
        log.info("Completing workflow id={}", id);
        Workflow workflow = workflowStore.get(id);
        if (workflow == null) {
            throw new WorkflowNotFoundException(id);
        }
        workflow.setStatus(WorkflowStatus.COMPLETED);
        return workflow;
    }

    public Collection<Workflow> getAllWorkflows() {
        return workflowStore.values();
    }
}
