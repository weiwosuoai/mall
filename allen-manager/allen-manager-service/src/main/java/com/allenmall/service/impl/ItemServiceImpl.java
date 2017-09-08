package com.allenmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allenmall.mapper.TbItemMapper;
import com.allenmall.pojo.TbItem;
import com.allenmall.pojo.TbItemExample;
import com.allenmall.pojo.TbItemExample.Criteria;
import com.allenmall.service.ItemService;

/**
 * 商品管理 service
 * @author Allen
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem findItemById(long id) {
		// 根据查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andIdEqualTo(id);
		
		List<TbItem> list = itemMapper.selectByExample(example);
		
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
