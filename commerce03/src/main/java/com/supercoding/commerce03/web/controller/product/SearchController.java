package com.supercoding.commerce03.web.controller.product;

import com.supercoding.commerce03.service.product.SearchService;
import com.supercoding.commerce03.web.dto.product.GetRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SearchService searchService;

    @GetMapping(value={
            "v1/api/search",
            "v1/api/search/{animalCategory}" ,
            "v1/api/search/{animalCategory}/{productCategory}",
            "v1/api/search/{animalCategory}/{productCategory}/{sortBy}"})
    public ResponseEntity<List<String>> searchText(
            @PathVariable(required = false) String animalCategory,
            @PathVariable(required = false) String productCategory,
            @PathVariable(required = false) String sortBy,
            @RequestParam(required = false) String searchWord
    ) {
        GetRequestDto getRequestDto = new GetRequestDto(animalCategory, productCategory, sortBy);
        //메인페이지 상품리스트
        List<String> product = searchService.searchFullText(getRequestDto, searchWord);
        return ResponseEntity.ok(product);
    }

}
