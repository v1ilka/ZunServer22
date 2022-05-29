package com.zun.rest.controller;

import com.zun.domain.Comment;
import com.zun.domain.Theme;
import com.zun.rest.dto.CommentDto;
import com.zun.service.CommentService;
import com.zun.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final ThemeService themeService;

    @PostMapping("/comment")
    public CommentDto createNewComment(
            @RequestParam String context,
            @RequestParam int themeId
    ) {
        Theme theme = themeService.getById(themeId);
        Comment comment = Comment.builder().context(context)
                .theme(theme).build();
        commentService.insert(comment);

        return CommentDto.toDto(comment);
    }

    @GetMapping("/comment")
    public List<CommentDto> getAllComments() {

        return commentService
                .getAll()
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/comment/{id}/context")
    public void updateCommentById(
            @PathVariable int id,
            @RequestParam String context
    ) {

        commentService.update(id, context);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteCommentById(@PathVariable int id) {

        commentService.deleteById(id);
    }

    @GetMapping("/theme/{id}/comment")
    public List<CommentDto> getCommentsByThemeId(@PathVariable int id) {

        return commentService
                .getByThemeId(id)
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }
}