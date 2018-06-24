package com.niit.PokemartBackend.Dao;

import java.util.List;


import com.niit.PokemartBackend.Model.Supplier;

public interface SupplierDao {
	public boolean addSupplier(Supplier supplier);
	public Supplier getSupplier(int supplierId);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> getSuppliers();
}

	
