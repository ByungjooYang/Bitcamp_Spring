package board.bean;

import lombok.Data;

@Data
public class ImageboardDTO {
	private int seq;
	private String imageId;
	private String imageName;
	private String imageContent;
	private String image1;
	private int imagePrice;
	private int imageQty;
	private String logtime;
}
