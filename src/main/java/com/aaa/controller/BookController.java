package com.aaa.controller;

import com.aaa.domain.Book;
import com.aaa.service.BookService;
import com.aaa.util.MyToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/book")
public class BookController {


    @Autowired
    private BookService bookService;
    /**
     * 返回到用户首页
     *
     * @return
     */
    @RequestMapping("/")
    public String reDash() {
        return "admin/dashboard";
    }

    @RequestMapping("/toDash")
    public String toDash() {
        return "admin/dashboard";
    }

    @RequestMapping("/showAllBook")
    public String showAllBook(HttpServletRequest request) {
        List<Book> books = bookService.queryAll();
        request.getSession().setAttribute("books",books);
        return "admin/dashboard";
    }

    /**
     * 跳转到添加图书页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "admin/addBook";
    }
    /**
     * 添加图书
     * 添加图书页面的GET请求处理方法
     *
     * @return
     */
    @RequestMapping("/addBook")
    public String addBookPage() {
        return "admin/addBook";
    }
    /**
     * 添加图书 接收表单提交的post请求方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(HttpServletRequest request) {
        log.info("进入添加图书！");
//        String token = request.getParameter("token");
//        if (!"xxxxxxxxx".equals(token)){
//            return "admin/addBook";
//        }
        String bookName = request.getParameter("bookName");
        String bookPrice = request.getParameter("bookPrice");
        String bookCover = request.getParameter("bookCover");
        String bookAuthor = request.getParameter("bookAuthor");
        System.out.println(request.getRemoteHost());

        if (MyToolUtil.checkEmpty(bookName, "bookName",request) ||MyToolUtil.checkEmpty(bookPrice, "bookPrice",request) ||MyToolUtil.checkEmpty(bookCover, "bookCover",request)||MyToolUtil.checkEmpty(bookAuthor, "bookAuthor",request))
            return "admin/addBook";  // 如果为空直接返回页面了
//        判断是否已存在该书
        Book getBook = bookService.queryByBookNameAndBookAuthor(bookName, bookAuthor);
        if (getBook != null) {
            log.info("存在数据");
            request.getSession().setAttribute("bmsg", "图书已存在！");
            return "admin/addBook";
        } else {
            log.info("写入数据");
            Book book = new Book();
            book.setBookName(bookName);
            book.setBookPrice(bookPrice);
            book.setBookCover(bookCover);
            book.setBookAuthor(bookAuthor);
            book.setCreateTime(new Date());
            book.setUpdateTime(new Date());
            bookService.addOne(book);
            List<Book> books = bookService.queryAll();
            request.getSession().setAttribute("books", books);
            return "admin/dashboard";
        }
    }

    /**
     * 根据图书名称进行模糊查询
     * @param request
     * @return
     */
    @RequestMapping("/searchByName")
    public String searchByName(HttpServletRequest request) {
        String bookName = request.getParameter("bookName");
        List<Book> books = bookService.queryAllByBookName(bookName);
        System.out.println(books);
        request.getSession().setAttribute("books",books);
        return "admin/dashboard";
    }

    /**
     * 根据作者名称进行模糊查询
     * @param request
     * @return
     */
    @RequestMapping("/searchByAuthor")
    public String searchByAuthor(HttpServletRequest request) {
        String bookAuthor = request.getParameter("bookAuthor");
        List<Book> books = bookService.queryAllByBookAuthor(bookAuthor);
        System.out.println(books);
        request.getSession().setAttribute("books",books);
        return "admin/dashboard";
    }

    /**
     * 逻辑删除图书
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id,HttpServletRequest request) {
        log.info("准备要删除这本书喽！！！");
        bookService.fakeDeleteBook(id);
        log.info("图书删除成功了哦！！！");
        List<Book> books = bookService.queryAll();
        request.getSession().setAttribute("books",books);
        return "admin/dashboard";
    }

    /**
     * 跳转到图书修改页面
     * @return
     */
    @RequestMapping("/updateBook/{id}")
    public String toUpdateBook(@PathVariable("id") int id,HttpServletRequest request) {
        Book book = bookService.queryAllById(id);
        request.getSession().setAttribute("book",book);
        return "admin/updateBook";
    }

    /**
     * 修改图书
     * @param book
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateBook",method =RequestMethod.POST)
    public String updateBook(Book book,HttpServletRequest request) {
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        bookService.updateBook(book);
        log.info("修改成功了！！！");
        List<Book> books = bookService.queryAll();
        request.getSession().setAttribute("books",books);
        return "admin/dashboard";
    }
}
