package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.service.StudentGroupService;
import ru.gb.oseminar.service.StudentService;
import ru.gb.oseminar.service.TeacherService;
import ru.gb.oseminar.view.StudentView;
import ru.gb.oseminar.view.TeacherView;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class TeacherController implements UserController<Teacher>{
    private final TeacherService dataService = new TeacherService();
//    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final TeacherView teacherView = new TeacherView();

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        dataService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(dataService.getAll());
    }

    public void teacherAmend(Teacher currentTeacher, Teacher newTeacher){
        for(Teacher elem : dataService.getAll()){
            if(elem.equals(currentTeacher)){
                elem.setFirstName(newTeacher.getFirstName());
                elem.setSecondName(newTeacher.getSecondName());
                elem.setPatronymic(newTeacher.getPatronymic());
                elem.setDateOfBirth(newTeacher.getDateOfBirth());
            }
        }
    }
    
    public void showAllTeachers(){
        System.out.println(dataService.getAll());
    }
}
