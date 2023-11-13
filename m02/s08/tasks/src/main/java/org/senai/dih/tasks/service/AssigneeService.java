package org.senai.dih.tasks.service;

import jakarta.transaction.Transactional;
import org.senai.dih.tasks.model.Assignee;
import org.senai.dih.tasks.model.transport.AssigneeDTO;
import org.senai.dih.tasks.model.transport.create.CreateAssigneeDTO;
import org.senai.dih.tasks.repository.AssigneeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AssigneeService {

    private final AssigneeRepository assigneeRepository;

    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    @Transactional
    public AssigneeDTO create(CreateAssigneeDTO assigneeDTO) {
        Assignee newAssignee = new Assignee(assigneeDTO);
        Assignee response = this.assigneeRepository.save(newAssignee);
        return new AssigneeDTO(response);
    }

    public Page<AssigneeDTO> list(Pageable pageable) {
        return this.assigneeRepository.findAll(pageable).map(AssigneeDTO::new);
    }

    @Transactional
    public AssigneeDTO update(Long id, CreateAssigneeDTO assigneeDTO) {
        Assignee assignee = this.assigneeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assignee with id not found: " + id));

        assignee.setName(assigneeDTO.name());
        assignee.setEmail(assigneeDTO.email());
        return new AssigneeDTO(assignee);
    }

    @Transactional
    public void delete(Long id) {
        this.assigneeRepository.deleteById(id);
    }

    public AssigneeDTO get(Long id) {
        return this.assigneeRepository.findById(id).map(AssigneeDTO::new).orElse(null);
    }
}
