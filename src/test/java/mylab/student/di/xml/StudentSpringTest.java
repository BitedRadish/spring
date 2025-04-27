package mylab.student.di.xml;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {

//    type을 base로 bean 탐색
    @Autowired
    Course course;

    @Resource(name = "gradeService")
    GradeService service;

    @Test
    void testService(){
        assertNotNull(service);
        assertEquals("C01",service.getCourse().getCourseId());
//        for(Student student:course.getStudents())
        assertEquals("A",service.calculateGrade("S01"));
        assertEquals(2,service.getHighScoreStudents(80).size());
        for(Student student: service.getHighScoreStudents(80)){
            System.out.println(student);
        }
    }

    @Test @Disabled
    void testCourse(){
        assertNotNull(course);
        assertEquals("JAVA Programming",course.getCourseName());
        assertEquals("EMMA",course.getStudents().get(0).getName());

        System.out.println(course.getAverageScore());
//        delta
        assertEquals(76.6,course.getAverageScore(),0.1);
    }


}
