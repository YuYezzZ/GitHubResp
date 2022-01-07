package com.yuye.controller;

import com.yuye.pojo.Role;
import com.yuye.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource(name="roleService")
    private RoleService roleService;
    @RequestMapping("/list")
    public ModelAndView roleAll() throws IOException {
        ModelAndView mav = new ModelAndView();
        List<Role> roleList = roleService.roleAll();
        System.out.println(roleList);
        mav.addObject("roleList",roleList);
        mav.setViewName("role-list");
        return mav;
    }
    @RequestMapping("/save")
    private String saveRole(Role role) throws IOException {
        roleService.saveRole(role);
        return "redirect:/role/list";
    }
}
