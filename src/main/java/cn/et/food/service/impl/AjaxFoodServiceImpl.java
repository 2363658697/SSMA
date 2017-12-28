package cn.et.food.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.AjaxFoodDao;
import cn.et.food.service.AjaxFoodService;



@Service
public class AjaxFoodServiceImpl implements AjaxFoodService{
	@Autowired
	private AjaxFoodDao ajaxFoodDao;


	public List<Map<String, Object>> queryFoodList(String foodName) {
		List<Map<String, Object>> list = ajaxFoodDao.queryFoodList(foodName);
		return list;
	}

	
	public void deleteFood(String foodId) {
		ajaxFoodDao.deleteFood(foodId);
	}

	
	public void updateFood(String foodId, String foodName, String price) {
		ajaxFoodDao.updateFood(foodId, foodName, price);
	}

	
	public void saveFood(String foodName, String price) {
		ajaxFoodDao.saveFood(foodName, price);
	}
}
