package couse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import couse.entities.Course;
import couse.entities.Lesson;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            File jsonFile = new File(
                    "C:\\Users\\okiss\\Desktop\\read-json\\devsuperior.couse\\src\\main\\resources\\file.json"
            );

            List<Course> courses = objectMapper.readValue(
                    jsonFile,
                    new TypeReference<List<Course>>() {}
            );

            for (Course course : courses) {
                System.out.println("Course Id: " + course.getId());
                System.out.println("Course Title: " + course.getTitle());

                List<Lesson> lessons = course.getLessons();

                for (Lesson lesson : lessons) {
                    System.out.println();
                    System.out.println("  id: " + lesson.getId());
                    System.out.println("  title: " + lesson.getTitle());
                    System.out.println("  media: " + lesson.getMedia());
                    System.out.println("  timestamp: " + lesson.getTimestamp());
                }

                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
