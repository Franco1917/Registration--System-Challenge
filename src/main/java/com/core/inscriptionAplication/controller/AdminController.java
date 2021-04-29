package com.core.inscriptionAplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.core.inscriptionAplication.entity.Subject;
import com.core.inscriptionAplication.entity.Teacher;
import com.core.inscriptionAplication.entity.User;
import com.core.inscriptionAplication.service.SubjectService;
import com.core.inscriptionAplication.service.TeacherService;
import com.core.inscriptionAplication.service.UserService;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired 
	UserService userService;
	
	@Autowired
	SubjectService subjectservice;
	@Autowired
	TeacherService teacherservice;
	
	@GetMapping("/userForm")
	public String getUserForm(Model model) {
		model.addAttribute("userForm", new User());
		
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("listTab","active");
		return "userlist";
	}
		
		@GetMapping("/list")
		public String getSubjectList(Model model) {
			model.addAttribute("Subjectlist", new Subject());
			model.addAttribute("teacher",teacherservice.getAllTeacher());
			model.addAttribute("subjectList", subjectservice.getAllSubject());
			model.addAttribute("formTab","active");
			return "subjectlist";
}
		
		
		@PostMapping("/list")
		public String postUserForm(@Valid @ModelAttribute("Subjectlist")Subject subject, BindingResult result, ModelMap model) 
		 {
			if(result.hasErrors()) {
				model.addAttribute("Subjectlist", subject);
			
				model.addAttribute("formTab","active");
			}else {
				model.addAttribute("Subjectlist", new Subject());
				subjectservice.createSubject1(subject);
			}
			model.addAttribute("teacher",teacherservice.getAllTeacher());
			model.addAttribute("subjectList", subjectservice.getAllSubject());
			return "subjectlist";
			}
		@GetMapping("/editSubject/{id}")
		public String getEditUserForm(Model model, @PathVariable(name="id") Long id) throws Exception {
		Subject subjectedit= subjectservice.getSubjectById(id);
		model.addAttribute("Subjectlist", subjectedit);
		model.addAttribute("teacher",teacherservice.getAllTeacher());
		model.addAttribute("subjectList", subjectservice.getAllSubject());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode",true);
		return "subjectlist";
		}
		
		@GetMapping("/deleteSubject/{id}")
		public String deleteUser(Model model, @PathVariable(name="id") Long id) {
			try {
				subjectservice.deleteSubject(id);
			} catch (Exception e) {
				model.addAttribute("deleteError","The user could not be deleted.");
			}
			return getSubjectList(model);
		}

		
		@GetMapping("/teacherlist")
		public String getTeacherList(Model model) {
			model.addAttribute("teacherlist", new Teacher());
			
			model.addAttribute("teacherList", teacherservice.getAllTeacher());
			//model.addAttribute("formTab","active");
			return "teacherlist";
		}
		
		@PostMapping("/teacherlist")
		public String postTeacherForm(@Valid @ModelAttribute("teacherlist")Teacher teacher, BindingResult result, ModelMap model) 
		 {
			if(result.hasErrors()) {
				model.addAttribute("teacherlist", teacher);
			
				model.addAttribute("formTab","active");
			}else {
				model.addAttribute("teacherlist", new Teacher());
				
				teacherservice.createSubject1(teacher);
			}
			model.addAttribute("teacherList",teacherservice.getAllTeacher());
			return "teacherlist";
}
		@GetMapping("/editTeacher/{id}")
		public String getEditTeacherForm(Model model, @PathVariable(name="id") Long id) throws Exception {
		//Subject subjectedit= subjectservice.getSubjectById(id);
			Teacher teacheredit= teacherservice.getTeacherById(id);
		model.addAttribute("teacherlist", teacheredit);
		
		model.addAttribute("teacherList",teacherservice.getAllTeacher());
		
		model.addAttribute("formTab","active");
		model.addAttribute("editMode",true);
		
		return "teacherlist";
		}
         
		@GetMapping("/deleteTeacher/{id}")
		public String deleteTeacher(Model model, @PathVariable(name="id") Long id) {
			try {
				//subjectservice.deleteSubject(id);
				teacherservice.deleteTeacher(id);
			} catch (Exception e) {
				model.addAttribute("deleteError","The user could not be deleted.");
			}
			return getTeacherList(model);
		}
}


