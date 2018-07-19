package com.example.demo.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="okdai-jdbc")
public interface SchedualServiceHi {
	/**
	 * 入参
	 * 
	 * @param map
	 *            键（对应数据库表，列名） --- 值（可为null）
	 * @throws Exception
	 */
	@RequestMapping(value = "/jdbcService/setOrcIn", method = RequestMethod.GET)
	public void setOrcIn(@RequestParam("map") Map<String, String> map) throws Exception;

	/**
	 * 出参
	 * 
	 * @param map
	 *            键（存储过程出参参数，例："R_CODE"） --- 值（例： OracleTypes.VARCHAR 所对应值）
	 * @throws Exception
	 */
	@RequestMapping(value = "/jdbcService/setOrcOut", method = RequestMethod.GET)
	public void setOrcOut(@RequestParam("map") Map<String, Integer> map) throws Exception;

	/**
	 * 数据库请求封装接口
	 * 
	 * @param callName
	 *            存储名称
	 * @param type
	 * 				true  (销毁连接)
	 * 				false (不销毁)      
	 * @return Map<Object,Object>
	 * @throws Exception
	 *             sql异常
	 */
	@RequestMapping(value = "/jdbcService/creatPrcParam", method = RequestMethod.GET)
	public Map<Object, Object> creatPrcParam(@RequestParam("callName") String callName,@RequestParam("type") boolean type)throws Exception;
}
