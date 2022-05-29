package com.zun.service;

import com.zun.domain.Comment;
import com.zun.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Comment insert(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByThemeId(int themeId) {
        return commentRepository.findByThemeId(themeId);
    }

    @Override
    public void deleteById(int id) {
commentRepository.deleteById(id);
    }

    @Override
    public Comment update(int id, String context) {
        return commentRepository.save(Comment.builder()
                .id(id).context(context).build());
    }
}
