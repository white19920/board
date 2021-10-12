package com.example.board.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageDTO {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private Criteria criteria;

    public PageDTO() {;}

    public PageDTO(int total, int pageCount, Criteria criteria) {
        this.total = total;
        this.pageCount = pageCount;
        this.criteria = criteria;

        this.endPage = (int)(Math.ceil(criteria.getPageNum() / pageCount)) * pageCount;
        this.startPage = endPage - (pageCount - 1);
    }

}
