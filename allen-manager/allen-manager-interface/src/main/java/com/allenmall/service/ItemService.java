package com.allenmall.service;

import com.allenmall.common.pojo.EasyUIDataGridResult;
import com.allenmall.pojo.TbItem;

public interface ItemService {
	
	TbItem findItemById(long id);
	
	EasyUIDataGridResult findItemList(int page, int rows);

}
