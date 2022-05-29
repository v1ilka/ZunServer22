package com.zun.service;

import com.zun.domain.Theme;
import com.zun.domain.User;
import com.zun.repository.ThemeRepository;
import com.zun.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService{
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ThemeRepository themeRepository;

    @Override
    public Theme insert(String nameTheme, String nameUser) {
        User user = userRepository.findByName(nameUser);
        if(user == null){
            user = User.builder().name(nameUser).build();
        }
        Theme theme = Theme.builder()
                .name(nameTheme)
                .user(user)
                .build();
        return themeRepository.save(theme);
    }

    @Override
    public Theme insert(String nameTheme, String nameUser, int intGender, String contentName) {
        return null;
    }

    @Override
    public Theme update(int id, String nameTheme, String nameUser, int intGender, String contentName) {
        return null;
    }

    @Override
    public Theme insert(String nameTheme, String nameUser, String nameGender, String contentName) {
        return null;
    }

    @Override
    public Theme update(int id, String nameTheme, String nameUser, String nameGender, String contentName) {
        return null;
    }

    @Override
    public Theme update(int id, String nameTheme, String nameUser) {
        User user = userRepository.findByName(nameUser);
        if (user == null){
            user = User.builder().name(nameUser).build();
        }
        Theme theme = Theme.builder()
                .id(id)
                .name(nameTheme)
                .user(user)
                .build();
        return themeRepository.save(theme);
    }

    @Override
    public List<Theme> getAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme getById(int id) {
        return themeRepository.getById(id);
    }

    @Override
    public List<Theme> getByName(String nameTheme) {
        return themeRepository.findByName(nameTheme);
    }

    @Override
    public void deleteById(int id) {
    themeRepository.deleteById(id);
    }
}
