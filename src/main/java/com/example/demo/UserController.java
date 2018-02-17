package com.example.demo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
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
			produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void download(HttpServletResponse response) throws IOException {
		String fileName = "user_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".csv";
		response.setContentType(MimeTypeUtils.TEXT_PLAIN_VALUE);
		response.setHeader("Content-Disposition", String.format("attachment; filename=%s;filename*=utf-8''%s", fileName, URLEncoder.encode(fileName, "utf-8")));
		
		try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(response.getOutputStream(), "Windows-31J"))) {
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
