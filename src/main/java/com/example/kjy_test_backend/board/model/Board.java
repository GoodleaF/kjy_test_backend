package com.example.kjy_test_backend.board.model;

import com.example.kjy_test_backend.comment.model.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String content;
    private String writer;

    @OneToMany(mappedBy = "board")
    private List<Comment> sectionList = new ArrayList<>();
}
