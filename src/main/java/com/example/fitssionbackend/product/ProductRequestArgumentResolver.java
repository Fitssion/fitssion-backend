package com.example.fitssionbackend.product;

import com.example.fitssionbackend.product.dto.ProductRequest;
import com.example.fitssionbackend.product.dto.ProductRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductRequestArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ProductRequest.class) != null
                && parameter.getParameterType().equals(ProductRequestDto.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String categoryParam = request.getParameter("category");
        String genderParam = request.getParameter("gender");
        String pageParam = request.getParameter("page");

        List<Integer> category = categoryParam == null ? List.of() : Arrays.stream(categoryParam.split(","))
                .map(Integer::parseInt)
                .toList();
        int gender = genderParam == null ? 0 : Integer.parseInt(genderParam);
        int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
        return ProductRequestDto.builder()
                .category(category)
                .gender(gender)
                .page(page)
                .build();
    }
}
