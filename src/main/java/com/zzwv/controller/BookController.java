package com.zzwv.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzwv.dto.Book;
import com.zzwv.dto.R;
import com.zzwv.service.BookService;
import com.zzwv.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        List<Book> books = bookService.list();
        return R.ok(books);
    }

    @PostMapping
    public R save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        if (flag){
            return R.ok("保存成功！");
        }
        return R.error(4071,"保存失败！");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        boolean flag = bookService.modify(book);
        if (flag){
            return R.ok("更新成功！");
        }
        return R.error(4072,"更新失败！");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        boolean flag = bookService.delete(id);
        if (flag){
            return R.ok("删除成功！");
        }
        return R.error(4073,"删除失败！");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        return R.ok(book);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        return R.ok(page);
    }
}
