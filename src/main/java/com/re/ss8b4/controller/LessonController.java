package com.re.ss8b4.controller;

import com.re.ss8b4.service.LessonService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
@Validated
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/watch")
    public Map<String, Object> watchLesson(
            @RequestHeader("X-User") String username,

            @RequestParam
            @Min(value = 1,
                    message = "lessonId phải lớn hơn 0")
            Long lessonId
    ) {

        String videoUrl =
                lessonService.watchLesson(lessonId, username);

        Map<String, Object> map = new HashMap<>();

        map.put("message", "Lấy video thành công");
        map.put("videoUrl", videoUrl);

        return map;
    }
}
