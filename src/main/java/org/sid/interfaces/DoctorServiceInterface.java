package org.sid.interfaces;

import java.util.List;

import org.sid.dto.DoctorRequest;
import org.sid.entity.Doctor;

public interface DoctorServiceInterface {
	public Doctor AddDoctor(String name, String specialty, String email, String phone, 
			String city, String country, String address);
	List<DoctorRequest> getAllDoctors();
	DoctorRequest getDoctorById(Long id);
	DoctorRequest updateDoctor(Long id, DoctorRequest doctorDTO);
	void deleteDoctor(Long id);
}
