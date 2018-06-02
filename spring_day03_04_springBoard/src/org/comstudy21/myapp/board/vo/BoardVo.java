package org.comstudy21.myapp.board.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * -- 게시판 테이블 생성
CREATE TABLE IF NOT EXISTS BOARD(
	SEQ 		NUMBER(5) PRIMARY KEY,
	TITLE 		VARCHAR2(200),
	WRITER 		VARCHAR2(20),
	CONTENTS 	VARCHAR2(2000),
	REGDATE		DATE DEFAULT SYSDATE,
	CNT			NUMBER(5) DEFAULT 0
);
 */

// lombok.jar
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
	private int 	seq;
	private String 	title;
	private String 	writer;
	private String 	content;
	private Date 	regDate;
	private int 	cnt;
}
