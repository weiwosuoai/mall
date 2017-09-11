package com.allenmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allenmall.common.pojo.EasyUIDataGridResult;
import com.allenmall.common.pojo.EasyUITreeNode;
import com.allenmall.pojo.TbItem;
import com.allenmall.service.ItemCatService;
import com.allenmall.service.ItemService;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> findItemCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
		return itemCatService.findItemCatList(parentId);
	}
	

}
