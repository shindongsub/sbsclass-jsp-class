package com.sbs.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private int id;
	private String title;
	private String body;
	private String nickname;
	private String regDate;
	private int hit;
}
