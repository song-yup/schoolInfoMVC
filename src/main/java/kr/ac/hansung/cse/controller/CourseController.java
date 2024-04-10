package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.CourseSummary;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {

    // Controller -> Service -> Dao
    @Autowired
    private CourseService courseService;

    @GetMapping("/showcourses")
    public String showCourses(Model model) {
        List<CourseSummary> courseSummaries1 = courseService.getCourseSummaries();
        List<CourseSummary> courseSummaries2 = courseService.getAllScores();
        model.addAttribute("id_coursesummary", courseSummaries1);
        model.addAttribute("id_allscores", courseSummaries2);
        return "showcourses";
    }

    @GetMapping("/showdetailcourses/{year}/{semester}")
    public String showdetailCourses(@PathVariable("year") int year, @PathVariable("semester") int semester, Model model) {
        List<Course> courses = courseService.getCourseDescription(year, semester);
        model.addAttribute("id_courses", courses);
        return "showdetailcourses";
    }

    @GetMapping("/createcourses")
    public String createCourses(Model model) {

        model.addAttribute("course", new Course());

        return "createcourses";
    }

    @PostMapping("/docourses")
    public String doCourses(Model model, @Valid Course course, BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "createcourses";
        }

        courseService.insert(course);

        return "coursecreated";
    }

    @GetMapping("/showcreatedcourses")
    public String showCreatedcourses(Model model) {
        List<Course> courses = courseService.getNewcourses();

        model.addAttribute("id_newcourse", courses);

        return "showcreatedcourses";

    }
}