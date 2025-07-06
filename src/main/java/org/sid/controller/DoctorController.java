package org.sid.controller;

import java.util.List;

import org.sid.dto.DoctorRequest;
import org.sid.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> registerUser(@RequestBody DoctorRequest request) {
    	doctorService.AddDoctor(request.getName(), request.getSpecialty(),request.getEmail(),
    			request.getPhone(),request.getCity(), request.getCountry(), request.getAddress());
        return ResponseEntity.ok("Doctor registered successfully");
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<DoctorRequest> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public DoctorRequest getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public DoctorRequest updateDoctor(@PathVariable Long id, @RequestBody DoctorRequest dto) {
        return doctorService.updateDoctor(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted");
    }

}
