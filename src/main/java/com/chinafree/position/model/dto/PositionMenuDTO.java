package com.chinafree.position.model.dto;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class PositionMenuDTO {


    private String name;

    private String url;

    private PositionMenuTypeDTO type;

    class PositionMenuTypeDTO{

        private Long id;

        private String name;

    }
}
