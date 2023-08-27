package com.example.fitssionbackend.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryType {
    CUTE("귀여운"),
    NEAT("산뜻한"),
    DANDY("댄디한"),
    HIP("힙한"),
    FANCY("화려한"),
    QUITE("차분한"),
    VINTAGE("빈티지한"),
    BRIGHT("밝은"),
    DARK("어두운"),
    SIMPLE("심플한"),
    LEISURELY("여유로운"),
    MINIMAL("미니멀한"),
    CASUAL("캐주얼한"),
    BUSINESS("비즈니스한"),
    UNIQ("독특한"),
    COOL("시원한"),
    WARM("따뜻한"),
    CLEAN("깔끔한");

    private final String categoryName;
}
