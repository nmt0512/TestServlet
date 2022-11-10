package com.kma.paging;

public interface Pageable {
	Integer getPage();
	Integer getOffset();
	Integer getFetch();
	Integer getTotalPages(Integer totalItems, Integer maxPageItems);
}
