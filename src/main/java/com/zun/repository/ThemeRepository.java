package com.zun.repository;

import com.zun.domain.Theme;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    @Override
    @EntityGraph(attributePaths = {"user", "commentList", "gender_id", "content", "status"})
    List<Theme> findAll();

    List<Theme> findByName(String name);
}
