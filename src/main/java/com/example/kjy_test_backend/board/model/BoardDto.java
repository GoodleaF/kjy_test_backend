package com.example.kjy_test_backend.board.model;

import com.example.kjy_test_backend.comment.model.Comment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
}
