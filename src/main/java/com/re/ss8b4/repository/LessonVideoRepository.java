package com.re.ss8b4.repository;

import com.re.ss8b4.entity.LessonVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonVideoRepository
        extends JpaRepository<LessonVideo, Long> {
}