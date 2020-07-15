package com.ruannunes.contract.dto.filters;

import com.ruannunes.contract.dto.filters.enuns.BaseSortDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description class dto para representar os filtros de pesquisa de pets
 */

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PetsFilterDTO {

    @Builder.Default
    private String name = "";

    @Builder.Default
    private BaseSortDTO sorter = BaseSortDTO.MOST_RECENT;

    @Min(0)
    @Builder.Default
    private Integer page = 0;

    @Min(1)
    @Max(24)
    @Builder.Default
    private Integer limit = 10;
}
