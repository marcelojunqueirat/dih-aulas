package org.senai.dih.tasks.controller;

import jakarta.validation.Valid;
import org.senai.dih.tasks.model.transport.BoardDTO;
import org.senai.dih.tasks.model.transport.create.CreateBoardDTO;
import org.senai.dih.tasks.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardDTO> create(@RequestBody @Valid CreateBoardDTO body) {
        BoardDTO response = this.boardService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<BoardDTO>> list(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<BoardDTO> response = this.boardService.list(pageable);
        if (response.hasContent()) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDTO> update(@PathVariable("id") Long id, @RequestBody @Valid CreateBoardDTO body) {
        BoardDTO response = this.boardService.update(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.boardService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> get(@PathVariable("id") Long id) {
        BoardDTO response = this.boardService.get(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
