package com.hzit.controller;

import com.hzit.entity.Book;
import com.hzit.services.BookServices;
import com.hzit.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Contended;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/10.
 */
@Controller
@RequestMapping("/controller")
public class ShoppingCarController {
   @Autowired
    private BookServices bookServices;
     @RequestMapping("/putshoppingcar")
      public  String putcar(@RequestParam(name="bookId")String []bookId,HttpSession session){
       //首先获得购物车，如果没有就创建
               Map car=(Map)session.getAttribute("car");
         if(car==null){
                car=new HashMap();
         }
      //根据传进来的图书编号查询图书信息，之后再放进购物车
          int sum=0;
           for(int i=0;i< bookId.length;i++){
                   Book  book=bookServices.findbookbyid(bookId[i]);
               BookVo   bookVo=new BookVo();
                  bookVo.setBookName(book.getBookName());
                  bookVo.setBookId(book.getBookId());
                  bookVo.setBookPrice(book.getBookPrice());
                  bookVo.setBookPic(book.getBookPic());
                BookVo  bookVo1=(BookVo)car.get(bookVo.getBookId());
               if(bookVo1==null){
                    bookVo.setBookCount(1);
               }else{
                   bookVo.setBookCount(bookVo1.getBookCount()+1);
               }
                car.put(bookVo.getBookId(),bookVo);
               sum+=bookVo.getBookCount()*bookVo.getBookPrice();
           }
                session.setAttribute("car",car);
                session.setAttribute("sum",sum);
         return "shopping";
     }
}
