package com.example.mybatis.mappers;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis.models.Child;
import com.example.mybatis.models.Parent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ChildMapperTest {

	@Autowired
	private ParentMapper parentMapper;
	
	@Autowired
	private ChildMapper childMapper;
	
	@Test
	public void insertAndRetrieveTest() {
		Parent parentToInsert = new Parent();
		parentToInsert.setName("Andrew");
		parentMapper.insert(parentToInsert);
		
		Child childToInsert = new Child();
		childToInsert.setName("Wallace");
		childToInsert.setParent_id(parentToInsert.getId());
		childMapper.insert(childToInsert);
		
		Child childRetrieved = childMapper.findById(childToInsert.getId());
		
		Assert.assertEquals(childToInsert.getName(), childRetrieved.getName());
		Assert.assertEquals(childToInsert.getParent_id(), childRetrieved.getParent_id());
	}

}
