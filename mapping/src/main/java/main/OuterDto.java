package main;

import lombok.Data;

import java.util.List;

@Data
public class OuterDto {
    private List<InnerDto> innerDtoList;
}