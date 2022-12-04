package my.dhlee;

import my.dhlee.models.CollegeStudent;
import my.dhlee.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TeststudyApplication.class)
public class ReflectionTestUtilsTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    void beforeEach() {
        studentOne.setFirstname("DongHyeon");
        studentOne.setLastname("Lee");
        studentOne.setEmailAddress("dhlee3994@gmail.com");
        studentOne.setStudentGrades(studentGrades);

        ReflectionTestUtils.setField(studentOne, "id", 1);
        ReflectionTestUtils.setField(studentOne, "studentGrades", new StudentGrades(List.of(100.0, 85.0, 76.50, 91.75)));
    }

    @DisplayName("Get private field")
    @Test
    void getPrivateField() throws Exception {
        assertEquals(1, ReflectionTestUtils.getField(studentOne, "id"));
    }

    @DisplayName("Invoke private method")
    @Test
    void invokePrivateMethod() throws Exception {
        assertEquals("DongHyeon 1", ReflectionTestUtils.invokeMethod(studentOne, "getFirstNameAndId"));
    }
}
