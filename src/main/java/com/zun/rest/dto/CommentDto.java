package com.zun.rest.dto;


import com.zun.domain.Comment;
import com.zun.domain.Theme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private int id;

    private String context;

    public static Comment toDomainObject(CommentDto commentDto, Theme theme) {

        return new Comment(commentDto.getId(), commentDto.getContext(),theme);
    }

    public static CommentDto toDto(Comment comment) {

        return new CommentDto(comment.getId(), comment.getContext());
    }

}