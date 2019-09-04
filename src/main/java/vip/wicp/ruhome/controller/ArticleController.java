package vip.wicp.ruhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.wicp.ruhome.system.entity.Article;
import vip.wicp.ruhome.system.exception.StatusCode;
import vip.wicp.ruhome.system.model.ResultBean;
import vip.wicp.ruhome.system.model.request.ArticleRequest;
import vip.wicp.ruhome.system.model.vo.PageInfo;
import vip.wicp.ruhome.system.service.IArticleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: ruhome
 * @description: 文章管理
 * @author: Mr.PY
 * @create: 2019-08-06 14:34
 **/
@RestController
@RequestMapping("/biz/article")
public class ArticleController {
    @Resource
    private IArticleService iArticleService;

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @RequestMapping("/ttt")
    public void ttt(){
        logger.info("hello Sfl4j + logback.....我是彭宇.");
        ExecutorService executorService = Executors.newFixedThreadPool(8);

    }

    /**
     * 确定上传文件的名称
     */
    private static final String UPLOAD_DIR = "travelImages";

    @RequestMapping("page")
    public PageInfo getPage(ArticleRequest articleRequest){
        Page<Article> page = new Page<>(articleRequest.getPage(), articleRequest.getRows());
        page.setDesc("update_time");
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", 0);
        iArticleService.page(page, queryWrapper);
        List<Article> records = page.getRecords();




        //封装分页数据
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCode(StatusCode.OK.getCode());
        pageInfo.setMsg(StatusCode.OK.getMessage());
        pageInfo.setData(records);
        pageInfo.setCount(page.getTotal());

        return pageInfo;
    }

    @RequestMapping("add")
    public ResultBean add(Article article){
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        boolean save = iArticleService.save(article);
        if (save){
            return new ResultBean(ResultBean.STATUS_NORMAL,"添加成功！",null);
        }else {
            return new ResultBean(ResultBean.STATUS_EXCEPTION,"添加失败！",null);
        }
    }

    @RequestMapping("travelImages")
    public Object uploadImg(HttpServletRequest request, @RequestParam("travelImages") MultipartFile travelImages){
        String photo = travelImages.getOriginalFilename();
        String uploadpath = request.getSession().getServletContext().getRealPath(UPLOAD_DIR);
        File parent = new File(uploadpath);
        String filename = System.nanoTime()+photo;
        File dest = new File(parent, filename);
        Map<String, Object> result = new HashMap<>();
        try {
            travelImages.transferTo(dest);
            //wangEditor富文本编辑器返回数据格式json{errno:0 , data:["图片的url"]}
            result.put("errno", 0);
            String[] data = {UPLOAD_DIR+"/"+filename};

            result.put("data", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
