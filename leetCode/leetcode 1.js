/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */


var convert = function(s, numRows) {
	var convert_s = "";	
	var convert_rear = "";
	var length = s.length;
	if(numRows <= 1||length <= 2||numRows>=length)
	return s;
	
	

	for(var j = 0; j<numRows; j++){
		
	for(var i = numRows+numRows-2-j; i<length; i+=numRows+numRows-2){
		convert_s+=s[i-numRows-numRows-2+j+j]+s[i];
	
	}
	convert_s+=s[j];
	}
	
	return convert_s;
};
console.log(convert("123456",3));
var x=10e2;
console.log(x.toString().length);
