package com.example.kjy_test_backend.board;

import com.example.kjy_test_backend.board.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
