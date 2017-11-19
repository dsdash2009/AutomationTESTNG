package com.test.regression;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestMain{
	final static Logger logger = Logger.getLogger(TestMain.class);
	
	@Test
	public void test1(){
		logger.info("I am from test");

	}
	@BeforeClass
	public void test2(){
		logger.info("I am from beforeClass");

	}
	@AfterClass
	public void test3(){
		logger.info("I am from AfterClass");

	}
	
}
