import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class lzw {
	
	public static void main(String args[]) {
		
		
		File file = new File("K:/input.txt");
		FileInputStream fis = null;
		
		int num;
		int count;
		
		
		
		
		
		
		
		System.out.println("Enter the input string : ");
		Scanner sc = new Scanner(System.in);
		String in=sc.nextLine();
		in = in + " ";
		char input[]=in.toCharArray();
		int n=1,flag=0,k=0,flag1=0,t=0;
		String temp="";
		temp+=input[0];
		
		//System.out.println("length="+in.length());
		
		String [] table = new String [in.length()+1] ;
		
		String [] output = new String [in.length()+1] ;
		
		//calculation of table
		
		while (n != in.length()){
			
				//System.out.println("n="+n);
				//while (flag!=1){
					temp = temp+ in.charAt(n);
					  
				//	System.out.println("\ntemp01="+temp);
					//search in table
					
					while(true){
						
						for(int j=0; j<t;j++){
							
							//System.out.println("\ntemp02="+temp);
							
							if (temp.equals(table[j])){
								
								flag1=1;
								
								output[k] = ""+ (j+256);
								temp = temp + in.charAt(n+1);
								table[t]=temp;
								//er3er3r34r34r3434r
											
												while(true){
														String temp1=table[t];
														int a,x;
								
									
															for(a=0,x=n+1;a<t && x<(in.length()-1);a++ ){
															
														//	System.out.println("************************************temp11111=="+temp1+"table=="+table[a]);
															if(temp1.equals(table[a] )){
																//System.out.println("gaya....andar");
																temp=temp1;
																int ab=x+1;
																table[t]=temp+in.charAt(ab);
																output[k] = ""+ (a+256);
																//System.out.println("////*****temp =="+temp);
																
																n++;x++;
																}
															else
															{ //System.out.println("\n nai gaya loop mai..");
																
															}
									
															}
															//delete
															/*if(x== (in.length()-1))
															{
																output[k]= ""+ (a+256);
																
															}
														*/	//delete
																break;
															
												}
								
								
								
							//end	
								// System.out.println("inside if condition i.e match found....table="+table[t]);
								 t++;n++;
								 break;
							}
						}	
							if(flag1==0){
								table[t]=temp;
								output[k]=""+in.charAt(n-1);
								//System.out.println("match not found ......table="+table[t]+"  ,value of t="+t+"output="+output[k]);
								t++;
							}
							
							k++;	
								if(n==(in.length()-1) && flag1==0){
							//table[t]=temp;
							output[k]=""+in.charAt(n);
							//System.out.println("match not found ......table="+table[t]+"  ,value of t="+t+"output="+output[k]);
							//t++;
						}
						
						flag1=0;
						
						temp =""+ in.charAt(n);
					
					//	System.out.println("value of changed temp="+temp);
						
					//}
					n++;
					
					//System.out.println("end of while loop, n="+n+"temp="+temp);
					break;
				}
		
			
		}
		
		
		System.out.println("output=\n");
		count=0;
		for(int z=0;z<n;z++){
			if(output[z]!=null){
			System.out.println(output[z]);
			count++;}
			
		}
		
		
		
		
			/*try{
				FileWriter fw = new FileWriter("k:/output.txt");
			
		 
			
			for(int z=0;z<n;z++){
				if(output[z]!=null)
					fw.write(output[z]);
				
			}
		 
			fw.close();
			
			
		}
			catch(Exception e){
				
				
			}
			
			
			
			File file1 = new File("K:/output.txt");
			FileInputStream fis1 = null;

			try {
				fis1 = new FileInputStream(file1);

				System.out.println("Total file size to read (in bytes) : "
						+ fis1.available());

				int content;
				while ((content = fis1.read()) != -1) {
					// convert to char and display it
					System.out.print((char) content);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
*/
			
	//		System.out.println("the ratio is :"+((double)count/num));
		

		
		System.out.println("------------------table -----------");
		
		for(int z=0;z<(t-1);z++){
			System.out.println((256+z)+" ="+"\t"+table[z]);
		}
		
	
		
		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size of input (in bytes) : "
					+ fis.available());
			num=fis.available();

			System.out.println("Total file size to output (in bytes) : "
					+ count);
			
			System.out.println("the ratio is"+((double)num/count));
			
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				//System.out.print((char) content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
