package com.roerdev.arqhexagonalmodular.product.rest.mapper;

import com.roerdev.arqhexagonalmodular.product.model.dto.WeightScoreDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WeightScoreDtoMapperTest {

    @Spy
    private WeightScoreDtoMapper weightScoreDtoMapper = new WeightScoreDtoMapperImpl();

    @Test
    void mapToWeightScoreDto() {

        WeightScoreDto mapper = this.weightScoreDtoMapper.mapToWeightScoreDto("S", 0.0);
        assertEquals(mapper.getFilter(), "S");
        assertEquals(mapper.getScore(), 0.0);
    }

    @Test
    void mapToWeightScoreDtoArray() {
        List<String> filters = List.of("S");
        List<Double> scores = List.of(0.0);

        WeightScoreDto[] array = this.weightScoreDtoMapper.mapToWeightScoreDtoArray(filters, scores);
        assertEquals(array.length, 1);
        assertEquals(array[0].getFilter(), "S");
    }
}