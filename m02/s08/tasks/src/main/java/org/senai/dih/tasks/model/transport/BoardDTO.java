package org.senai.dih.tasks.model.transport;

import jakarta.validation.constraints.NotBlank;
import org.senai.dih.tasks.model.Board;

import java.time.LocalDateTime;

public record BoardDTO(Long id, String name, String description, LocalDateTime createdAt) {

    public BoardDTO(Board board) {
        this(board.getId(), board.getName(), board.getDescription(), board.getCreatedAt());
    }
}
