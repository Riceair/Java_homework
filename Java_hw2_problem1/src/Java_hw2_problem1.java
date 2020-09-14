import java.util.Scanner;
class Fraction{
	private int numerator;  //儲存的分子
	private int denominator;  //儲存的分母
	public void setFraction(int numerator,int denominator){  //設定分子與分母的member function
		this.numerator=numerator;  //將傳入的分子與分母指派給此物件的分子分母
		this.denominator=denominator;
		if(this.denominator==0){  //如果輸入的分母為0，則為不正確的分數，要求重輸
			System.out.println("The format of the fraction is incorrect.\n"
					+ "Please enter again.");
			setFraction();  //呼叫setFunction的多載，讓使用者重新輸入
		}
	}
	public void setFraction(){  //為setFraction的多載，當輸入錯誤分數時被呼叫，讓使用者重輸
		Scanner scn=new Scanner(System.in);
		numerator=scn.nextInt();
		denominator=scn.nextInt();
		if(this.denominator==0){  //如果輸入的分母為0，則為不正確的分數，要求重輸
			System.out.println("The format of the fraction is incorrect.\n"
					+ "Please enter again.");
			setFraction();  //再次呼叫setFraction()讓使用者重輸
		}
	}
	public void showFraction(){  //將分數以 "分子/分母"的方式顯示出來
		System.out.println(numerator+"/"+denominator);
	}
	public int getNume(){  //回傳此物件存的分子
		return numerator;
	}
	public int getDeno(){  //回傳此物件存的分母
		return denominator;
	}
}
public class Java_hw2_problem1 {
	public static void main(String args[]){
		Fraction fraction=new Fraction();  //建立一個Fraction物件讓使用者使用
		Fraction cfraction=new Fraction();  //建立另一個Fraction物件讓使用者進行比較是否相同用
		Scanner scn=new Scanner(System.in);
		int numerator,denominator;  //存使用者存的分子分母
		System.out.println("Please enter a fraction.");
		System.out.println("Enter the numerator:");
		while(scn.hasNextInt()){		     //使用Scanner.hasNextInt()讓使用者重複輸入直到輸入EOF為止
			numerator=scn.nextInt();     //輸入分子
			System.out.println("Enter the denominator:");
			denominator=scn.nextInt();  //輸入分母
			fraction.setFraction(numerator,denominator);  //第一個Fraction物件用setFraction設定
			fraction.showFraction();  //用Fraction的showFraction將該分數印出來
			
			//check
			System.out.println("Please enter a fraction to check being equal or not.");
			System.out.println("Enter the numerator:");
			numerator=scn.nextInt();     //輸入要比較是否相等分數的分母
			System.out.println("Enter the denominator:");
			denominator=scn.nextInt();  //輸入要比較是否相等分數的分子
			cfraction.setFraction(numerator,denominator);  //將要比較的Fraction物件用setFraction設定
			System.out.println((new CheckEqual(){  //使用匿名物件ChekcEqual的equals function比較兩個Fraction物件的分數是否相同
				boolean equals(Fraction fraction,Fraction cfraction){
					gcd1=GCD(fraction.getNume(),fraction.getDeno());  //使用GCD function尋找兩分數各別分子分母的最大公因數
					gcd2=GCD(cfraction.getNume(),cfraction.getDeno());
					if((fraction.getNume()/gcd1)==(cfraction.getNume()/gcd2)&&(fraction.getDeno()/gcd1)==(cfraction.getDeno()/gcd2)){
						return true;  //將兩分數的分子分母都除自己的最大公因數，如果相同則分數相同
					}
					else{  //反之則否
						return false;
					}
				}
			 }).equals(fraction,cfraction));
			System.out.println("Please enter a fraction.");  //迴圈重複執行，再次印出開始訊息
			System.out.println("Enter the numerator:");
		}
	}
	static class CheckEqual{  //匿名物件，宣告兩個存最大公因數的變數
		int gcd1,gcd2;
	}
	public static int GCD(int nume,int deno){  //function GCD，算出兩傳入的數的最大公因數
		while(true){  //執行迴圈，讓大數減小數，直到兩者相同為止，該數即為最大公因數
			if(nume==deno){
				break;
			}
			else if(nume>deno){
				nume-=deno;
			}
			else{
				deno-=nume;
			}
		}
		return nume;  //將最大公因數回傳
	}
}
