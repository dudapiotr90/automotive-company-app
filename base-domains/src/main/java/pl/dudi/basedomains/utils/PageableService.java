package pl.dudi.basedomains.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.dudi.basedomains.dto.PageRequestDto;

import java.util.Objects;

public class PageableService {

    // TODO check if correct
    public Pageable preparePageable(
        PageRequestDto defaultRequest,
        Integer pageNumber,
        Integer pageSize,
        String sortHow,
        String... sortBy
    ) {
        if (Objects.isNull(pageNumber) || pageNumber < 1) {
            pageNumber = defaultRequest.getPageNumber();
        }
        if (Objects.isNull(pageSize) || pageSize < 1) {
            pageSize = defaultRequest.getPageSize();
        }
        if (!("asc".equalsIgnoreCase(sortHow) || "desc".equalsIgnoreCase(sortHow))) {
            sortHow = defaultRequest.getSortHow();
        }
        if (Objects.isNull(sortBy)) {
            sortBy= defaultRequest.getSortBy();
        }
        if (sortBy.length < 2) {
            Sort sort = sortHow.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
            return PageRequest.of(pageNumber - 1, pageSize, sort);
        }
        Sort.Order[] orders = new Sort.Order[sortBy.length];
        for (int i = 0; i < sortBy.length; i++) {
            orders[i] = new Sort.Order(Sort.Direction.fromString(sortHow), sortBy[i]);
        }
        Sort sort = Sort.by(orders);
        return PageRequest.of(pageNumber - 1, pageSize, sort);
    }

}
