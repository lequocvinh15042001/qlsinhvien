package com.qlsinhvien.quanlysinhvien.service;

import com.qlsinhvien.quanlysinhvien.dto.StudentDTO;
import com.qlsinhvien.quanlysinhvien.entity.StudentEntity;
import com.qlsinhvien.quanlysinhvien.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudent(){

        List<StudentEntity> studentEntities = studentRepository.findAll();

        List<StudentDTO> studentDTOS = new ArrayList<>();

        studentEntities.forEach(item -> {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setMaSV(item.getId());
            studentDTO.setTenSV(item.getName());
            studentDTO.setEmailSV(item.getEmail());
            studentDTO.setNgaySinh(item.getDob());

            studentDTOS.add(studentDTO);
        });

        return studentDTOS;

    }

    public StudentEntity addNewStudent(StudentEntity student){

        return studentRepository.save(student);

    }

    public StudentEntity updateStudent(int id, StudentEntity studentEntity){
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);

        if(optionalStudentEntity.isPresent()){
            StudentEntity student = optionalStudentEntity.get();
            student.setName(studentEntity.getName());
            student.setEmail(studentEntity.getEmail());
            student.setDob(studentEntity.getDob());

            student = studentRepository.save(student);
            studentEntity.setId(student.getId());
            return studentEntity;
        }else {
            throw new RuntimeException("Sinh vien khong ton tai voi id = " + id);
        }
    }

    public void deleteStudent(int id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else {
            throw new RuntimeException("Sinh vien khong ton tai voi id = " + id);
        }
    }

}
