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

import com.core.inscriptionAplication.entity.Inscriptions;
import com.core.inscriptionAplication.entity.Subject;
import com.core.inscriptionAplication.entity.Teacher;
import com.core.inscriptionAplication.entity.User;
import com.core.inscriptionAplication.service.InscriptionService;
import com.core.inscriptionAplication.service.SubjectService;
import com.core.inscriptionAplication.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired 
	UserService userService;
	
	@Autowired
	SubjectService subjectservice;
	
	@Autowired
	InscriptionService inscriptionservice;
	
	@GetMapping("/userForm")
	public String getUserForm(Model model) {
		model.addAttribute("userForm", new User());
		
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("listTab","active");
		return "userlist";
	}
		
		@GetMapping("/subjectList")
		public String getSubjectList(Model model) {
			model.addAttribute("Subjectlist", new Subject());
			model.addAttribute("inscriptions", new Inscriptions());
			
			
			model.addAttribute("subjectList", subjectservice.getAllSubject());
			model.addAttribute("formTab","active");
			return "services";
}
		@GetMapping("/inscription")
		public String  GetInscription(Model model) {
model.addAttribute("inscriptions", new Inscriptions());
			
			
			model.addAttribute("subjectList", subjectservice.getAllSubject());
			return "inscription";
			
		}
		
		
		@PostMapping("/subjectlist")
		public String postUserForm(@Valid @ModelAttribute("inscriptions")Inscriptions inscriptions, BindingResult result, ModelMap model) 
		 {
			if(result.hasErrors()) {
				model.addAttribute("inscriptions", inscriptions);
			
				model.addAttribute("formTab","active");
			}else {
				model.addAttribute("Subjectlist", new Inscriptions());
				inscriptionservice.createInscription(inscriptions);
			}
			
			model.addAttribute("subjectList", subjectservice.getAllSubject());
			return "services";
			}
		
		
		@GetMapping("/showinscriptions/{name}")
		public String getEditTeacherForm(Model model, @PathVariable(name="name") String className) throws Exception {
		//Subject subjectedit= subjectservice.getSubjectById(id);
			//Teacher teacheredit= teacherservice.getTeacherById(id);
			
		model.addAttribute("inscription", inscriptionservice.getByname(className));
		
		
		
		model.addAttribute("formTab","active");
		model.addAttribute("editMode",true);
		
		return "insc";
		}
}
