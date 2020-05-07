package hu.ponte.hr.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import hu.ponte.hr.controller.ImageMeta;

@Service
@Transactional
public class ImageStore implements  CrudRepository<ImageMeta, String>{

	@PersistenceContext
	private EntityManager em;
	
	public ImageMeta getOne(String id) {
		return em.find( ImageMeta.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImageMeta> findAll() {
		Query query = em.createQuery("SELECT e FROM ImageMeta e");
	    return (List<ImageMeta>) query.getResultList();
	}

	@Override
	public <S extends ImageMeta> S save(S entity) {
		em.persist(entity);
		return null;
	}

	@Override
	public <S extends ImageMeta> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ImageMeta> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ImageMeta> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ImageMeta entity) {
		// TODO Auto-generated method stubpi/images/preview/id1pi/images/preview/id1
		
	}

	@Override
	public void deleteAll(Iterable<? extends ImageMeta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	


}
