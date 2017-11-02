package com.joshi.webprojectbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.SupplierDao;
import com.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) 
	{	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		Supplier supplier = (Supplier)context.getBean("supplier");
		/*supplier.setSid(10);
		supplier.setSname("kuldeep");
		supplier.setDescription("Garments Supplier");
		
		supplier.setSid(11);
		supplier.setSname("neeraj");
		supplier.setDescription("Tie Supplier");*/
		
		SupplierDao dao = (SupplierDao)context.getBean("supplierDao");
		//dao.insertSupplier(supplier);
		
		Supplier supp = dao.getSupplierByid(11);
		//System.out.println(supp.getSid() + " : " + supp.getSname());
		
		//dao.deleteSupplier(supp);
		
		supp.setSname("neon");
		dao.updateSupplier(supp);
		
		context.close();
	}
}
