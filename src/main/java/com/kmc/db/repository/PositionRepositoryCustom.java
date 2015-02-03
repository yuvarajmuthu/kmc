package com.kmc.db.repository;

import java.util.Set;

import com.kmc.db.model.Organization;
import com.kmc.db.model.PositionNeo;
import com.kmc.db.relationship.Role;

public interface PositionRepositoryCustom{
	public void createPosition(PositionNeo position);
	public Object getPositionGraph();
	public void relatePositions(PositionNeo childPosition, PositionNeo parentPosition, String relationName);
	public void associateToOrganization(PositionNeo position, Organization org, String relationName);
	public Set<PositionNeo> getManagers(PositionNeo childPosition);
	public Set<PositionNeo> getReportees(PositionNeo parentPosition);
}
