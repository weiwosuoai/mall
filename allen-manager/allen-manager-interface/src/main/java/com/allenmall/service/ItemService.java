package com.allenmall.service;

import com.allenmall.common.pojo.EasyUIGridResult;
import com.allenmall.pojo.TbItem;

public interface ItemService {
	
	TbItem findItemById(long id);
	
	EasyUIGridResult findItemList(int page, int rows);

}
