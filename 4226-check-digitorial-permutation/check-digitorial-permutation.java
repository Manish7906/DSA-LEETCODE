class Solution {
    public boolean isDigitorialPermutation(int n) {
        int original=n;
        int res=0;
        while(n>0){
            int rem=n%10;
            res+=fact(rem);
            n=n/10;
        }
        int freq[]=new int[10];
        int temp=original;
        while(temp>0){
            freq[temp%10]++;
            temp/=10;
        }
        while(res>0){
            freq[res%10]--;
            res/=10;
        }
        for(int i=0;i<10;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
    private int fact(int i){
        int facts=1;
        for(int j=1;j<=i;j++){
            facts*=j;
        }
        return facts;
    }
}