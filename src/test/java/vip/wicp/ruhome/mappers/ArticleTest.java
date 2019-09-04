package vip.wicp.ruhome.mappers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.wicp.ruhome.system.entity.Article;
import vip.wicp.ruhome.system.mapper.ArticleMapper;

import javax.annotation.Resource;

/**
 * @program: ruhome
 * @description: 测试文章类
 * @author: Mr.PY
 * @create: 2019-08-06 14:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {
    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void insert(){
        Article article = new Article();
        article.setAuthor("pengyu");
        article.setContent("球进了");
        int insert = articleMapper.insert(article);
        if(insert == 1){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }
}
