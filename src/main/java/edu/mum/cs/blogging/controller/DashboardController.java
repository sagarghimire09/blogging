package edu.mum.cs.blogging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@GetMapping("/admin/dashboard")
	public String getDashboard() {
		return "admin/dashboard";
	}
}
