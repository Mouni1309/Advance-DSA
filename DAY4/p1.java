// floodfill algorithm using dfs with recursion
import java.util.*;
class p1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int image[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                image[i][j]=sc.nextInt();
            }
        }
        int sr=sc.nextInt();
        int sc1=sc.nextInt();
        int newColor=sc.nextInt();
        int res[][]=floodFill(image,sr,sc1,m,n,newColor);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] floodFill(int image[][],int sr, int sc1, int m,int n, int newColor){
        if(image[sr][sc1]==newColor) 
            return image;
        int oldColor=image[sr][sc1];
        dfs(image,sr,sc1,m,n,oldColor,newColor);
        return image;
    }
    public static void dfs(int image[][], int sr, int sc1, int m, int n, int oldColor, int newColor){
        if(sr<0 || sr>=m || sc1<0 || sc1>=n || image[sr][sc1]!=oldColor) 
            return;
        image[sr][sc1]=newColor;
        dfs(image,sr+1,sc1,m,n,oldColor,newColor);
        dfs(image,sr-1,sc1,m,n,oldColor,newColor);
        dfs(image,sr,sc1+1,m,n,oldColor,newColor);
        dfs(image,sr,sc1-1,m,n,oldColor,newColor);
    }
}