package com.zun.service;

import com.zun.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment insert(Comment comment);

    List<Comment>  getAll();

    List<Comment> getByThemeId(int themeId);
    void deleteById(int id);
    Comment update(int id, String context);
}
