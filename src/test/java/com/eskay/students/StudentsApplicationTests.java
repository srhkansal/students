package com.eskay.students;

import com.eskay.students.controllers.StudentsController;
import com.eskay.students.entity.StudentsEntity;
import com.eskay.students.services.StudentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentsController.class)
public class StudentsApplicationTests {

	@MockBean
	private StudentsService studentsService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testMethos() throws Exception {

		StudentsEntity ste = new StudentsEntity();
		ste.setId(2);
		ste.setRollNumber("2");
		ste.setFirstName("SK");
		ste.setLastName("Lastr");
		ste.setDateOfBirth("wwww");
		ste.setGrade("6");

		String exampleCourseJson = "{\n" +
				"  \"id\": 2,\n" +
				"  \"rollNumber\": \"2\",\n" +
				"  \"firstName\": \"SK\",\n" +
				"  \"lastName\": \"Lastr\",\n" +
				"  \"dateOfBirth\": \"wwww\",\n" +
				"  \"grade\": \"6\"\n" +
				"}";

		Mockito.when(studentsService.getStudent(Mockito.anyInt())).thenReturn(ste);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(exampleCourseJson, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testMethod_new() throws Exception {

		StudentsEntity ste = new StudentsEntity();
		ste.setId(2);
		ste.setRollNumber("2");
		ste.setFirstName("SK");
		ste.setLastName("Lastr");
		ste.setDateOfBirth("wwww");
		ste.setGrade("6");

		String exampleCourseJson = "{\n" +
				"  \"id\": 2,\n" +
				"  \"rollNumber\": \"2\",\n" +
				"  \"firstName\": \"SK\",\n" +
				"  \"lastName\": \"Lastr\",\n" +
				"  \"dateOfBirth\": \"wwww\",\n" +
				"  \"grade\": \"6\"\n" +
				"}";

		Mockito.when(studentsService.getStudent(Mockito.anyInt())).thenReturn(ste);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/studentsnew/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(exampleCourseJson, result.getResponse().getContentAsString(), false);
	}
}
