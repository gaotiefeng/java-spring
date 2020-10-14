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

    //文章分类列表
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

    //分类编辑页面
    @RequestMapping(value = ("/article-class-add"))
    public String classAdd(HttpServletRequest request,ModelMap map)
    {
        String str = request.getParameter("id");
        
        if (str != null &&!"".equals(str.trim())) {
            int id = Integer.parseInt(str);

            ArticleClassModel articleClass = this.articleService.getArticleClassDao().articleClassFirst(id);

            map.addAttribute("class_name",articleClass.getClassName());
            map.addAttribute("sort",articleClass.getSort());
            map.addAttribute("id",articleClass.getId());
        }

        return "article/class_edit";
    }

    //更新添加分类
    @RequestMapping(value = ("/article-class-save"),method = RequestMethod.POST)
    @ResponseBody
    public Map classSaveData(HttpServletRequest request)
    {
        int id = 0;
        String str = request.getParameter("id");
        if (str != null &&!"".equals(str.trim())) {
            System.out.println(str);
            id = Integer.parseInt(str);
        }

        String className = request.getParameter("class_name");
        int sort = Integer.parseInt(request.getParameter("sort"));

        int res = this.articleService.classSave(id,sort,className);

        return this.apiSuccess("更新成功",res);
    }

    //删除分类
    @RequestMapping(value = ("/article-class-del"),method = RequestMethod.POST)
    @ResponseBody
    public Map classDel(HttpServletRequest request)
    {
        int id = Integer.parseInt(request.getParameter("id"));

        int res = this.articleService.getArticleClassDao().articleClassDelete(id);

        return this.apiSuccess("删除成功",res);
    }
}
