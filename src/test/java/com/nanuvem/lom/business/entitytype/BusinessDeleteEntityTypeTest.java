package com.nanuvem.lom.business.entitytype;

import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.tests.entitytype.DeleteEntityTypeTest;
import com.nanuvem.lom.business.BusinessFacade;
import com.nanuvem.lom.dao.neo4j.Neo4JDaoFactory;

public class BusinessDeleteEntityTypeTest extends DeleteEntityTypeTest {

	@Override
	public Facade createFacade() {
		return new BusinessFacade(new Neo4JDaoFactory());
	}

}
