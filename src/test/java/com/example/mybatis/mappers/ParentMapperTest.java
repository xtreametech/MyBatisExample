package com.example.mybatis.mappers;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis.models.Parent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ParentMapperTest {

	@Autowired
	private ParentMapper parentMapper;
	
	@Test
	public void insertAndRetrieveTest(){
		Parent parentToInsert = new Parent();
		parentToInsert.setName("parentToInsert");
		parentMapper.insert(parentToInsert);
		Parent parentRetrieved = parentMapper.findById(parentToInsert.getId());
		Assert.assertEquals(parentToInsert.getName(), parentRetrieved.getName());
	}
	
	
}
