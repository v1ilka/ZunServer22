package com.zun.service;

import com.zun.domain.Photo;
import com.zun.domain.Theme;
import com.zun.repository.PhotoRepository;

import java.util.List;

public class PhotoServiceImpl implements PhotoService {
    private PhotoRepository photoRepository;

    @Override
    public Photo insert(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public List<Photo> getAll() {
        return photoRepository.findAll();
    }


    @Override
    public List<Photo> getByTheme(Theme themeId) {
        return photoRepository.findByThemes(themeId);
    }

    @Override
    public void deleteById(int id) {
        photoRepository.deleteById(id);
    }

    @Override
    public Photo update(int id, String picture) {
        return photoRepository.save(Photo.builder()
                .id(id).picture(picture).build());
    }
}
