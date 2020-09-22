package com.sbs.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	int id;
	String parentId;
	String body;
	String writer;
	String regDate;

}