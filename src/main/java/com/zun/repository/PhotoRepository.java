package com.zun.repository;

import com.zun.domain.Photo;
import com.zun.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PhotoRepository extends JpaRepository<Photo,Integer> {
    @Modifying
    @Query("update Photo p set p.picture = :picture where p.id = :id")
    void updatePhotoById(@Param("id") int id,
                         @Param("picture") String picture);
    List<Photo> findByThemes(Theme theme);



}
