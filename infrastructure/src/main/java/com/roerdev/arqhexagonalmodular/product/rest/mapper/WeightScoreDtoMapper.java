package com.roerdev.arqhexagonalmodular.product.rest.mapper;

import com.roerdev.arqhexagonalmodular.product.model.dto.WeightScoreDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeightScoreDtoMapper {


    @Mapping(target = "filter", source = "filter")
    @Mapping(target = "score", source = "score")
    WeightScoreDto mapToWeightScoreDto(String filter, Double score);

    default WeightScoreDto[] mapToWeightScoreDtoArray(List<String> filters, List<Double> scores){
        WeightScoreDto[] array = null;
        if(filters.size() == scores.size()){
            array = new WeightScoreDto[scores.size()];
            for(int i = 0; i < scores.size(); i++){
                array[i] = WeightScoreDto.builder().filter(filters.get(i)).score(scores.get(i)).build();
            }
        }
        return array;
    }
}
