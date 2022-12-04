package my.dhlee;

import my.dhlee.dao.ApplicationDao;
import my.dhlee.models.CollegeStudent;
import my.dhlee.models.StudentGrades;
import my.dhlee.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = TeststudyApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

//    @Mock
    @MockBean
    public ApplicationDao applicationDao;

//    @InjectMocks
    @Autowired
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
    
    @DisplayName("Find Gpa")
    @Test
    void assertEqualsTestFindGpa() throws Exception {
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults()))
                .thenReturn(88.31);

        assertEquals(88.31, applicationService.findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Not null")
    @Test
    void testAssertNotNull() throws Exception {
        when(applicationDao.checkNull(studentGrades.getMathGradeResults()))
                .thenReturn(true);

        assertNotNull(applicationService.checkNull(studentOne.getStudentGrades().getMathGradeResults()), "Object should not be null");
    }
}
