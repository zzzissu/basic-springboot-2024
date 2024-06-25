package com.zzzissu.backboard.service;

import org.springframework.stereotype.Service;

import com.zzzissu.backboard.common.NotFoundException;
import com.zzzissu.backboard.entity.Category;
import com.zzzissu.backboard.repository.CategoryRepository;
import java.util.Optional;
import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;    // bean으로 생성

    // 카테고리를 생성하는 매서드
    public Category setCategory(String title) {
        Category cate = new Category();
        cate.setTitle(title);
        cate.setCreateDate(LocalDateTime.now());

        Category category = this.categoryRepository.save(cate);
        return category;
    }

    // free, qna
    public Category getCategory(String title) {
        Optional<Category> cate = this.categoryRepository.findByTitle(title);

        if(cate.isEmpty()) {    //free나 qna 타이틀의 카테고리 데이터가 없으면
            cate = Optional.ofNullable(setCategory(title)); // 테이블에 해당 카테고리를 생성(INSERT)
        }

        if(cate.isPresent())
            return cate.get();  // Category 리턴
        else
            throw new NotFoundException("Category not Found!"); // 발생할 일이 없음
    }
}
