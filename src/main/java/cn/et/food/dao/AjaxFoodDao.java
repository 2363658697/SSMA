package cn.et.food.dao;

import java.util.List;
import java.util.Map;

public interface AjaxFoodDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.lesson6.dao.impl.AjaxFoodDao#getFoodList(java.lang.String)
	 */
	public abstract List<Map<String, Object>> queryFoodList(String foodName);

	public abstract void deleteFood(String foodId);

	public abstract void updateFood(String foodId, String foodName, String price);

	public abstract void saveFood(String foodName, String price);

}