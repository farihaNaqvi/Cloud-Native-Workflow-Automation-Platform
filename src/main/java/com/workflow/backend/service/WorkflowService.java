package com.workflow.backend.service;

import com.workflow.backend.model.Workflow;
import com.workflow.backend.model.WorkflowStatus;
import com.workflow.backend.repository.WorkflowRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import com.workflow.backend.exception.WorkflowNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WorkflowService {

    private static final Logger log =
            LoggerFactory.getLogger(WorkflowService.class);

    private final WorkflowRepository repository;

    public WorkflowService(WorkflowRepository repository) {
        this.repository = repository;
    }

    public Workflow createWorkflow(String name) {
        log.info("Creating workflow with name={}", name);
        return repository.save(new Workflow(name));
    }

    public Workflow startWorkflow(UUID id) {
        log.info("Starting workflow id={}", id);
        Workflow workflow = repository.findById(id)
                .orElseThrow(() -> new WorkflowNotFoundException(id));

        workflow.setStatus(WorkflowStatus.RUNNING);
        return repository.save(workflow);
    }

    public Workflow completeWorkflow(UUID id) {
        log.info("Completing workflow id={}", id);
        Workflow workflow = repository.findById(id)
                .orElseThrow(() -> new WorkflowNotFoundException(id));

        workflow.setStatus(WorkflowStatus.COMPLETED);
        return repository.save(workflow);
    }

    public List<Workflow> getAllWorkflows() {
        return repository.findAll();
    }
}
