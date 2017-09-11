package com.allenmall.service;

import java.util.List;

import com.allenmall.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	
	List<EasyUITreeNode> findItemCatList(long parentId);

}
