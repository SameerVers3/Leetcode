class Solution {
    public int minSteps(int n) {
        int curr=1;
        int ans=0;
        int currCpy=0;
        while(curr<n){
            if(n%curr==0){
                currCpy=curr;
                ans++;
            }
            curr+=currCpy;
            ans++;
        }
        return ans;       
    }
}