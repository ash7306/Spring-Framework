package kr.co.greenart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("mylist")
public class MyListRepository implements MyDataRepository{
	@Autowired
	private List<Integer> list;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		//여러개의 객체가 이터레이터를 통해 가져올수 있게 정의되어음
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);	
//		list.add(1);	
//		list.add(2);	
//		list.add(4);	
//		list.add(5);	

//		Iterator<Integer> iter = list.iterator();
//		while(iter.hasNext()) {
//			iter.next();
//		}
		return list;
	}
}
