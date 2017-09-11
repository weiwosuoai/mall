package com.allenmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allenmall.common.pojo.EasyUIDataGridResult;
import com.allenmall.common.pojo.EasyUITreeNode;
import com.allenmall.mapper.TbItemCatMapper;
import com.allenmall.mapper.TbItemMapper;
import com.allenmall.pojo.TbItem;
import com.allenmall.pojo.TbItemCat;
import com.allenmall.pojo.TbItemCatExample;
import com.allenmall.pojo.TbItemCatExample.Criteria;
import com.allenmall.service.ItemCatService;
import com.allenmall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 商品分类 service
 * @author Allen
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITreeNode> findItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		List<EasyUITreeNode> nodeList = new ArrayList<>();
		for (TbItemCat ic : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(ic.getId());
			node.setText(ic.getName());
			node.setState(ic.getIsParent() ? "closed" : "open");
			
			nodeList.add(node);
		}
		return nodeList;
	}


}
