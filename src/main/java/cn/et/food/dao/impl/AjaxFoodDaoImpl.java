package cn.et.food.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.et.food.dao.AjaxFoodDao;
import cn.et.food.mapper.FoodMapper;


@Repository
public class AjaxFoodDaoImpl implements AjaxFoodDao{
	@Autowired
	FoodMapper foodMapper;


	public List<Map<String, Object>> queryFoodList(String foodName) {
		return foodMapper.queryFoodList(foodName);
	}

	
	public void deleteFood(String foodId) {
		foodMapper.deleteFood(foodId);
	}

	public void updateFood(String foodId, String foodName, String price) {
		foodMapper.updateFood(foodId, foodName, price);
	}

	public void saveFood(String foodName, String price) {
		foodMapper.saveFood(foodName, price);
	}

}
