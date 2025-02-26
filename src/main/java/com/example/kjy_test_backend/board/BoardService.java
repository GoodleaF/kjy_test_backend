package com.example.kjy_test_backend.board;

import com.example.kjy_test_backend.board.model.Board;
import com.example.kjy_test_backend.board.model.BoardDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.BoardRegisterResponse register(BoardDto.BoardRegister dto) {
        Board board = boardRepository.save(dto.toEntity());

        return BoardDto.BoardRegisterResponse.from(board);
    }

    public List<BoardDto.BoardListResponse> list(int page, int size) {
        List<Board> boardList = boardRepository.findAll();

        return boardList.stream().map(BoardDto.BoardListResponse::from).collect(Collectors.toList());
    }

    public BoardDto.BoardReadResponse read(Long boardIdx) {
        Board board = boardRepository.findById(boardIdx).orElseThrow();
        return BoardDto.BoardReadResponse.from(board);
    }
}
