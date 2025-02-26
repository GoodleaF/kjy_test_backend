package com.example.kjy_test_backend.board;

import com.example.kjy_test_backend.board.model.BoardDto;
import com.example.kjy_test_backend.board.model.CommentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Operation(
            summary = "새 게시글 등록",
            description = "게시글 제목, 내용, 작성자를 입력하여 등록"
    )
    @PostMapping("/register")
    public ResponseEntity<BoardDto.BoardRegisterResponse> register(@RequestBody BoardDto.BoardRegister dto) {
        BoardDto.BoardRegisterResponse response = boardService.register(dto);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "게시글 목록 출력",
            description = "게시글 번호, 제목, 작성자, 댓글의 수를 출력"
    )
    @GetMapping("/list")
    public ResponseEntity<BoardDto.BoardListPageResponse> list(@RequestParam int page, @RequestParam int size) {
        BoardDto.BoardListPageResponse response = boardService.list(page, size);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "게시글 상세 내용 출력",
            description = "게시글 제목, 내용, 작성자, 댓글 목록을 출력"
    )
    @GetMapping("/{boardIdx}")
    public ResponseEntity<BoardDto.BoardReadResponse> read(@PathVariable Long boardIdx) {
        BoardDto.BoardReadResponse response = boardService.read(boardIdx);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "새 댓글 등록",
            description = "댓글 내용, 작성자를 입력하여 등록"
    )
    @PostMapping("/{boardIdx}/register")
    public ResponseEntity<CommentDto.CommentResponse> registerComment(@RequestBody CommentDto.CommentRegister dto, @PathVariable Long boardIdx){
        CommentDto.CommentResponse response = boardService.registerComment(dto, boardIdx);
        return ResponseEntity.ok(response);
    }
}
