package com.nanuvem.lom.business.entity;

import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.tests.entity.EntityTest;
import com.nanuvem.lom.business.BusinessFacade;
import com.nanuvem.lom.dao.neo4j.Neo4JDaoFactory;

public class BusinessEntityTest extends EntityTest {

	@Override
	public Facade createFacade() {
		return new BusinessFacade(new Neo4JDaoFactory());
	}

}
