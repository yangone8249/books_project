package com.myweb.www.handler;

import com.myweb.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PagingHandler {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int totalCount;
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		// 1 2 3 4 5... 10 ▶    => ◀ 11 12 13 ... 20 ▶
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		this.endPage = 
				(int)(Math.ceil(pgvo.getPageNo() / (pgvo.getQty()*1.0)))*pgvo.getQty();
		this.startPage = endPage - 3; 
		int realEndPage = (int)Math.ceil((totalCount*1.0) / pgvo.getQty());
		
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		this.prev = this.startPage > 1; //true / false
		this.next = this.endPage < realEndPage; //true / false
	}
	

}
