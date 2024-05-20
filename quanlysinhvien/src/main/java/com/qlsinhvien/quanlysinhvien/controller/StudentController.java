package com.qlsinhvien.quanlysinhvien.controller;

import com.qlsinhvien.quanlysinhvien.dto.StudentDTO;
import com.qlsinhvien.quanlysinhvien.entity.StudentEntity;
import com.qlsinhvien.quanlysinhvien.response.BaseResponse;
import com.qlsinhvien.quanlysinhvien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllStudent(){
        List<StudentDTO> students = studentService.getAllStudent();
        BaseResponse<List<StudentDTO>> response = new BaseResponse<>(200, "Lay danh sach thanh cong!", students);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewStudent(@RequestBody StudentEntity student){
        StudentEntity newStudent = studentService.addNewStudent(student);
        BaseResponse<StudentEntity> response = new BaseResponse<>(200, "Them moi thanh cong!", newStudent);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable int id, @RequestBody StudentEntity student){
        try {
            StudentEntity updatedStudent = studentService.updateStudent(id, student);
            BaseResponse<StudentEntity> response = new BaseResponse<>(200, "Cap nhat thanh cong!", updatedStudent);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(RuntimeException e){
            BaseResponse<StudentEntity> response = new BaseResponse<>(404, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        try {
            studentService.deleteStudent(id);
            BaseResponse<?> response = new BaseResponse<>(200, "Xoa thanh cong!", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(RuntimeException e){
            BaseResponse<?> response = new BaseResponse<>(404, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

}
