package com.Hogwards.school.service;

import com.Hogwards.school.model.Faculty;
import com.Hogwards.school.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    HashMap<Long, Faculty> faculties = new HashMap<>();

    private Long count = 0l;


    public Faculty create(Faculty faculty) {
        faculty.setId(count++);
        faculties.put(count, faculty);
        return faculty;
    }

    public Faculty read(Long id) {
        return faculties.get(id);
    }

    public Faculty update(Long id, Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty delete(Long id) {
        return faculties.remove(id);
    }

    public Collection<Faculty> getByColor(String color) {
        return faculties.values().stream()
                .filter(faculty -> faculty.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}
