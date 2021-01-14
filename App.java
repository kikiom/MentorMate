import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner myScnaner = new Scanner(System.in);
        int n;
        int m;
        int err = 0;
        System.out.print("Enter n: ");
        n = myScnaner.nextInt();
        System.out.print("Enter m: ");
        m = myScnaner.nextInt();
        if (n < 0 || n % 2 != 0) {
            err++;
        }
        if (m < 0 || m % 2 != 0) {
            err++;
        }   
        int myObj[] [] = new int[n] [m];
        int myTrueObj[] [] = new int[n] [m];
        if (err == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < myObj[i].length; j++) {
                    myObj[i][j] = myScnaner.nextInt();
                    if (myObj[i][j] < 0) {
                        err++;
                    }   
                }    
            } 
        }    
        if (err == 0) {
            for (int i = 0; i < myObj.length; i++) {
                for (int j = 0; j < myObj[i].length; j++) {
                    if (j + 2 <= m) {    
                      if (myObj[i][j] != myObj[i][j + 1] && myObj[i][j + 1] != myObj[i][j + 2] ) {
                            err++;
                        } 
                    }   
                }
            }
        }
        if (err == 0) {
            int br = 0;
            for (int i = n-1; i >= 0; i-=2) {
                for (int j = 0; j < myObj[i].length; j+=4) {
                    if (myObj[i][j] == myObj[i][j+1]) {
                        myTrueObj[i][j] = 2+br*4;
                        myTrueObj[i-1][j] = 2+br*4;
                        myTrueObj[i][j+1] = 3+br*4;
                        myTrueObj[i][j+2] = 3+br*4;
                        myTrueObj[i-1][j+1] = 1+br*4;
                        myTrueObj[i-1][j+2] = 1+br*4;
                        myTrueObj[i][j+3] = 4+br*4;
                        myTrueObj[i-1][j+3] = 4+br*4;
                    }
                    else {
                        myTrueObj[i][j] = 3+br*4;
                        myTrueObj[i][j+1] = 3+br*4;
                        myTrueObj[i-1][j+1] = 1+br*4;
                        myTrueObj[i-1][j] = 1+br*4;
                        myTrueObj[i-1][j+2] = 2+br*4;
                        myTrueObj[i-1][j+3] = 2+br*4;
                        myTrueObj[i][j+3] = 4+br*4;
                        myTrueObj[i][j+2] = 4+br*4;
                    }
                    br++;
                }
            }
        }
        if (err > 0) {
            System.out.println("-1");
        }
        if (err == 0) {
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < myTrueObj[i].length; j++) {
                    System.out.print(myTrueObj[i][j] + " ");
                }
                System.out.println();
            }
        }
        myScnaner.close();
    }
}
