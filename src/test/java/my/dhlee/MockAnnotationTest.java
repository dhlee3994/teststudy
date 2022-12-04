package my.dhlee;

import my.dhlee.dao.ApplicationDao;
import my.dhlee.models.CollegeStudent;
import my.dhlee.models.StudentGrades;
import my.dhlee.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = TeststudyApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @Mock
    public ApplicationDao applicationDao;

    @InjectMocks
    public ApplicationService applicationService;


    @BeforeEach
    void beforeEach() {
        studentOne.setFirstname("DongHyeon");
        studentOne.setLastname("Lee");
        studentOne.setEmailAddress("dhlee3994@gmail.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & Verify")
    @Test
    void assertEqualTestAddGrades() throws Exception {
        when(applicationDao.addGradeResultsForSingleClass(
                                    studentGrades.getMathGradeResults())).thenReturn(100.00);

        assertEquals(100, applicationService.addGradeResultsForSingleClass(
                                    studentOne.getStudentGrades().getMathGradeResults()));

        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }
}
