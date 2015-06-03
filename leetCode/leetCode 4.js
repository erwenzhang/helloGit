/**
*@param {number[]} nums1
*@param {number[]} nums2
*@return {number}
*/

var tmp,tmp1;
var findMedianSortedArrays = function(nums1, nums2){
	var len1,len2;
	len1 = nums1.length;
	len2 = nums2.length;
	if((len1+len2)%2 == 0){
		var med1 = findKth (nums1,nums2,(len1+len2)/2-1,0,len1-1,0,len2-1);
		console.log('med1',med1);
		console.log(nums1,nums2);
		//console.log(nums1_tmp,nums2_tmp);
		var med2 = findKth(nums1,nums2,(len1+len2)/2,0,len1-1,0,len2-1);
		console.log('med2',med2);
		return (med1+med2)*0.5;
	}
	else
		return findKth(nums1,nums2,Math.floor((len1+len2)/2),0,len1-1,0,len2-1);
}

var findKth = function(nums1,nums2,k,aStart,aEnd,bStart,bEnd){

	var len1 = aEnd - aStart +1;
	var len2 = bEnd - bStart +1;
	//console.log('len1',len1);
	//console.log('len2',len2);
	if(len1 == 0)
		return nums2[bStart+k];
	if(len2 == 0)
		return  nums1[aStart+k];
	if(k == 0)
		return nums1[aStart]<nums2[bStart]?nums1[aStart]:nums2[bStart];
 	console.log('k',k);
 	//tmp = len1;
 	//tmp1 = len2;
	var med_cout1 = Math.floor(len1*k/(len1+len2));
	var med_cout2 = k - med_cout1 - 1;
	console.log(med_cout1);
	console.log(med_cout2);

	if(nums1[med_cout1+aStart]<nums2[med_cout2+bStart]){
		aStart = med_cout1 + aStart+1;
		bEnd = med_cout2 + bStart;
		k = k - med_cout1-1;
	}

	else{
		bStart = med_cout2 + bStart+1;
		aEnd = med_cout1 + aStart;
		 k = k - med_cout2-1;
	}


	return findKth(nums1,nums2,k,aStart,aEnd,bStart,bEnd);
}







var med = findMedianSortedArrays([1,2],[1,2]); 
console.log(med);