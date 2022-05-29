package com.zun.rest.dto;

import com.zun.domain.Comment;
import com.zun.domain.Photo;
import com.zun.domain.Theme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDto {
    private int id;
    private String name;
    private int gender_id;
    private UserDto userDto;
    private String content;
    private int status;
    private List<CommentDto> commentDtoList;

    private List<PhotoDto> photoDtoList;

    public static Theme toDomainObject(ThemeDto themeDto, List<Comment> comments,
                                       List<Photo> photos) {
        return new Theme(
                themeDto.getId(),
                themeDto.getName(),
                UserDto.toDomainObject(themeDto.getUserDto()),
                comments,
                themeDto.getGender_id(),
                themeDto.getContent(),
                themeDto.getStatus(),
                photos);
    }
    public static ThemeDto toDto(Theme theme){
        List<CommentDto> commentDtoList1;
        List<PhotoDto> photoDtoList1;

        if(theme.getCommentList()!=null){
            commentDtoList1 = theme.getCommentList()
                    .stream()
                    .map(CommentDto::toDto)
                    .collect(Collectors.toList());
        }else{
            commentDtoList1 = new ArrayList<>();
        }
//        if(theme.getPhotos()!=null){
//            photoDtoList1 = theme.getPhotos()
//                    .stream()
//                    .map(PhotoDto::toDto)
//                    . collect(Collectors.toList());
//        }else{
            photoDtoList1 = new ArrayList<>();
//        }
        return  new ThemeDto(
                theme.getId(),
                theme.getName(),
                theme.getGender_id(),
                UserDto.toDto(theme.getUser()),
                theme.getContent(),
                theme.getStatus(),
                commentDtoList1,photoDtoList1);
    }
}
