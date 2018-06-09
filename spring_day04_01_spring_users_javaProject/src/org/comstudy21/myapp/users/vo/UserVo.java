package org.comstudy21.myapp.users.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
CREATE TABLE USERS (
ID VARCHAR2(8) PRIMARY KEY,
PASSWORD VARCHAR2(8),
NAME VARCHAR2(20),
ROLE VARCHAR2(5)
)
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVo {
	private String id;
	private String password;
	private String name;
	private String role;
}
