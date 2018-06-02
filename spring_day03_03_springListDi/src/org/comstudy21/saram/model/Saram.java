package org.comstudy21.saram.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Saram {
	private String	id;
	private String 	name;
	private int		age;
}
