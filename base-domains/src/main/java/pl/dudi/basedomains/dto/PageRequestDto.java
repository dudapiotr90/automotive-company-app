package pl.dudi.basedomains.dto;

import lombok.*;

@Getter
@Setter
public class PageRequestDto {

    private Integer pageNumber;
    private Integer pageSize;
    private String sortHow;
    private String[] sortBy;

    public PageRequestDto(Integer pageNumber, Integer pageSize, String sortHow, String... sortBy) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortHow = sortHow;
        this.sortBy = sortBy;
    }
}
