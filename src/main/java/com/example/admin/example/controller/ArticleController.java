package com.example.admin.example.controller;

import com.example.model.ArticleClassModel;
import com.example.service.admin.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ArticleController extends BaseController{

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = ("/article-class-index"), method = RequestMethod.GET)
    public String classIndex(ModelMap map)
    {
        map.addAttribute("name", "变量传值");
        return "article/class_index";
    }

    /**
     * 分类数据
     * @return
     */
    @RequestMapping(value = ("/article-class-list"), method = RequestMethod.POST)
    @ResponseBody
    public Map classList(HttpServletRequest request)
    {
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        int offset = (page-1)*limit;

        List data = this.articleService.getArticleClassDao().articleClassList(offset,limit);
        int count = this.articleService.getArticleClassDao().articleClassCount();

        return apiSuccess("分类列表",data,count);
    }

    public String ClassEdit(HttpServletRequest request,ModelMap map)
    {
        int id = Integer.parseInt(request.getParameter("id"));

        ArticleClassModel articleClass = this.articleService.getArticleClassDao().articleClassFirst(id);

        map.addAttribute("class_name",articleClass.getClassName());
        
        return "article/class_edit";
    }
}
