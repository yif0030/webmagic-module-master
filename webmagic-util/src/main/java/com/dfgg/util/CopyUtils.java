package com.dfgg.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CopyUtils {

	public CopyUtils() {
	}
	
	public static <T> List copyList(List<T> list) {
		if (CollectionUtils.isEmpty(list)) {
			return new ArrayList();
		}
		return JSON.parseArray(JSON.toJSONString(list), list.get(0).getClass());
	}
	
	public static Map<String, Object> copyMap(Map map) {
		return JSON.parseObject(JSON.toJSONString(map));
	}
}
