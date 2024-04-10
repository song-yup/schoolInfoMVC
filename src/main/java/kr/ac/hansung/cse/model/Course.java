package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    @Size(min=6, max=8, message = "ID must be between 6 and 8 chars")
    private String id;

    @Size(min=2, max=10, message = "Name must be between 2 and 10 chars")
    private String name;

    @Size(min=2, max=2, message = "Classification must be 2 chars")
    private String classification;

    @Min(value = 2, message = "Score must be between 2 and 3")
    @Max(value = 3, message = "Score must be between 2 and 3")
    private int score;

    @Min(value = 2024, message = "Year must be 2024")
    @Max(value = 2024, message = "Year must be 2024")
    private int year;

    @Min(value = 2, message = "Semester must be 2")
    @Max(value = 2, message = "Semester must be 2")
    private int semester;

    @Size(min = 2, max = 8, message = "Professor must be between 2 and 8")
    private String professor;

}
