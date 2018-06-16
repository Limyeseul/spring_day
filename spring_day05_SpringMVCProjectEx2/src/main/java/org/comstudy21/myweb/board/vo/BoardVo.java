package org.comstudy21.myweb.board.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
SEQ NUMBER(5) PRIMARY KEY,
TITLE VARCHAR2(200),
WRITER VARCHAR2(20),
CONTENT VARCHAR2(2000),
REGDATE DATE DEFAULT SYSDATE,
CNT NUMBER(5) DEFAULT 0
*/
//lombok.jar 설치 
//1) 구글에서 lombok 검색 - cmd에 jar 실행
//2) java -jar .\lombok.jar
//3) lombok.jar파일을 프로젝트의 라이브러리에 추가한다.
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate; //java.sql.Date
	private int cnt;
}
