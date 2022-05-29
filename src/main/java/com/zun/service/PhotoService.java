package com.zun.service;

import com.zun.domain.Photo;
import com.zun.domain.Theme;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PhotoService {
    Photo insert(Photo photo);

    List<Photo> getAll();

    List<Photo> getByTheme(Theme theme);

    void deleteById(int id);

    Photo update(int id, String picture);
}


