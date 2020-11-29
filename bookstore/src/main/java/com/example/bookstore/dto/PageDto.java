package com.example.bookstore.dto;

public class PageDto {
	// là list danh sach page cần hiển thị vd: 1 2 3
    private int listPageToShow;

    private int startPage;

    private int endPage;

    public int getListPageToShow() {
		return listPageToShow;
	}

	public void setListPageToShow(int listPageToShow) {
		this.listPageToShow = listPageToShow;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public PageDto(int totalPage,int currentPage, int listPageToShow) {
        setListPageToShow(listPageToShow);
        int halfListPageToShow = getListPageToShow() / 2;
        // case 1: totalPage <= listPageToShow
        if(totalPage <= getListPageToShow()) {
            setStartPage(1);
            setEndPage(totalPage);
        } else if(currentPage <= halfListPageToShow) {
            setStartPage(1);
            setEndPage(getListPageToShow());
        } else if(currentPage + halfListPageToShow == totalPage) {
            setStartPage(currentPage - halfListPageToShow);
            setEndPage(totalPage);
        } else if(currentPage + halfListPageToShow > totalPage) {
            setStartPage(totalPage - getListPageToShow() + 1);
            setEndPage(totalPage);
        } else {
            setStartPage(currentPage - halfListPageToShow);
            setEndPage(currentPage + halfListPageToShow);
        }
    }
}
