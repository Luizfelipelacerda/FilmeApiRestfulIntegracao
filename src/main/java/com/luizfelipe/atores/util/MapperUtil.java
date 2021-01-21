package com.luizfelipe.atores.util;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUtil {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <S, T> T mapper(S source, Class<T> destiny){
        return modelMapper.map(source, destiny);
    }

    public static <S, T> List<T> mapper(List<S> source, Class<T> destiny){
        return source.stream()
                .map(x -> modelMapper.map(x, destiny))
                .collect(Collectors.toList());
    }

}
