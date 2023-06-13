package MyProjects.Cinema.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;

import MyProjects.Cinema.App;
import MyProjects.Cinema.Service.MovieService;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = App.class)
public class test_MovieController {
@MockBean
MovieService movieService;
@MockBean
ModelMap model;
@Autowired
MockMvc mockMvc;




}
