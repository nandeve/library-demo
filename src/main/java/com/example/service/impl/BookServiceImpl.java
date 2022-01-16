package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.BookMapper;
import com.example.entity.Book;
import com.example.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//服务实现类
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    //注入映射类
    @Autowired
    private BookMapper bookMapper;

    //保存一个book对象
    @Override
    public boolean saveBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    //根据id修改对象
    @Override
    public boolean modify(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    //根据id删除对象
    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    //分页查询
    @Override
    public IPage<Book> getPage(int curPage, int pageSize) {
        IPage page = new Page(curPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }

    //按条件分页查询
    @Override
    public IPage<Book> getPage(int curPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        wrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        IPage page = new Page(curPage, pageSize);
        bookMapper.selectPage(page, wrapper);
        return page;
    }
}
