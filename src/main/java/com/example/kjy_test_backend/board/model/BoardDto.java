package com.example.kjy_test_backend.board.model;

import com.example.kjy_test_backend.comment.model.Comment;
import com.example.kjy_test_backend.comment.model.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {
    @Getter
    public static class BoardRegister {
        private String title;
        private String content;
        private String writer;
        List<Comment> comments = new ArrayList<>();

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardRegisterResponse {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private List<CommentDto.CommentResponse> comments;

        public static BoardRegisterResponse from(Board board) {
            return BoardRegisterResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .comments(board.getComments().stream().toList().stream().map(CommentDto.CommentResponse::from).collect(Collectors.toList()))
                    .build();
        }
    }
}
