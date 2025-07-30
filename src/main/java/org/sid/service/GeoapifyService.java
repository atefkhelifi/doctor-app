package org.sid.service;

import java.util.Locale;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoapifyService {

	    private final RestTemplate restTemplate = new RestTemplate();

	    public String findNearbyDoctors(double lat, double lon) {
	    	int radiusMeters=10000;
	        double radiusInKm = radiusMeters / 1000.0;
	        double deltaLat = radiusInKm / 110.574;
	        double deltaLon = radiusInKm / (111.320 * Math.cos(Math.toRadians(lat)));

	        double southLat = lat - deltaLat;
	        double northLat = lat + deltaLat;
	        double westLon = lon - deltaLon;
	        double eastLon = lon + deltaLon;

	        System.out.println("Computed bbox: " + southLat + "," + westLon + "," + northLat + "," + eastLon);

	        String url = String.format(Locale.US,
	            "https://overpass-api.de/api/interpreter?data=[out:json][timeout:25];"
	            + "(node[\"amenity\"=\"clinic\"](%f,%f,%f,%f);"
	            + "node[\"amenity\"=\"hospital\"](%f,%f,%f,%f);"
	            + "node[\"amenity\"=\"doctors\"](%f,%f,%f,%f););"
	            + "out body;>;out skel qt;",
	            southLat, westLon, northLat, eastLon,
	            southLat, westLon, northLat, eastLon,
	            southLat, westLon, northLat, eastLon);

	        return restTemplate.getForObject(url, String.class);
	    }
	
 
}
