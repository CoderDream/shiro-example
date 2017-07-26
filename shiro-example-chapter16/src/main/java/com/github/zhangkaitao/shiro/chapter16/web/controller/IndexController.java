package com.github.zhangkaitao.shiro.chapter16.web.controller;

import com.github.zhangkaitao.shiro.chapter16.entity.Resource;
import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.service.ResourceService;
import com.github.zhangkaitao.shiro.chapter16.service.UserService;
import com.github.zhangkaitao.shiro.chapter16.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-2-14
 * <p>
 * Version: 1.0
 */
@Controller
public class IndexController {

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(@CurrentUser User loginUser, Model model) {
		Set<String> permissions = userService
				.findPermissions(loginUser.getUsername());
		List<Resource> menus = resourceService.findMenus(permissions);
		model.addAttribute("menus", menus);
		return "index";
	}

	@RequestMapping(value = "/getPermissions", method = RequestMethod.GET)
	public Set<String> getPermissions(String username) {
		Set<String> permissions = userService.findPermissions(username);
		// List<Resource> menus = resourceService.findMenus(permissions);
		// model.addAttribute("menus", menus);
		// return "index";

		return permissions;
	}
	
	@RequestMapping(value = "/getPermission", method = RequestMethod.GET)
	public String getPermission(String username) {
		Set<String> permissions = userService.findPermissions(username);
		// List<Resource> menus = resourceService.findMenus(permissions);
		// model.addAttribute("menus", menus);
		// return "index";

		return "permissions";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
