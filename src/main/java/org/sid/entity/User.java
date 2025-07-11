package org.sid.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data                 // génère getters, setters, toString, equals, hashCode
@NoArgsConstructor    // constructeur sans arguments
@AllArgsConstructor   // constructeur avec tous les arguments
public class User {

	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(nullable = false, unique = true)
	  private String username;

	  @Column(nullable = false)
	  private String password;

	  @Column(nullable = false)
	  private String roles; // e.g. "ROLE_USER,ROLE_ADMIN"
	  
	
}
