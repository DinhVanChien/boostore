package com.example.bookstore.nativequery;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookstore.dto.StoreDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Store;
import com.example.bookstore.util.Common;

@Repository
public class StoreNative {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Store> stores(StoreDto storeDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select * from store ");
		boolean isCheck = false;
		if(storeDto.getName() != null && storeDto.getName().length() != 0) {
			sql.append(" where ADDRESS = :address ");
			isCheck = true;
		}
		sql.append("OFFSET :ofset ROWS FETCH NEXT :limit ROWS ONLY");
		Query<Store> query = (Query) entityManager.createNativeQuery(sql.toString(), Store.class);
		if(isCheck) {
			query.setParameter("address", storeDto.getName());
		}
		query.setParameter("limit", storeDto.getLimit());
		query.setParameter("ofset", storeDto.getOffset());
		return query.getResultList();
	}
	
	public int totalStore(StoreDto storeDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select COUNT(ID) FROM STORE");
		boolean isCheck = false;
		if(storeDto.getName() != null && storeDto.getName().length() != 0) {
			sql.append(" WHERE ADDRESS = :address ");
			isCheck = true;
		}
		Query query = (Query) entityManager.createNativeQuery(sql.toString());
		if(isCheck) {
			query.setParameter("address", storeDto.getName());
		}
		Number total = (Number) query.uniqueResult();
		return total.intValue();
	}
	
	// Tìm các store có trong book > 2
	
		public List<Store> searchStore() {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from store s where 1 < (select count(b.STORE_ID1) "
					+ "from book b where b.STORE_ID1 = s.id )");
			List<Store> stores = new ArrayList<Store>();
			Collection<?> c = entityManager.createNativeQuery(sql.toString(), Store.class).getResultList();
			stores = Common.castList(Store.class, c);
			return stores;
		}

}
