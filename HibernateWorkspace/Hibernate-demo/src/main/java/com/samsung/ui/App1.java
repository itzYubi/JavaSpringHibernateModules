package com.samsung.ui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.samsung.entity.Job;

public class App1 {
     
	public static void main(String[] args)
	{
		Configuration conf= new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(Job.class);
		
		SessionFactory factory= conf.buildSessionFactory();
		Session session = factory.openSession();
		
		Job job=new Job();
		job.setJobId("j9");
		job.setJobTitle("SDE intern");
		job.setMinSalary(30000);
		job.setMaxSalary(31000);
		Transaction txn = session.getTransaction();
		txn.begin();
		session.save(job);
		txn.commit();
		System.out.println("job saved.");
		session.close();
		factory.close();
	}
}
