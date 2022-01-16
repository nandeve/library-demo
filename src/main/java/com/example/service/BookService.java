package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Book;

//服务类接口
public interface BookService extends IService<Book> {
    boolean saveBook(Book book);
    boolean modify(Book book);
    boolean delete(Integer id);
    IPage<Book> getPage(int curPage, int pageSize);
    IPage<Book> getPage(int curPage, int pageSize, Book book);
}
