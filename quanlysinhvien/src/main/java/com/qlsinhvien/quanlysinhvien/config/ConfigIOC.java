package com.qlsinhvien.quanlysinhvien.config;

import com.qlsinhvien.quanlysinhvien.entity.StudentEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigIOC {

    @Bean("student")
    public StudentEntity createStudent(){
        StudentEntity student = new StudentEntity();

        return student;
    }

}
