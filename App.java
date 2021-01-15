import java.util.Scanner;

public class App {

    public static int[] [] rightArray(int n, int m,int [][]myArray){  //this segment is for building the second layer
        int[][] list = new int[n][m];       //function output array
        int br = 0;
            for (int i = n-1; i >= 0; i-=2) {
                for (int j = 0; j < myArray[i].length; j+=4) {
                    if (myArray[i][j] == myArray[i][j+1]) {
                        list[i][j] = 2+br*4;
                        list[i-1][j] = 2+br*4;
                        list[i][j+1] = 3+br*4;
                        list[i][j+2] = 3+br*4;
                        list[i-1][j+1] = 1+br*4;
                        list[i-1][j+2] = 1+br*4;
                        list[i][j+3] = 4+br*4;
                        list[i-1][j+3] = 4+br*4;
                    }
                    else {
                        list[i][j] = 3+br*4;
                        list[i][j+1] = 3+br*4;
                        list[i-1][j+1] = 1+br*4;
                        list[i-1][j] = 1+br*4;
                        list[i-1][j+2] = 2+br*4;
                        list[i-1][j+3] = 2+br*4;
                        list[i][j+3] = 4+br*4;
                        list[i][j+2] = 4+br*4;
                    }
                    br++;
                }
            }
        return list;
   }
    
    
    public static void main(String[] args) throws Exception {
        Scanner myScnaner = new Scanner(System.in);
        int n;      //row of array
        int m;      //coloms of array
        boolean flag_err = false;        //flag for a wrong input or no way to be build 
        n = myScnaner.nextInt();    
        m = myScnaner.nextInt();    
        if (n < 0 || n % 2 != 0) {
            flag_err = true;
        }
        if (m < 0 || m % 2 != 0) {
            flag_err = true;
        }   
        int myArray[] [] = new int[n] [m];        //input array
        int myTrueArray[] [] = new int [n][m];    //output array
        if (flag_err == false) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    myArray[i][j] = myScnaner.nextInt();
                    if (myArray[i][j] < 0) {
                        flag_err = true;
                    }   
                }    
            } 
        }    
        if (flag_err == false) {             //check for impossible solution
            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j+=4) {
                      
                      if (j + 2 <= myArray[i].length && myArray[i][j] != myArray[i][j + 1] && myArray[i][j + 1] != myArray[i][j + 2] ) {
                            flag_err = true;
                        } 
                       
                }
            }
        }
        if (flag_err == false) {                                     
            myTrueArray = rightArray(n, m, myArray);
        }
        if (flag_err == true) {
            System.out.println("-1");
        }
        if (flag_err == false) {     //output for the solution
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < myTrueArray[i].length; j++) {
                    System.out.print(myTrueArray[i][j] + " ");
                }
                System.out.println();
            }
        }
        myScnaner.close();
    }
}
