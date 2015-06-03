/**
*@param {string} s
*@return {number}
*/
var lengthOfLongestSubstring = function(s) {
	var hash_longest = [];
	var len = s.length;
	var result = 0;
	var start = 0;


	//var flag = false;
	//console.log(s[9]);
//	hash_longest[s[i]] = 1;
//	console.log(hash_longest[s[i]]);


	for(var i = 0; i < len; i++){
		//console.log(s[i]);
	//	console.log(hash_longest[s[i]]);
		if(hash_longest[s[i]] == undefined)
			hash_longest[s[i]] = i;
		else{
			result = Math.max(result,i-start)
			start = hash_longest[s[i]]+1;
			hash_longest = [];
			hash_longest[s[i]] = i; 
		

		}
		console.log(i);
		
		
	}

	return  Math.max(result,len - start);



		
	

   

}; 
//lengthOfLongestSubstring("dvdf" );
console.log(lengthOfLongestSubstring("vqblqcb" ));