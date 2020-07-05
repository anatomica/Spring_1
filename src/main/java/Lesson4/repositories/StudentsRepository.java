package Lesson4.repositories;

import Lesson4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    Student findOneByName(String name);
    List<Student> findAllByScoreGreaterThan(int minScore);
}