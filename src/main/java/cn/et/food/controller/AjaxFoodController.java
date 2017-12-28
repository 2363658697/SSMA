package cn.et.food.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.food.service.AjaxFoodService;



@Controller
public class AjaxFoodController {
	@Autowired
	private AjaxFoodService ajaxFoodService;


	/**
	 * 直接返回对象 springmvc自动转换成json:需要配置消息转换器，引入jar包
	 * @param foodname
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAFoodList", method = RequestMethod.GET)
	public List<Map<String, Object>> queryFoodList(String foodName)
			throws Exception {
		List<Map<String, Object>> queryFoodList = ajaxFoodService
				.queryFoodList(foodName);
		return queryFoodList;
	}
	
	
	
	
	@RequestMapping(value = "/food", method = RequestMethod.POST)
	public String saveFood(String foodName,String price,OutputStream outputStream) throws Exception {
		try {
			ajaxFoodService.saveFood(foodName, price);
			outputStream.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			outputStream.write("0".getBytes("UTF-8"));
		}
		return null;
	}

	@RequestMapping(value = "/food/{foodId}", method = RequestMethod.PUT)
	public String updateFood(@PathVariable String foodId, String foodName,
			String price, OutputStream outputStream) throws Exception {
		try {
			ajaxFoodService.updateFood(foodId, foodName, price);
			outputStream.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			outputStream.write("0".getBytes("UTF-8"));
		}
		return null;
	}

	@RequestMapping(value = "/food/{foodId}", method = RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodId,
			OutputStream outputStream) throws Exception {
		try {
			ajaxFoodService.deleteFood(foodId);
			outputStream.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			outputStream.write("0".getBytes("UTF-8"));
		}
		return null;
	}

}
