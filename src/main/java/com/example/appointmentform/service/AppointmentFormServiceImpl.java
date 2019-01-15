package com.example.appointmentform.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointmentform.dto.AppointmentFormDto;
import com.example.appointmentform.entity.AppointmentForm;
import com.example.appointmentform.exception.CustomException;
import com.example.appointmentform.repo.IAppointmentFormRepo;

@Service
public class AppointmentFormServiceImpl {
	@Autowired
	private IAppointmentFormRepo appointmentFormRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentFormServiceImpl.class.getName());
	
	public AppointmentFormDto entityToDtoAssembler(AppointmentFormDto appointmentFormDto, AppointmentForm appointmentForm) {
		appointmentFormDto.setId(appointmentForm.getId());
		appointmentFormDto.setEmail(appointmentForm.getEmail());
		appointmentFormDto.setName(appointmentForm.getName());
		appointmentFormDto.setAge(appointmentForm.getAge());
		appointmentFormDto.setMobileNumber(appointmentForm.getMobileNumber());
		appointmentFormDto.setTime(appointmentForm.getTime());
		appointmentFormDto.setDay(appointmentForm.getDay());
		appointmentFormDto.setDate(appointmentForm.getDate());
		appointmentFormDto.setLocation(appointmentForm.getLocation());
		appointmentFormDto.setSymptoms(appointmentForm.getSymptoms());
		appointmentFormDto.setApplicationDate(appointmentForm.getApplicationDate());
		return appointmentFormDto;
	}
	
	public AppointmentForm dtoToEntityAssembler(AppointmentFormDto appointmentFormDto, AppointmentForm appointmentForm) {
		appointmentForm.setId(appointmentFormDto.getId());
		appointmentForm.setEmail(appointmentFormDto.getEmail());
		appointmentForm.setName(appointmentFormDto.getName());
		appointmentForm.setAge(appointmentFormDto.getAge());
		appointmentForm.setMobileNumber(appointmentFormDto.getMobileNumber());
		appointmentForm.setTime(appointmentFormDto.getTime());
		appointmentForm.setDay(appointmentFormDto.getDay());
		appointmentForm.setDate(appointmentFormDto.getDate());
		appointmentForm.setLocation(appointmentFormDto.getLocation());
		appointmentForm.setSymptoms(appointmentFormDto.getSymptoms());
		appointmentForm.setApplicationDate(appointmentFormDto.getApplicationDate());
		return appointmentForm;
	}
	
	/*inserting value*/
	
	public AppointmentFormDto insert(AppointmentFormDto appointmentFormDto) throws CustomException {
		AppointmentForm appointmentForm = new AppointmentForm();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date currentDate = new Date();
			
			appointmentFormDto.setApplicationDate(dateFormat.format(currentDate));
			
			appointmentForm = dtoToEntityAssembler(appointmentFormDto, appointmentForm);
			appointmentFormRepo.save(appointmentForm);
			
			appointmentFormDto.setId(appointmentForm.getId());
			logger.info("done>>>>>>>>>>>>");
			} catch (Exception e) {
				e.printStackTrace();
				throw new CustomException(400,e.toString());
				}
		return appointmentFormDto;
	}
	
	/*get all*/
	
	public List<AppointmentFormDto> getAll() {
		List<AppointmentForm> appointmentFormList = appointmentFormRepo.findAll();
		List<AppointmentFormDto> appointmentFormDtoList = new ArrayList<>();
		
		for(AppointmentForm appointmentForm: appointmentFormList) {
			AppointmentFormDto appointmentFormDto = new AppointmentFormDto();
			appointmentFormDto = entityToDtoAssembler(appointmentFormDto, appointmentForm);
			appointmentFormDtoList.add(appointmentFormDto);
			}
		return appointmentFormDtoList;
		}
}
