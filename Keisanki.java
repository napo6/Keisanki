import java.util.Arrays;
import java.util.List;
public class Keisanki{
  public static void main(String[] args){
  	while(true){
      System.out.print("����:");
      String input = new java.util.Scanner(System.in).nextLine();
  	  input = input.replaceAll(" ","");  //�󔒏���
  		String check = input.replaceAll("[0-9\\*/\\+-\\.]",""); //�d�l�O�̕��������o
  		if(!(check.equals(""))){
  		  input = "error1";
  		}
  	  String hikae = input;
    
      while(input.contains("*")|input.contains("/")|input.contains("+")|input.contains("-")){  //�Ȃ񂩃L���C
        if(input.contains("+-")){
          input = input.replaceAll("\\+-","-");  //���ʂ̕\�L
        }
        if(input.contains("-")){
    	  input = input.replaceAll("-","+-");  //�v�Z�p�̕\�L
        }
        if(input.contains("*+-")){                       //*(���̐�)
    	  input = input.replaceAll("\\*\\+-","\\*-");
        }
        if(input.contains("/+-")){                       // /(���̐�)
    	  input = input.replaceAll("/\\+-","/-");
        }
        if(input.charAt(0) == '+'){
      	  input = input.replaceFirst("\\+","");  //�擪��+����Ȃ�
        }                                        //�����̐�������
        String[] num = input.split("[*/+]");           //���l�z��
        String ope1 = input.replaceAll("[0-9]","");
        String ope2 = ope1.replaceAll("\\.","");
        String ope3 = ope2.replaceAll("\\-","");
        String[] ope = ope3.split("");                 //���Z�q�z��
    	
        if(num.length == 1){
      	   break;                          //������Ȃ�I��
        }
    	
    	
    //���Z�q����
        if(Arrays.asList(ope).contains("*")|Arrays.asList(ope).contains("/")){
          for(int i = 0; i < ope.length; i++){
            if(ope[i].equals("*")){
              double b = kake(num[i],num[i+1]);
              String back = String.valueOf(b);
              String chikan = num[i] + "\\" + ope[i] + num[i+1];
            
              input = input.replaceAll(chikan, back);
          	  break;  //for���甲����
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
          continue;  //��while�̐擪��
        }  //if��
      
      
      
        if(Arrays.asList(ope).contains("+")|Arrays.asList(ope).contains("-")){
          for(int i = 0; i < ope.length; i++){
            if(ope[i].equals("+")){
              double b = tashi(num[i],num[i+1]);
              String back = String.valueOf(b);
              String chikan = num[i] + "\\" + ope[i] + num[i+1];
            
              input = input.replaceAll(chikan, back);
          	  break;  //for�𔲂���
            }
          }
          continue;  //��while�̐擪��
        }  //if��
      
      }  //��while��
    
      String ans = input;
  	  if(!(hikae.contains(".")) && ans.endsWith(".0")){
  		ans = ans.replaceAll("\\.0","");   //hikae��.�Ȃ� ���� input�̖���.0
  	  }
      System.out.println(ans);
  	  if(ans == "error0"){
  		System.out.println("error:0�ł͊���܂���");
  	  }
      if(ans == "error1"){
  		  System.out.println("error:�g�p�ł��镶���́u0~9 + - * /�v(���p)�ł�");
  	  }
  	  }//�Owhile��
    }  //main��
	
	//�����Z���\�b�h��
	
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