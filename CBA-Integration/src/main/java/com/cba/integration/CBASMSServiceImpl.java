package com.cba.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CBASMSServiceImpl 
implements CBASMSService{
	@Autowired
private RestTemplate restTemplate;
	public String sendSms(String mobile, String sms, String tempid) {
	 	String uid = "uid="+"73617469736862";
		String pin = "&pin="+"25669ce0d7a59af99f1c65929f08cac3";
		String sender = "&sender="+"MYTBUS";
		String route = "&route="+"5";
		String pushid = "&pushid=1";
   String url="http://sms.paceinfonet.com/api/sms.php?"+uid+pin+route+sender+"&"+tempid+pushid+"&"+sms+"&"+mobile;
    	String status=restTemplate.getForObject(url,String.class);
		return status;
	}
	

}
