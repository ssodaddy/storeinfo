package com.ssodaddy.storeOpen;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import elasticsearch.ConnBean;

public class ConnBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String clusterName = "ssodaddy-application";
		String ip = "125.141.144.188";
		int port = 9222;
		boolean rstFlag = true;
		
		ConnBean elaConn = new ConnBean(clusterName, ip, port);
		rstFlag = elaConn.TryConnection();
		if(rstFlag){
			System.out.println("Succ.. connection");
			assertTrue(rstFlag);
			
			Map<String, Object> rstData = elaConn.getInfoFromId("classes", "class", "1");
			assertEquals((String)rstData.get("title"),"Algorithm");
		}
		
		fail("Not yet implemented");
	}

}
