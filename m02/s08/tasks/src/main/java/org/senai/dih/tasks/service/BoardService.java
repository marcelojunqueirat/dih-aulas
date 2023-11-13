package org.senai.dih.tasks.service;

import jakarta.transaction.Transactional;
import org.senai.dih.tasks.model.Board;
import org.senai.dih.tasks.model.transport.BoardDTO;
import org.senai.dih.tasks.model.transport.create.CreateBoardDTO;
import org.senai.dih.tasks.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public BoardDTO create(CreateBoardDTO boardDTO) {
        Board newBoard = new Board(boardDTO);
        Board response = this.boardRepository.save(newBoard);
        return new BoardDTO(response);
    }

    public Page<BoardDTO> list(Pageable pageable) {
        return this.boardRepository.findAll(pageable).map(BoardDTO::new);
    }

    @Transactional
    public BoardDTO update(Long id, CreateBoardDTO boardDTO) {
        Board board = this.boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board with id not found: " + id));

        board.setName(boardDTO.name());
        board.setDescription(boardDTO.description());
        return new BoardDTO(board);
    }

    @Transactional
    public void delete(Long id) {
        this.boardRepository.deleteById(id);
    }

    public BoardDTO get(Long id) {
        return this.boardRepository.findById(id).map(BoardDTO::new).orElse(null);
    }
}
