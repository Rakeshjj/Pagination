package com.pagination.Model;

import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pagination {

	private Integer pageNumber;
	private Integer pageSize;

	public Pagination() {
		super();
	}

	public Pagination(Integer pageNumber, Integer pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Pagination [pageNumber=" + pageNumber + ", pageSize=" + pageSize + "]";
	}

	public Pageable getPageableData(Pagination dto) {

		Integer pageNum = Objects.nonNull(dto.getPageNumber()) ? dto.getPageNumber() : this.getPageNumber();
		Integer pageSiz = Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : this.getPageSize();

		return PageRequest.of(pageNum, pageSiz);

	}

}
