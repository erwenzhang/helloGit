/**
*@param {string} s
*@return {number}
*/
var lengthOfLongestSubstring = function(s) {
	var start = 0;
	var result = 0;
	var flag = [];
	var len = s.length;

	for(var i = 0; i < len; i++){
		if(flag[s[i]] == undefined)
			flag[s[i]] = 1;
		else{
			
			result = Math.max(i - start, result)
			for(var j = start; s[j]!=s[i];j++){
			    flag[s[j]] = undefined;
			    console.log('j',j);
			}
			start = j+1;
		}
		console.log(i);


	}

	
	result = Math.max(len - start, result)
	return result;
}; 
//lengthOfLongestSubstring("dvdf" );
console.log(lengthOfLongestSubstring("vqblqcb" ));