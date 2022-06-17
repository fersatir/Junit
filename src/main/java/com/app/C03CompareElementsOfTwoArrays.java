package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//methodun amacı T tipinde (generic tip) arrayların eşit olup olmadığının karşılaştırmasını yapar ve boolean sonuç döndürür
//genericler anlatılmadı küçük bir örneği
public class C03CompareElementsOfTwoArrays {
	
	List<String> name = new ArrayList<>();
	
		public <T> boolean compareElementsOfTwoArray(T[] a1,T[] a2) {
			Arrays.sort(a1);
			Arrays.sort(a2);
			
			if(Arrays.equals(a1, a2)) {
				return true;
			}else {
				return false;
			}
		}
}

