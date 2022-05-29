package com.zun.service;

import com.zun.domain.Theme;

import java.util.List;

public interface ThemeService {
    Theme insert(String nameTheme, String nameUser);

    Theme insert(String nameTheme,
                 String nameUser,
                 int intGender,
                 String contentName);
    Theme update(int id,String nameTheme,
                 String nameUser,
                 int intGender,
                 String contentName);

    Theme insert(String nameTheme, String nameUser, String nameGender, String contentName);

    Theme update(int id, String nameTheme, String nameUser, String nameGender, String contentName);

    Theme update(int id, String nameTheme, String nameUser);

    List<Theme> getAll();

    Theme getById(int id);

    List<Theme> getByName(String nameTheme);

    void deleteById(int id);
}
