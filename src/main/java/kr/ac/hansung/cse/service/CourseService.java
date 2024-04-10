package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.CourseSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    // Service -> Dao
    @Autowired
    private CourseDao courseDao;

    public List<CourseSummary> getCourseSummaries() {
        return courseDao.getCourseSummaries();
    }

    public List<CourseSummary> getAllScores() {
        return courseDao.getAllScoreCourses();
    }

    public List<Course> getCourseDescription(int year, int semester) {
        return courseDao.getDetailcourse(year, semester);
    }

    public void insert(Course course) {
        courseDao.insert(course);
    }

    public List<Course> getNewcourses() {
        return courseDao.getNewcourse();
    }
}
