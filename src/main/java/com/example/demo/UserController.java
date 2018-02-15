package com.example.demo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import au.com.bytecode.opencsv.CSVWriter;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(path = "/")
	public String index() {
		return "index";
	}

	@GetMapping(path = "/curryUser/download", 
			produces = MediaType.APPLICATION_OCTET_STREAM_VALUE + "; charset=utf-8; Content-Disposition: attachment; filename=\"users.csv\"")
	public void download(HttpServletResponse response) {
		try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"))) {
			List<CurryUser> allUsers = userService.findAll();
			allUsers.forEach(user -> {
				String[] nextLine = new String[] {
						user.getId().toString(),
						user.getName(),
						user.getCurry()
				};
				writer.writeNext(nextLine);
			});
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
