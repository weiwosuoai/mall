package com.allenmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allenmall.pojo.TbItem;
import com.allenmall.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("items/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId) {
		return itemService.findItemById(itemId);
	}

}
