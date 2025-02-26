package com.example.kjy_test_backend.board;

import com.example.kjy_test_backend.board.model.BoardDto;
import com.example.kjy_test_backend.board.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<BoardDto.BoardRegisterResponse> register(@RequestBody BoardDto.BoardRegister dto) {
        BoardDto.BoardRegisterResponse response = boardService.register(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardListResponse>> list(int page, int size) {
        List<BoardDto.BoardListResponse> response = boardService.list(page, size);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{boardIdx}")
    public ResponseEntity<BoardDto.BoardReadResponse> read(@PathVariable Long boardIdx) {
        BoardDto.BoardReadResponse response = boardService.read(boardIdx);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{boardIdx}/register")
    public ResponseEntity<CommentDto.CommentResponse> registerComment(@RequestBody CommentDto.CommentRegister dto, @PathVariable Long boardIdx){
        CommentDto.CommentResponse response = boardService.registerComment(dto, boardIdx);
        return ResponseEntity.ok(response);
    }
}
