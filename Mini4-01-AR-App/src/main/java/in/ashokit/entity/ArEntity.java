package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ArTable")
public class ArEntity {
	@Id
	private Integer regnumber;
	private String name;
	private String email;
	private Long mobile;
	private String gender;
	private LocalDate dob;
	private Integer ssn;
	

}
