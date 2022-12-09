package com.app.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardListPage {
    // 페이지당 출력할 게시물 개수
    private int countPerPage;

    // 현재 페이지 번호
    private int pageNum;

    // 게시물의 리스트
    private List<BoardArticleDTO> list;

    // 전체 게시물 개수
    private int totalCount;

    // 페이지의 시작 번호
    private int startNum;

    // 페이지의 끝 번호
    private int endNum;

    // 이전 버튼 출력 여부
    private boolean prev;

    // 다음 버튼 출력 여부
    private boolean next;

    public BoardListPage(int countPerPage, int pageNum, List<BoardArticleDTO> list, int totalCount) {
        this.countPerPage = countPerPage;
        this.pageNum = pageNum;
        this.list = list;
        this.totalCount = totalCount;
        calPageInfo();
    }

    private void calPageInfo() {
        // 끝번호
        this.endNum = (int)(Math.ceil((this.pageNum * 1.0) / 10)) * 10; // 11-> 11.0 / 10 -> 1.1 -> ceil 2.0 -> 2*10
        // this.endNum = (int) Math.ceil((this.pageNum * 1.0) / 5) * 5;

        // 시작번호
        this.startNum = this.endNum - 9;
        // this.startNum = this.endNum - 4;
        // 전체 페이지 끝번호
        int realEndNum = (int)(Math.ceil((this.totalCount * 1.0) / countPerPage));  // 35.0/10 -> 3.5 ceil 4.0
        // 구간의 마지막 번호보다 실제 끝페이지가 작으면 endNum 은 실제 끝번호가 되어야 한다
        this.endNum = realEndNum < this.endNum ? realEndNum : this.endNum;
        // 이전 구간으로 이동 가능한지
        this.prev = this.startNum > 1;
        // 다음 구간으로 이동 가능한지
        this.next = this.endNum < realEndNum;
    }
}
