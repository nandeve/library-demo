package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.vo.Result;
import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//控制类
@RestController
@RequestMapping("/books")
public class BookController {

    //注入业务层接口
    @Autowired
    private BookService bookService;

    /**
     * get请求，查询所有book
     * @return
     */
    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.list());
    }

    /**
     * post请求，添加book，添加的对象放在请求体中，使用@RequestBody注解获取对象
     * @param book
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Book book) throws Exception {
        if (book.getName().equals("123")) throw new Exception();
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功" : "添加失败");
    }

    /**
     * put请求，更新book，请求参数放在请求体中
     * @param book
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(bookService.modify(book));
    }

    /**
     * delete请求，通过id删除book，请求参数放在请求路径中，使用@PathVariable注解接受数据
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(bookService.delete(id));
    }

    /**
     * get请求，通过id查询book，请求参数放在请求路径中
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, bookService.getById(id));
    }

    /**
     * 分页查询，有条件则按条件查询
     * @param curPage
     * @param pageSize
     * @param book
     * @return
     */
    @GetMapping("{curPage}/{pageSize}")
    public Result getPage(@PathVariable Integer curPage, @PathVariable Integer pageSize, Book book) {
        System.out.println(book);
        IPage<Book> page = bookService.getPage(curPage, pageSize, book);
        //如果当前页码值大于最大页码，则重新查询最后一页
        if (curPage > page.getPages()) {
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return  new Result(true, page);
    }


}