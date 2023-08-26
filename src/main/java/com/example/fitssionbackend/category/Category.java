package com.example.fitssionbackend.category;

import com.example.fitssionbackend.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean cute; // 귀여운

    private Boolean neat; // 산뜻한

    private Boolean dandy; // 댄디한

    private Boolean hip; // 힙한

    private Boolean fancy; // 화려한

    private Boolean quite; // 차분한

    private Boolean vintage; // 빈티지한

    private Boolean bright; // 밝은

    private Boolean dark; // 어두운

    private Boolean simple; // 심플한

    private Boolean leisurely; // 여유로운

    private Boolean minimal; // 미니멀한

    private Boolean casual; // 캐주얼한

    private Boolean business; // 비즈니스한

    private Boolean uniq; // 독특한

    private Boolean cool; // 시원한

    private Boolean warm; // 따뜻한

    private Boolean clean; // 깔끔한

}
