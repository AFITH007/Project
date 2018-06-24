package com.niit.PokemartFrontend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.niit.PokemartBackend.Dao.SupplierDao;

import com.niit.PokemartBackend.Model.Supplier;



@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDao;

	boolean flag = true;
	

	@RequestMapping("/Supplier")
	public String showSupplier(Model m) {
		List<Supplier> listSuppliers = supplierDao.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);

		for (Supplier supplier : listSuppliers) {
			System.out.println(supplier.getSupplierName() + ",");
		}
		flag = false;
		return "Supplier";
	}

	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("supname") String supname, @RequestParam("supdesc") String supdesc,
			Model m) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(supname);
		supplier.setSupplierDesc(supdesc);

		supplierDao.addSupplier(supplier);

		List<Supplier> listSuppliers = supplierDao.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		flag = false;
		return "Supplier";
	}

	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDao.getSupplier(supplierId);
		
		supplierDao.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDao.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		flag=false;
		return "Supplier";
	}

	@RequestMapping("/updateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDao.getSupplier(supplierId);
		
		
		List<Supplier> listSuppliers=supplierDao.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		m.addAttribute("supplierInfo",supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplierInDB(@RequestParam("supid") int supplierId,@RequestParam("supname") String supplierName,
			@RequestParam("supdesc") String supplierDesc,Model m)
	{
		Supplier supplier=supplierDao.getSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		
		supplierDao.updateSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDao.getSuppliers();
		m.addAttribute("listCategories",listSuppliers);
		
		return "Supplier";
	}
}
