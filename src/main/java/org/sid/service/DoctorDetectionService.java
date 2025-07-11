package org.sid.service;

import org.sid.dto.SpecialistResponse;
import org.sid.dto.SymptomRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorDetectionService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String FLASK_API_URL = "http://localhost:5000/detect";

    public String detectSpecialist(String symptom) {
        SymptomRequest request = new SymptomRequest(symptom);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SymptomRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<SpecialistResponse> response = restTemplate.postForEntity(
            FLASK_API_URL, entity, SpecialistResponse.class);

        return response.getBody().getSpecialist();
    }
}