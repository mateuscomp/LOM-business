package com.nanuvem.lom.business.entitytype;

import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.tests.entitytype.UpdateEntityTypeTest;
import com.nanuvem.lom.business.BusinessFacade;
import com.nanuvem.lom.dao.neo4j.Neo4JDaoFactory;

public class BusinessUpdateEntityTypeTest extends UpdateEntityTypeTest {

	@Override
	public Facade createFacade() {
		return new BusinessFacade(new Neo4JDaoFactory());
	}

}
