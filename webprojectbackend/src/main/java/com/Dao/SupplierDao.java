package com.Dao;

import java.util.List;

import com.model.Supplier;

public interface SupplierDao 
{
	public boolean insertSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	
	public 	Supplier getSupplierByid(int sid);
	
	public List<Supplier> getAllSuppliers();

	
}
