package com.vkr.user_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Setter
@Jacksonized
public class GetAverageRatingByIdsDto {

    private List<String> ids;
    private int playersNumber;
}
