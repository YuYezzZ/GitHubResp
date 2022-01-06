package com.yuye.controller;

import com.alibaba.fastjson.JSON;
import com.yuye.pojo.User;
import com.yuye.pojo.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username", "money"})
    public String save() {
        System.out.println("Controller save running");
        //配置viewResolver前
        /*return "redirect:/jsp/success.jsp";*/
        //    配置viewResolver后
        return "success";
    }
    @RequestMapping( "/quick2")
    public String save2() {

        return "success";
    }
    @RequestMapping( "/quick3")
    public ModelAndView save3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping( "/quick4")
    public ModelAndView save4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping( "/quick5")
    public ModelAndView save5(ModelAndView modelAndView) {
        modelAndView.addObject("name","李四");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping( "/quick6")
    public String save6(Model model) {
        model.addAttribute("name","王五");
        return "success";
    }
    @RequestMapping( "/quick7")
    public String save7(HttpServletRequest request) {
        request.setAttribute("name","小明");
        return "success";
    }
    @RequestMapping( "/quick8")
    public void save8(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello response");
    }
    @RequestMapping("/quick9")
    @ResponseBody
    public String save9(){
        return "hello world!";
    }
    @RequestMapping("/quick10")
    @ResponseBody
    public String save10(){
        User user = new User("zs", 12);
        User user2 = new User("ls", 13);
        return "[{\"username\":\""+user.getUsername()+"\",\"age\":\""+user.getAge()+"\" },{\"username\":\""+user2.getUsername()+"\",\"age\":\""+user2.getAge()+"\" }]";
    }
    @RequestMapping("/quick11")
    @ResponseBody
    public String save11(){
        User user = new User("zs", 12);
        User user2 = new User("ls", 13);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        String json = JSON.toJSONString(users);
        return json;
    }
    @RequestMapping("/quick12")
    @ResponseBody
    public User save12() throws IOException {
        User user = new User("zhangsan", 15);
        return user;
    }
    @RequestMapping("/quick13")
    @ResponseBody
    public List<User> save13() throws IOException {
        User user = new User("zhangsan", 15);
        User user2 = new User("lisi", 15);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        return list;
    }
    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(String username,int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }
    @RequestMapping("/quick15")
    @ResponseBody
    public void save14(User user) throws IOException {
        System.out.println(user);
    }
    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(String strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }
    @RequestMapping("/quick17")
    @ResponseBody
    public void save17(VO vo) throws IOException {
        System.out.println(vo);
    }
    @RequestMapping("/quick18")
    @ResponseBody
    public void save18(@RequestParam(value="username",required=false,defaultValue = "zhangsan") String  name) throws IOException {
        System.out.println(name);
    }
    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(@RequestBody List<User> userList){
        System.out.println(userList);
    }
    @RequestMapping("/quick20/{username}")
    @ResponseBody
    public void save20(@PathVariable(value="username" ,required = false) String name){
        System.out.println(name);
    }
    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(Date date){
        System.out.println(date);
    }
    @RequestMapping("/quick22")
    @ResponseBody
    public void save22(HttpServletResponse response, HttpServletRequest request, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }
    @RequestMapping("/quick23")
    @ResponseBody
    public void save23(/*HttpServletRequest req*/@RequestHeader("User-Agent") String user_agent){
        /*String header = req.getHeader("User-Agent");
        System.out.println(header);*/
        System.out.println(user_agent);
    }
    @RequestMapping("/quick24")
    @ResponseBody
    public void save24(@CookieValue(value = "JSESSIONID",required = false) String json){
        System.out.println(json);
    }
    @RequestMapping("/quick25")
    @ResponseBody
    public void save25(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        //上传文件名称
        String originalFilename = uploadFile.getOriginalFilename();
        System.out.println(originalFilename);
        uploadFile.transferTo(new File("E:\\JavaFile\\Test\\aa\\"+originalFilename));
    }
    @RequestMapping("/quick26")
    @ResponseBody
    public void save26(String username, MultipartFile[] uploadFiles) throws IOException {
        System.out.println(username);
        //上传文件名称
        for (MultipartFile uploadFile : uploadFiles) {
            String originalFilename = uploadFile.getOriginalFilename();
            System.out.println(originalFilename);
            uploadFile.transferTo(new File("E:\\JavaFile\\Test\\aa\\"+originalFilename));
        }

    }
}
