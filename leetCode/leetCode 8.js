var myAtoi = function(str){
	if(str == "")
		return  0;
	var len = str.length;
	var result = 0;
	var flag;
	var i = 0;
	while(str[i] === " "){
		i++;
	}

	if(str[i] == '+'){
		flag = true;
	}
	else if(str[i] == '-'){
		flag = false;
	}
	else if(str[i]  <= '9' && str[i] >= '0'){
		result = Number(str[i]);
		flag = true;
	}
	else
		return 0;
	i++;
	//if(str[i]  < = '9' && str[i] >= '0'){
		while(str[i]  <= '9' && str[i] >= '0'){
			var tmp = Number(str[i]);
			result = result*10 + tmp;
			i++;	
		}
		if(result >2147483647)
			if(flag)
			return 2147483647;
			else return -2147483648;
		else 
			if(flag)
			return result;
			else return 0-result;
		

//	}
//	else
//	return 0;
}

var myNumber = myAtoi("    0001");
console.log(myNumber);
console.log(typeof(myNumber));