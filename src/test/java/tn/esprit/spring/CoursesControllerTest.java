package tn.esprit.spring;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.spring.controllers.CourseRestController;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.services.CourseServicesImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CoursesControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private CourseServicesImpl courseServices;

    @InjectMocks
    private CourseRestController courseRestController;

    Course RECORD_1 = new Course(1L, 1, TypeCourse.INDIVIDUAL, Support.SKI, 1.3F, 1);
    Course RECORD_2 = new Course(2L, 2, TypeCourse.COLLECTIVE_CHILDREN, Support.SNOWBOARD, 4F, 2);
    Course RECORD_3 = new Course(3L, 3, TypeCourse.COLLECTIVE_ADULT, Support.SKI, 30.3F, 3);


//    @Before("")
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(courseRestController).build();
//    }

    @Test
    public void getAllRecords_success() throws Exception {
        List<Course> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(courseServices.retrieveAllCourses()).thenReturn(records);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(courseRestController).build();


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/course/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(records.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].level").value(2));
    }

    @Test
    public void getCourseById_success() throws Exception {
        Mockito.when(courseServices.retrieveCourse(RECORD_1.getNumCourse())).thenReturn(RECORD_1);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(courseRestController).build();

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/course/get/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.level").value(1));

    }


    @Test
    public void createRecord_success() throws Exception {
        Course course = new Course(1L, 1, TypeCourse.INDIVIDUAL, Support.SKI, 1.3F, 1);

        Mockito.when(courseServices.addCourse(Mockito.any(Course.class))).thenReturn(course);


        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(courseRestController).build();
        String content = objectWriter.writeValueAsString(course);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/course/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.level").value(1));
    }


    @Test
    public void testUpdateCourse() throws Exception {
        Course course = new Course(1L, 1, TypeCourse.INDIVIDUAL, Support.SKI, 1.3F, 1);

        Mockito.when(courseServices.updateCourse(Mockito.any(Course.class))).thenReturn(course);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(courseRestController).build();

        mockMvc.perform(MockMvcRequestBuilders.put("/course/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(course)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
