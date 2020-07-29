package board.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BoardPaging {
	private int currentPage, pageBlock, pageSize, totalA;
	private StringBuffer pagingHTML;
	private String keyword;
	private String searchOption;
	
	public void makePagingHTML() {
		
		pagingHTML = new StringBuffer();
		int totalP = (totalA+pageSize-1)/pageSize;
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage + pageBlock-1;
		if(endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) {
			pagingHTML.append("[<span id='paging' onclick='boardPaging(" + (startPage-1) +")'>이전</span>]");
		}
		
		for(int i=startPage;i<=endPage;i++) {
			if(i == currentPage) {
				pagingHTML.append("[<span id='currentPaging' onclick='boardPaging("+i+")'>"+ i +"</span>]");
				
			}else {
				pagingHTML.append("[<span id='paging' onclick='boardPaging("+i+")'>"+ i +"</span>]");
				
			}
		}
		
		if(endPage < totalP) {
			pagingHTML.append("[<span id='paging'  onclick='boardPaging(" + (endPage + 1) +")'>다음</span>]");
		}
	}
	
	
	
	public void makeSearchPagingHTML(String searchOption ,String keyword) {
		pagingHTML = new StringBuffer();
		int totalP = (totalA+pageSize-1)/pageSize;
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage + pageBlock-1;
		if(endPage > totalP) endPage = totalP;
		
		String encoding = null;
		try {
			encoding = URLEncoder.encode(keyword, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
		}
		
		if(startPage > pageBlock) {
			pagingHTML.append("[<a id='paging' href='/miniProject/board/boardSeaerch.do?pg=" + (startPage-1) + "&searchOption="+ searchOption + "&keyword=" + encoding + "'>이전</a>]");
		}
		
		for(int i=startPage;i<=endPage;i++) {
			if(i == currentPage) {
				pagingHTML.append("[<a id='currentPaging' href='/miniProject/board/boardSearch.do?pg=" + i + "&searchOption=" + searchOption + "&keyword=" + encoding + "'>"+ i +"</a>]");
				
			}else {
				pagingHTML.append("[<a id='paging' href='/miniProject/board/boardSearch.do?pg=" + i + "&searchOption=" + searchOption + "&keyword=" + encoding + "'>"+ i +"</a>]");
				
			}
		}
		
		if(endPage < totalP) {
			pagingHTML.append("[<a id='paging'  href='/miniProject/board/boardSearch.do?pg=" + (endPage + 1) + "&searchOption=" + searchOption + "&keyword= " + encoding +"'>다음</a>]");
		}
	}
	
	public void makeImagePaging() {
		pagingHTML = new StringBuffer();
		int totalP = (totalA+pageSize-1)/pageSize;
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage + pageBlock-1;
		if(endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) {
			pagingHTML.append("[<span id='paging' onclick='imagePaging(" + (startPage-1) +")'>이전</span>]");
		}
		
		for(int i=startPage;i<=endPage;i++) {
			if(i == currentPage) {
				pagingHTML.append("[<span id='currentPaging' onclick='imagePaging("+i+")'>"+ i +"</span>]");
				
			}else {
				pagingHTML.append("[<span id='paging' onclick='imagePaging("+i+")'>"+ i +"</span>]");
				
			}
		}
		
		if(endPage < totalP) {
			pagingHTML.append("[<span id='paging'  onclick='imagePaging(" + (endPage + 1) +")'>다음</span>]");
		}
	}
	
}
