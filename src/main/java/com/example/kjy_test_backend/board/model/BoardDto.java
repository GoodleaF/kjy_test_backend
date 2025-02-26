package com.example.kjy_test_backend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {
    @Getter
    public static class BoardRegister {
        private String title;
        private String content;
        private String writer;

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

        public static BoardRegisterResponse from(Board board) {
            return BoardRegisterResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardListResponse {
        private Long idx;
        private String title;
        private String writer;
        private List<CommentDto.CommentResponse> comments;

        public static BoardListResponse from(Board board) {
            return BoardListResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .comments(board.getComments().stream().toList().stream().map(CommentDto.CommentResponse::from).collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoardReadResponse {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private List<CommentDto.CommentResponse> comments;

        public static BoardReadResponse from(Board board) {
            return BoardReadResponse.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .comments(board.getComments().stream().toList().stream().map(CommentDto.CommentResponse::from).collect(Collectors.toList()))
                    .build();
        }
    }
}
