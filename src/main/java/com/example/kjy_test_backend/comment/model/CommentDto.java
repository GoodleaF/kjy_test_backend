package com.example.kjy_test_backend.comment.model;

import com.example.kjy_test_backend.board.model.Board;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CommentDto {
    @Getter
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
}
