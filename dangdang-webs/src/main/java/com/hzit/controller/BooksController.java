package com.hzit.controller;

import com.fc.platform.commons.page.Page;
import com.hzit.entity.Book;
import com.hzit.services.BookServices;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
@Controller
@RequestMapping("/controller")
public class BooksController  {
    @Autowired
    private BookServices  bookServices;

      @RequestMapping("/findbook")
      public  String findbook(@RequestParam(name="page",defaultValue = "0")Integer page,ModelMap modelMap){

          if(page<0){
              page=0;
          }
            Page<Book> pagebooks=bookServices.findpageall(page, 3);
             //获得分页的里面的内容，就是图书的信息
             List<Book>  books=pagebooks.getContent();
             //获得分页之后的总页数
                 int zongye=pagebooks.getTotalPages()-1;
          if (page>zongye) {
              page=zongye;
              books=bookServices.findpageall(page, 3).getContent();
          }
             //将总页数存起来
          modelMap.put("books", books);
                modelMap.put("zongye",zongye);
                modelMap.put("page",page);
          return "findallbooks";
      }
}
