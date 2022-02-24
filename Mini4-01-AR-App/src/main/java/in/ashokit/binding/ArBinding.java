package in.ashokit.binding;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ArBinding {


	private String name;
	private String email;
	private Long mobile;
	private String gender;
	private LocalDate dob;
	private Integer ssn;

}
