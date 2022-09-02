package kr.co.greenart;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository//저장소라는 이름만 적은 컴포넌트
@Primary
public class MySetRepository implements MyDataRepository{
	@Override
	public Iterable<Integer> getMyNumbers() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(9);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(10);
			
		return set;
	}
	
}
