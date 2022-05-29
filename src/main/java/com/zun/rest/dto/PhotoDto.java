package com.zun.rest.dto;

import com.zun.domain.Photo;
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
public class PhotoDto {
    private int id;
    private String picture;
    public static Photo toDomainObject(PhotoDto photoDto, Theme theme) {
        ArrayList<Theme> themes = new ArrayList();
        themes.add(theme);
    return new Photo(photoDto.getId(), photoDto.getPicture(), themes);
}
    public static PhotoDto toDto(Photo photo) {

        return new PhotoDto(photo.getId(), photo.getPicture());
    }
}
