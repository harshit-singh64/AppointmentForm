package com.example.appointmentform.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointmentform.dto.AppointmentFormDto;
import com.example.appointmentform.exception.CustomException;
import com.example.appointmentform.service.AppointmentFormServiceImpl;

@RestController
@RequestMapping("/api")
public class AppointmentFormController {
	@Autowired
	private AppointmentFormServiceImpl appointmentFormService;
	
	@PostMapping("/form")
	public AppointmentFormDto insert(@RequestBody @Valid AppointmentFormDto appointmentFormDto) throws CustomException {
		return appointmentFormService.insert(appointmentFormDto);
		}
	
	@GetMapping(value = "/form", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentFormDto> getAll() {
		return appointmentFormService.getAll();
		}
}
