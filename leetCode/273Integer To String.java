public class Solution {
    public String numberToWords(int num){
    	String rets = "";
    	String[] arr = new String[]{""," Thousand"," Million"," Billion" };
      int  i = 0; 
    	while(num>0){
    		int chunk = num%1000;
    		String converted = convert(chunk);
    		if(converted.length()!=0)
    		    rets = (rets.length()==0)?converted+arr[i]:converted+arr[i]+" "+rets;
    		num = num/1000;
    		i++;
        }
        if(rets.length()==0) rets = "Zero";
        return rets;

    }

    public String convert(int chunk){
    	String[] arr1 = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    	String[] arr2 = new String[]{"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    	String[] arr3 = new String[]{"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    	String rets = "";
    	int i = 0;
    	int tmp = chunk%100;
    	chunk = chunk/100;
    	if(chunk!=0)  rets = arr1[chunk-1]+" Hundred";
    	if(tmp>0){
    	    if(rets.length()>0) rets = rets+ " ";
    		  if(tmp%10==0) rets = rets+arr2[tmp/10-1];
      		else if(tmp<10) rets = rets+arr1[tmp-1];
      		else if(tmp<20)  rets = rets+arr3[tmp-11];
      		else { 
              rets = rets+ arr2[tmp/10-1]+" "+arr1[tmp%10-1];
          }
    	}	    
      if(rets.length()==0) rets = "";
      return rets;
    
    }   

}
