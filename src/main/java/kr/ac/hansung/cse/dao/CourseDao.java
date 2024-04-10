package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.CourseSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CourseSummary> getCourseSummaries() {
        String sqlStatement = "select year, semester, sum(score) as totalScore from courses group by year, semester order by year asc, semester asc";
        return jdbcTemplate.query(sqlStatement, new RowMapper<CourseSummary>() {

            @Override
            public CourseSummary mapRow(ResultSet rs, int rowNum) throws SQLException {

                CourseSummary courseSummary= new CourseSummary();

                courseSummary.setYear(rs.getInt("year"));
                courseSummary.setSemester(rs.getInt("semester"));
                courseSummary.setTotalScore(rs.getInt("totalScore"));

                return courseSummary;
            }
        });
    }

    public List<CourseSummary> getAllScoreCourses () {
        String sqlStatement = "select sum(totalScore) as alltotalScore " +
                "from (select year, semester, sum(score) as totalScore from courses group by year, semester order by year asc, semester asc) " +
                "as subquery";
        return jdbcTemplate.query(sqlStatement, new RowMapper<CourseSummary>() {

            @Override
            public CourseSummary mapRow(ResultSet rs, int rowNum) throws SQLException {

                CourseSummary courseSummary= new CourseSummary();

                courseSummary.setAlltotalScore(rs.getInt("alltotalScore"));

                return courseSummary;
            }
        });
    }

    public List<Course> getDetailcourse(int year, int semester) {
        String sqlStatement = "select * from courses where year = ? and semester = ?";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course= new Course();

                course.setId(rs.getString("id"));
                course.setName(rs.getString("name"));
                course.setClassification(rs.getString("classification"));
                course.setScore(rs.getInt("score"));
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setProfessor(rs.getString("professor"));

                return course;
            }
        }, year, semester);
    }

    public boolean insert(Course course) {

        String id = course.getId();
        String name = course.getName();
        String classification = course.getClassification();
        int score = course.getScore();
        int year = course.getYear();
        int semester = course.getSemester();
        String professor = course.getProfessor();

        String sqlStatement = "insert into courses (id, name, classification, score, year, semester, professor) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {id, name, classification, score, year, semester, professor}) == 1);
    }

    public List<Course> getNewcourse() {
        String sqlStatement = "select * from courses where year = 2024 and semester = 2";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course= new Course();

                course.setId(rs.getString("id"));
                course.setName(rs.getString("name"));
                course.setClassification(rs.getString("classification"));
                course.setScore(rs.getInt("score"));
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setProfessor(rs.getString("professor"));

                return course;
            }
        });
    }
}
