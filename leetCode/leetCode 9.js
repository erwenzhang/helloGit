/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
 	//x = Math.abs(x);
 	if(x<0)
 		return false;
 	if(x<=9)
 	return true;
 
             
       var base = 1;
        while(x / base >= 10)
            base *= 10;
        console.log(base)

        while(x){
        	var left = Math.floor(x/base);
        	console.log(left);

        	var right = x%10;
        	console.log(right);
        	if(left!==right)
        		return false;
        	x = x-left*base;
	base /=100;
	x  = Math.floor(x/10);
        	console.log(base);

        }
        return true;



};

console.log(isPalindrome(1000021));



