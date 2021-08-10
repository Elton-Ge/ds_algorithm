package com.elton.ds_algorithm.sparseArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Elton Ge
 * @Date: 27/7/21
 * @Description: com.elton.ds_algorithm.sparseArray
 * @version: 1.0
 */
public class SparseArray {

    public static void main(String[] args) {
        //init chess array
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
//        chessArr[5][6] = 1;
//        chessArr[7][9] = 2;
        // get the sum of non-zero ele
        int sum = 0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }

        //create init sparse array based on sum value
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = chessArr.length;
        sparseArray[0][1] = chessArr.length;
        sparseArray[0][2] = sum;
        // assign value to sparse array
        int count = 0;                   //record the count number of non-zero value
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr.length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }

        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        try {
            File file = new File("/Users/elton/Downloads/abc.txt");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
            for (int[] ints : sparseArray) {
                for (int anInt : ints) {
                    osw.write(anInt+"\t");
                }
                osw.write("\n");
            }
            osw.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //2restore to chess array
//        System.out.println(sparseArray.length);
//          try {
//              //读取磁盘中的map.data文件
//              System.out.println("读取中----------");
//              File file = new File("/Users/elton/Downloads/abc.txt");
//              FileInputStream fis = new FileInputStream(file);
//              InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//              StringBuffer sb = new StringBuffer();
//              while(isr.ready()) {
//                  sb.append((char)isr.read());
//              }
//              isr.close();//关闭输入流
//              fis.close();//关闭输入流
//              System.out.println("读取成功");
//          }   catch (IOException e){
//              System.out.println(e.getMessage());
//          }

        try {
            File file = new File("/Users/elton/Downloads/abc.txt");
            BufferedReader br=null;
            List<Integer> list=new ArrayList<>();
            br=new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null) {
                String[] str=line.split("\t");
                for(int i=0;i<str.length;i++) {
                    list.add(Integer.parseInt(str[i]));
                    System.out.println(list);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int originalChessArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            originalChessArray[sparseArray[i][0]][sparseArray[i][1]]= sparseArray[i][2];
        }

        for (int[] ints : originalChessArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        
    }
}
