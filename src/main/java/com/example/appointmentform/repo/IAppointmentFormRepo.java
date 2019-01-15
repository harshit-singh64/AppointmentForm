package com.example.appointmentform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appointmentform.entity.AppointmentForm;

public interface IAppointmentFormRepo extends JpaRepository<AppointmentForm, Integer> {
	
}
