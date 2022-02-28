package com.project.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.demo.dao.HospitalRepo;
import com.project.demo.entity.Hospital;


@Controller
public class HospitalController {
	@Autowired
	HospitalRepo hr;
	
	@RequestMapping("/")
	public String show()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/addhospital")
	@ResponseBody
	public String add(Hospital h)
	{
		hr.save(h);
		return "Hospital added...";
	}
	
	@RequestMapping("/viewhospital")
	@ResponseBody
	public String viewhospital(int id)
	{
		Hospital h = hr.findById(id).orElse(new Hospital());
		return h.toString();
	}
	
	@RequestMapping("/hospitallist")
	@ResponseBody
	public String hospitallist()
	{
		List<Hospital> hl =(List<Hospital>) hr.findAll();
		return hl.toString();
	}
	@RequestMapping("/updatehospital")
	@ResponseBody
	public String updatehospital(Hospital h)
	{
		hr.save(h);
		return "hospital updated...";
	}
	
	@RequestMapping("/deletehospital")
	@ResponseBody
	public String deletehospital(int id)
	{
		hr.deleteById(id);
		return "hospital deleted...";
	}
}


