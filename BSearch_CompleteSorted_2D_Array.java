import java.util.Arrays;

public class BSearch_CompleteSorted_2D_Array {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        System.out.println(Arrays.toString(bsearch(matrix,4)));
    }
    //Seraching target in the last two remaining rows.
    static int[] binarysearch(int[][] matrix,int target,int row,int cstart,int cend){
        while(cstart <= cend){
            int cmid=cstart+(cend-cstart)/2;
            if(target == matrix[row][cmid]){
                return new int[]{row,cmid};
            }
            if(target > matrix[row][cmid]){
                cstart=cmid+1;
            }
            else{
               cend=cmid-1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] bsearch(int[][] matrix,int target){
        int r=0;
        int c=matrix[0].length;
        if(r == 1){
            binarysearch(matrix,target,0,0,c-1);
        }
        int rstart=0;
        int rend=r-1;
        int cmid=c/2;
        while(rstart < (rend-1)){  //Checking till last two rows are obtained.
            int rmid=rstart+(rend-rstart)/2;
            if(matrix[rmid][cmid]==target){
                return new int[]{rmid,cmid};
            }
            if(matrix[rmid][cmid] > target){
                rend=rmid;
            }
            else{
                rstart=rmid;
            }
        }
        //Now we have two rows remaining
        //Checking in the centre colomns
        if(matrix[rstart][cmid]==target){
            return new int[]{rstart,cmid};
        }
        if(matrix[rstart+1][cmid]==target) {
            return new int[]{rstart + 1, cmid};
        }
        //Now check in the remaining 4 parts

        //Checking in 1st part
        if(matrix[rstart][cmid-1]>=target) {
            return binarysearch(matrix,target,rstart,0,cmid-1);
        }
        //Checking in 2nd part
        if(matrix[rstart][cmid+1]<=target && matrix[rstart][c-1]>=target) {
            return binarysearch(matrix,target,rstart,cmid+1,c-1);
        }
        //Checking in 3rd part
        if(matrix[rstart+1][cmid-1]>=target) {
            return binarysearch(matrix,target,rstart+1,0,cmid-1);
        }
        //Checking in 4th part
       else {
            return binarysearch(matrix,target,rstart+1,cmid+1,c-1);
        }
    }
}
