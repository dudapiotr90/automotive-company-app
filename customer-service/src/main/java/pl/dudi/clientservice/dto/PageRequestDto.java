package pl.dudi.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDto {

    private int pageNumber;
    private int pageSize;
    private String sortBy;
    private String sortHow;
}
