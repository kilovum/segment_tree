import java.util.*;

class NumArray {
    
    private int tree[];
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[2*n];
        for(int i = n;i < 2*n;i++){
            tree[i] = nums[i-n];
        }
        for(int i = n-1;i > 0;i--){
            tree[i] = tree[2*i] + tree[2*i+1];
        }
        System.out.println(Arrays.toString(tree));
        
        
    }
    
    public void update(int index, int val) {
        
        index = index + n;
        tree[index] = val;
        
        for(int i = index/2;i > 0;i = i/2){
            
            tree[i] = tree[2*i] + tree[2*i+1];
        }
        
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        left = left + n;
        right = right + n;
        while(left <= right){
            if(left%2 != 0){

                sum += tree[left++];
            }

            if(right%2 == 0){

                sum += tree[right--];
            }
         

            left /= 2;
            right /= 2;
        }
        return sum;
        
        
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
