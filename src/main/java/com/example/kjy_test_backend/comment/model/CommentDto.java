package com.example.kjy_test_backend.comment.model;

import com.example.kjy_test_backend.board.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

public class CommentDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentRegister {
        private String content;
        private String writer;

        public Comment toEntity(Board board) {
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .board(board)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentResponse {
        private Long idx;
        private String content;
        private String writer;

        public static CommentResponse from(Comment comment) {
            return CommentResponse.builder()
                    .idx(comment.getIdx())
                    .content(comment.getContent())
                    .writer(comment.getWriter())
                    .build();
        }

    }
}
