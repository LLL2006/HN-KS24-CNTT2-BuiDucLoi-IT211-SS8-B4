package com.re.ss8b4.service;

import com.re.ss8b4.entity.LessonVideo;
import com.re.ss8b4.exception.AccessDeniedException;
import com.re.ss8b4.exception.ResourceNotFoundException;
import com.re.ss8b4.repository.LessonVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonVideoRepository lessonVideoRepository;

    public String watchLesson(Long lessonId, String username) {

        LessonVideo lesson =
                lessonVideoRepository.findById(lessonId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Lesson video not found"
                                )
                        );

        if (!lesson.getIsFree()) {

            boolean purchased = false;

            if (!purchased) {
                throw new AccessDeniedException(
                        "You have not purchased this course yet."
                );
            }
        }

        return lesson.getVideoUrl();
    }
}
