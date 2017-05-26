import java.util.Arrays;
import java.util.List;
public class Keisanki{
  public static void main(String[] args){
  	while(true){
      System.out.print("数式:");
      String input = new java.util.Scanner(System.in).nextLine();
  	  input = input.replaceAll(" ","");  //空白消去
  		String check = input.replaceAll("[0-9\\*/\\+-\\.]",""); //仕様外の文字を検出
  		if(!(check.equals(""))){
  		  input = "error1";
  		}
  	  String hikae = input;
    
      while(input.contains("*")|input.contains("/")|input.contains("+")|input.contains("-")){  //なんかキモイ
        if(input.contains("+-")){
          input = input.replaceAll("\\+-","-");  //普通の表記
        }
        if(input.contains("-")){
    	  input = input.replaceAll("-","+-");  //計算用の表記
        }
        if(input.contains("*+-")){                       //*(負の数)
    	  input = input.replaceAll("\\*\\+-","\\*-");
        }
        if(input.contains("/+-")){                       // /(負の数)
    	  input = input.replaceAll("/\\+-","/-");
        }
        if(input.charAt(0) == '+'){
      	  input = input.replaceFirst("\\+","");  //先頭は+いらない
        }                                        //数式の整理完了
        String[] num = input.split("[*/+]");           //数値配列
        String ope1 = input.replaceAll("[0-9]","");
        String ope2 = ope1.replaceAll("\\.","");
        String ope3 = ope2.replaceAll("\\-","");
        String[] ope = ope3.split("");                 //演算子配列
    	
        if(num.length == 1){
      	   break;                          //項が一つなら終了
        }
    	
    	
    //演算子特定
        if(Arrays.asList(ope).contains("*")|Arrays.asList(ope).contains("/")){
          for(int i = 0; i < ope.length; i++){
            if(ope[i].equals("*")){
              double b = kake(num[i],num[i+1]);
              String back = String.valueOf(b);
              String chikan = num[i] + "\\" + ope[i] + num[i+1];
            
              input = input.replaceAll(chikan, back);
          	  break;  //forから抜ける
            }
            if(ope[i].equals("/")){
          	  if(num[i+1].equals("0")){
          	    input = "error0";
          	    break;
          	  }
              double b = wari(num[i],num[i+1]);
              String back = String.valueOf(b);
              String chikan = num[i] + ope[i] + num[i+1];
            
              input = input.replaceAll(chikan, back);
          	  break;
        	  }
          
          }
          continue;  //内whileの先頭へ
        }  //if閉じ
      
      
      
        if(Arrays.asList(ope).contains("+")|Arrays.asList(ope).contains("-")){
          for(int i = 0; i < ope.length; i++){
            if(ope[i].equals("+")){
              double b = tashi(num[i],num[i+1]);
              String back = String.valueOf(b);
              String chikan = num[i] + "\\" + ope[i] + num[i+1];
            
              input = input.replaceAll(chikan, back);
          	  break;  //forを抜ける
            }
          }
          continue;  //内whileの先頭へ
        }  //if閉じ
      
      }  //内while閉じ
    
      String ans = input;
  	  if(!(hikae.contains(".")) && ans.endsWith(".0")){
  		ans = ans.replaceAll("\\.0","");   //hikaeに.なし かつ inputの末尾.0
  	  }
      System.out.println(ans);
  	  if(ans == "error0"){
  		System.out.println("error:0では割れません");
  	  }
      if(ans == "error1"){
  		  System.out.println("error:使用できる文字は「0~9 + - * /」(半角)です");
  	  }
  	  }//外while閉じ
    }  //main閉じ
	
	//↓演算メソッド↓
	
  public static double kake(String a, String b){
    double x = Double.parseDouble(a);
    double y = Double.parseDouble(b);
    double ans = x*y;
    return ans;
  }
  
  public static double wari(String a, String b){
    double x = Double.parseDouble(a);
    double y = Double.parseDouble(b);
    double ans = x/y;
    return ans;
  }
  
  public static double tashi(String a, String b){
    double x = Double.parseDouble(a);
    double y = Double.parseDouble(b);
    double ans = x+y;
    return ans;
  }
}