// floodfill algorithm using bfs
import java.util.*;
class p2{
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
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[] {sr,sc1});
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        while(!q.isEmpty()){
            int p[]=q.poll();
            for(int j=0;j<4;j++){
                int x=p[0]+dx[j];
                int y=p[1]+dy[j];
                if(x>=0 && x<m && y>=0 && y<n && image[x][y]==oldColor){
                    image[x][y]=newColor;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return image;
    }
}