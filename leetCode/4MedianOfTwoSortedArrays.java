public float findMedianSortedArray(int[] array1, int[] array2){ 
  int total = array1.length+array2.length;
  if(total%2 == 1) return findKthElement(array1, 0, array2, 0, total/2+1);
  else{
      float mid1 = findKthElement(array1, 0, array2, 0, total/2);
      float mid2 = findKthElement(array1, 0, array2, 0, total/2+1);
      return (mid1+mid2)/2.0;
  } 
}

public float findKthElement(int[] array1, int lo1, int[] array2, int lo2, int k){
   if(lo1 >= array1.length) return array2[lo2+k-1];
   if(lo2 >= array2.length) return array1[lo1+k-1];
   if(k == 1) return Math.min(array1[lo1],array2[lo2]);
  
   int kth1 = (lo1+k/2-1)<array1.length?array1[lo1+k/2-1]:Integer.MAX_VALUE;
   int kth2 = (lo2+k/2-1)<array2.length?array2[lo2+k/2-1]:Integer.MAX_VALUE;
   if(kth1<kth2){
       return findKthElement(array1, lo1+k/2, array2, lo2, k - k/2);
   }else{
       return findKthElement(array1, lo1, array2, lo2+k/2, k -  k/2);
   }  
}
