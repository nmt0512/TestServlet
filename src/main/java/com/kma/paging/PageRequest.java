package com.kma.paging;

public class PageRequest implements Pageable {
	
	private Integer page;
	private Integer maxPageItems;
	
	public PageRequest(Integer page, Integer maxPageItems) {
		this.page = page;
		this.maxPageItems = maxPageItems;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.maxPageItems != null) {
			return (this.page - 1) * this.maxPageItems;
		}
		return null;
	}

	@Override
	public Integer getFetch() {
		return this.maxPageItems;
	}

	@Override
	public Integer getTotalPages(Integer totalItems, Integer maxPageItems) {
		int totalPages = totalItems / maxPageItems;
		if(totalItems % maxPageItems == 0)
			return totalPages;
		else
			return totalPages + 1;
	}

}
