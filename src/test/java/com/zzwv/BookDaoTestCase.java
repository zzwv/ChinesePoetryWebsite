package com.zzwv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzwv.dao.BookDao;
import com.zzwv.dao.ChinesePoetryAuthorDao;
import com.zzwv.dao.ChinesePoetryDao;
import com.zzwv.dao.RecommendDao;
import com.zzwv.dto.Book;
import com.zzwv.dto.Recommend;
import com.zzwv.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testGetPage(){
        // SELECT id,type,name,description FROM tbl_book LIMIT 5,5  从第六行开始，获取五行数据
        IPage page = new Page(2,5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy1(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        //if(name != null) lqw.like(Book::getName,name);		//方式一：JAVA代码控制
        lqw.like(name != null,Book::getName,name);				//方式二：API接口提供控制开关
        bookDao.selectList(lqw);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("测试数据abcdefg");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(16);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }
}


@SpringBootTest
class RecommendTestCase {

    @Autowired
    private RecommendDao recommendDao;

    @Test
    void testGetById(){
        Recommend recommend = recommendDao.selectById(70949);
        System.out.println(recommend.getId());
        System.out.println(recommend.getTitle());
        System.out.println(recommend.getDynasty());
        System.out.println(recommend.getWriter());
        System.out.println(recommend.getType());
        System.out.println(recommend.getContent());
        System.out.println(recommend.getRemark());
        System.out.println(recommend.getTranslation());
        String shangxi = recommend.getShangxi().replaceAll("　　","");
        System.out.println(shangxi);
    }

    @Test
    void testGetPage(){
        IPage page = new Page(2,5);

    }

    @Test
    void testSave(){
        Recommend recommend = new Recommend();
        recommend.setTitle("屈原塔");
        recommend.setType("端午节,风俗,怀古");
        recommend.setDynasty("宋代");
        recommend.setWriter("苏轼");
        recommend.setContent("楚人悲屈原，千载意未歇。惊魂飘何处，父老空哽咽。");
        recommend.setRemark("aa");
        recommend.setTranslation("bb");
        recommend.setShangxi("cc");
        recommendDao.insert(recommend);
    }

    @Test
    void testUpdate(){
        Recommend recommend = new Recommend();
        recommend.setId(17);
        recommend.setType("测试数据abcdefg");
        recommend.setTitle("测试数据123");
        recommend.setShangxi("测试数据123");
        recommendDao.updateById(recommend);
    }

    @Test
    void testDelete(){
        recommendDao.deleteById(16);
    }

    @Test
    void testGetAll(){
        recommendDao.selectList(null);
    }
}

@SpringBootTest
class BookServiceTest {
    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("-----------------");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.updateById(book);
    }
    @Test
    void testDelete(){
        bookService.removeById(18);
    }

    @Test
    void testGetAll(){
        bookService.list();
    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(2,5);
        bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}

@SpringBootTest
class ChinesePoetryAuthorDaoTest {
    @Autowired
    private ChinesePoetryAuthorDao chinesePoetryAuthorDao;

    @Test
    void testGetById(){
        System.out.println(chinesePoetryAuthorDao.selectById(1));
    }
}

@SpringBootTest
class ChinesePoetryDaoTest {
    @Autowired
    private ChinesePoetryDao chinesePoetryDao;

    @Test
    void testGetById(){
        System.out.println(chinesePoetryDao.selectById(1));
    }
}