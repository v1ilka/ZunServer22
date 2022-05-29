package com.zun.rest.controller;

import com.zun.domain.Theme;
import com.zun.rest.dto.ThemeDto;
import com.zun.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ThemeController {
    private final ThemeService themeService;
    @GetMapping("/theme")
    public List<ThemeDto> getAllTheme(){
        List<ThemeDto> themeDtoList = themeService.getAll().stream()
                .map(ThemeDto::toDto)
                .collect(Collectors.toList());
        return themeDtoList;
    }


    @PostMapping("/theme")
    public ThemeDto insertTheme(
            @RequestParam String nameTheme,
            @RequestParam String nameUser,
            @RequestParam String nameGender,
            @RequestParam String contentName) {
        Theme theme = themeService.insert(nameTheme, nameUser, nameGender, contentName);
            return  ThemeDto.toDto(theme);

    }
    @PutMapping("/theme/{id}")
    public ThemeDto updateTheme(@PathVariable int id,
                                @RequestParam String nameTheme,
                                @RequestParam String nameUser,
                                @RequestParam String nameGender,
                                @RequestParam String contentName) {
        Theme theme = themeService.insert(nameTheme, nameUser, nameGender, contentName);
        return  ThemeDto.toDto(theme);
    }

    @GetMapping("/theme{id}")
    public  ThemeDto getThemeById(@PathVariable int id){
        return  ThemeDto.toDto(themeService.getById(id));
    }

        @DeleteMapping("/theme{id}")
            public  void deleteTheme(@PathVariable int id){
        themeService.deleteById(id);
        }



}
