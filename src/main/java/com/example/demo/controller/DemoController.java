package com.example.demo.controller;





import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SchedualServiceHi;
import com.okdai.api.common.util.MD5;

import oracle.jdbc.OracleTypes;



@RestController
@RequestMapping("/demo")
public class DemoController{
	@Autowired
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(){
    	try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("I_USER_NO", "sysadmin");
			map.put("I_MAC_ADDRESS", "");
			map.put("I_IP_ADDRESS", "");
			map.put("I_IP_REGION", "");
			map.put("I_CLIENT_TYPE", "");
			map.put("I_LOGIN_PASS_VAL", MD5.md5_32("123456"));
			
			schedualServiceHi.setOrcIn(map);
			
			Map<String, Integer> map2 = new HashMap<String, Integer>();
			map2.put("R_OPKEY",OracleTypes.VARCHAR);
			map2.put("R_CODE",OracleTypes.VARCHAR);
			map2.put("R_MSG",OracleTypes.VARCHAR);
			map2.put("R_DATA1",OracleTypes.CURSOR);
			map2.put("R_DATA2",OracleTypes.CURSOR);
			map2.put("R_DATA3",OracleTypes.CURSOR);
			
			schedualServiceHi.setOrcOut(map2);
			String callName = "RQ_MNG.M_USER.USER_LOGIN";
			
			Map<Object, Object> resultMap = schedualServiceHi.creatPrcParam(callName, true);
			return resultMap.get("R_CODE").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
}
