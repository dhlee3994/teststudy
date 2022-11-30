package my;

import my.dhlee.TeststudyApplication;
import my.dhlee.models.CollegeStudent;
import my.dhlee.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TeststudyApplication.class)
public class ApplicationExampleTest {

    private static int count = 0;

    @Value("${info.school.name}")
    private String schoolName;
    @Value("${info.app.name}")
    private String appInfo;
    @Value("${info.app.description}")
    private String appDescription;
    @Value("${info.app.version}")
    private String appVersion;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    void beforeEach() {
        System.out.println("Testing: " + appInfo + " which is " + appDescription +
                " Version: " + appVersion + ". Execution of test method " + ++count);

        student.setFirstname("DongHyeon;");
        student.setLastname("Lee");
        student.setEmailAddress("dhlee3994@gmail.com");
        studentGrades.setMathGradeResults(List.of(100.0, 85.0, 76.50, 91.75));
        student.setStudentGrades(studentGrades);
    }

    @DisplayName("Add grade results for student grades")
    @Test
    void addGradeResultsForStudentGrades() {
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Add grade results for student grades not equal")
    @Test
    void addGradeResultsForStudentGradesAssertNotEquals() {
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Is grade greater")
    @Test
    void isGradeGreaterStudenGrades() {
        assertTrue(studentGrades.isGradeGreater(90, 75), "failure - should be true");
    }

    @DisplayName("Is grade greater false")
    @Test
    void isGradeGreaterStudentGradesAssertFalse() {
        assertFalse(studentGrades.isGradeGreater(70, 75), "failure - should be false");
    }

    @DisplayName("Check Null for student grades")
    @Test
    void checkNullForStudentGrades() {
        assertNotNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()), "object should not be null");
    }

    @DisplayName("Create student without grade init")
    @Test
    void createStudentWithourGradesInit() {
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);
        studentTwo.setFirstname("Chad");
        studentTwo.setLastname("Darby");
        studentTwo.setEmailAddress("chad.darby@abcd.abc");

        assertNotNull(studentTwo.getFirstname());
        assertNotNull(studentTwo.getLastname());
        assertNotNull(studentTwo.getEmailAddress());

        assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
    }

    @DisplayName("Verify students are prototypes")
    @Test
    void verifyStudentsArePrototypes() throws Exception {
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);

        assertNotSame(student, studentTwo);
    }

    @DisplayName("Find Grade Point Average")
    @Test
    void findGradePointAverage() throws Exception {
        assertAll("Testing all assertEquals",
                () -> assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults())),
                () -> assertEquals(88.31, studentGrades.findGradePointAverage(student.getStudentGrades().getMathGradeResults())));
    }

    @Test
    void basicTest() {

    }
}
