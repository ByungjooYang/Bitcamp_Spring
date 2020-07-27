package board.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardDTO {
	private String id;
	private String name;
	private String email;
	private String subject;
	private String contemt;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy.mm.dd")
	private Date logtime;
	
	private int seq;
	private int ref;
	private int lev;
	private int step;
	private int pseq;
	private int reply;
	private int hit;
}
