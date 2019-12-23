package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Scanner;

@RestController
@RequestMapping("test")
public class TestController {

    /**
     * test 输入
     * @return String
     */
    @RequestMapping(value = ("/in"), method = RequestMethod.GET)
    public String in()
    {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
        return "Hi, "+ name   +  " you are " + age;
    }

    @RequestMapping(value = ("/array/sort"), method = RequestMethod.GET)
    /**
     * 冒泡排序
     */
    public String  sort()
    {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println(Arrays.toString(ns));
        System.out.println(ns.length);
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                //可以根据 < > 来做升序降序
                if (ns[j] < ns[j+1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns));
        return  Arrays.toString(ns);
    }

    /**
     *
     * @param Request
     * @return
     */
    @RequestMapping(value = ("/number"), method = RequestMethod.GET)
    public  int sum(HttpServletRequest Request) {

        var number = Request.getParameter("number");
        int n = Integer.parseInt(number);

        if(n <= 2) {
            return  n;
        }
        int pre1 = 1;
        int pre2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++){
            sum =  pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }
        return sum;
    }
}
