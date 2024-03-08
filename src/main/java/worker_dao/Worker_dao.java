package worker_dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Component;

import worker_dto.Worker_dto;
@Component
public class Worker_dao  {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	
	
	public String insert( Worker_dto dc) {
		et.begin();
		em.persist(dc);
		et.commit();
		return "DATABASE IS CREATED";
		
		
	}


	public String deleteById(int wno) {
		// TODO Auto-generated method stub
		Worker_dto an = em.find(Worker_dto.class, wno); // this is for url re writing
		if(an!=null) {
			et.begin();
			em.remove(an);
			et.commit();
			return "data deleted";
		}
		
		return "deleted no data found";
	}
	
	public Object deleteAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select data from Worker_dto data " ); 
	    java.util.List<Worker_dto>      list=  q.getResultList();
		if(list.isEmpty()) {
			
			return "deleted no data found";
		
		} else {
			for(Object d:list)
			{
				et.begin();
				em.remove(d);
				et.commit();
			}
			
			return "data deleted";
		}
		
	}

public Object fetchById( int id) {
	Worker_dto  wc=em.find(Worker_dto.class, id);
	if(wc!=null) {
		return id;
	}
	return "NO DATA FOUND";
}
public Object fetchAll() {
	 Query q = em.createQuery("select data from Worker_dto data");
	 java.util.List<Worker_dto>  list= q.getResultList();
	 if(list.isEmpty()) {
		 return "NO DATA IN DATABASE";
	 } else {
		 
			 return list;
		 
	 }
   }
}
