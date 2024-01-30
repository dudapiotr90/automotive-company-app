package pl.dudi.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private String customerComment;
    private List<Integer> orderItemIds;

}
