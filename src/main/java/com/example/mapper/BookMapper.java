package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Book;
import org.apache.ibatis.annotations.Mapper;

//映射类
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
