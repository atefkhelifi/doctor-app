package org.sid.service;

import java.util.List;

import org.sid.dto.DoctorRequest;
import org.sid.entity.Doctor;
import org.sid.interfaces.DoctorServiceInterface;
import org.sid.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements DoctorServiceInterface{
	
	@Autowired
    private DoctorRepository doctorRepository;

	// Utility
			private DoctorRequest mapToDTO(Doctor doctor) {
				DoctorRequest dto = new DoctorRequest();
			    dto.setId(doctor.getId());
			    
			    dto.setName(doctor.getName());
			    dto.setSpecialty(doctor.getSpecialty());
			    dto.setEmail(doctor.getEmail());
			    dto.setPhone(doctor.getPhone());
			    dto.setCity(doctor.getCity());
			    dto.setCountry(doctor.getCountry());
			    dto.setAddress(doctor.getAddress());
			    return dto;
			}
			
	@Override
	public Doctor AddDoctor(String name, String specialty, String email, String phone, 
			String city, String country,
			String address) {
      

		 Doctor doctor = new Doctor();
		 doctor.setName(name);
		 doctor.setSpecialty(specialty);
		 doctor.setEmail(email);
		 doctor.setPhone(phone);
		 doctor.setCity(city);
		 doctor.setCountry(country);
		 doctor.setAddress(address);
		 
		 
	        return doctorRepository.save(doctor);
	}

	@Override
	public List<DoctorRequest> getAllDoctors() {
		return doctorRepository.findAll().stream().map(this::mapToDTO).toList();
	}

	@Override
	public DoctorRequest getDoctorById(Long id) {
		Doctor doctor = doctorRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Doctor not found"));
	    return mapToDTO(doctor);
	}

	@Override
	public DoctorRequest updateDoctor(Long id, DoctorRequest doctorDTO) {
		 Doctor doctor = doctorRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Doctor not found"));
		    doctor.setName(doctorDTO.getName());
		    doctor.setSpecialty(doctor.getSpecialty());
		    doctor.setEmail(doctor.getEmail());
		    doctor.setPhone(doctor.getPhone());
		    doctor.setCity(doctor.getCity());
		    doctor.setCountry(doctor.getCountry());
		    doctor.setAddress(doctor.getAddress());
		    
		    return mapToDTO(doctorRepository.save(doctor));
	}

	@Override
	public void deleteDoctor(Long id) {
		if (!doctorRepository.existsById(id)) {
	        throw new RuntimeException("Doctor not found");
	    }
	    doctorRepository.deleteById(id);
		
	}

}
