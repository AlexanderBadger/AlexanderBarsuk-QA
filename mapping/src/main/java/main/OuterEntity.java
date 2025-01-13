package main;

import lombok.Data;

import java.util.List;

@Data
public class OuterEntity {
    private List<InnerEntity> innerEntityList;
}