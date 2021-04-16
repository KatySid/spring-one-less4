package ru.geekbrains.spring.one.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.one.model.Student;
import ru.geekbrains.spring.one.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findOneById(Long id) {
        return studentRepository.findOneById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


    public void incScore (Long id) {
        Student s = studentRepository.findOneById(id).get();
        int score = s.getScore();
        if (score > 0) {
            s.setScore(score-1);
        }
    }

    public void decScore (Long id) {
        Student s = studentRepository.findOneById(id).get();
        int score = s.getScore();
        if (score < 100) {
            s.setScore(score+1);
        }
    }
}
