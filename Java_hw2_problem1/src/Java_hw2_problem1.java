import java.util.Scanner;
class Fraction{
	private int numerator;  //�x�s�����l
	private int denominator;  //�x�s������
	public void setFraction(int numerator,int denominator){  //�]�w���l�P������member function
		this.numerator=numerator;  //�N�ǤJ�����l�P���������������󪺤��l����
		this.denominator=denominator;
		if(this.denominator==0){  //�p�G��J��������0�A�h�������T�����ơA�n�D����
			System.out.println("The format of the fraction is incorrect.\n"
					+ "Please enter again.");
			setFraction();  //�I�ssetFunction���h���A���ϥΪ̭��s��J
		}
	}
	public void setFraction(){  //��setFraction���h���A���J���~���ƮɳQ�I�s�A���ϥΪ̭���
		Scanner scn=new Scanner(System.in);
		numerator=scn.nextInt();
		denominator=scn.nextInt();
		if(this.denominator==0){  //�p�G��J��������0�A�h�������T�����ơA�n�D����
			System.out.println("The format of the fraction is incorrect.\n"
					+ "Please enter again.");
			setFraction();  //�A���I�ssetFraction()���ϥΪ̭���
		}
	}
	public void showFraction(){  //�N���ƥH "���l/����"���覡��ܥX��
		System.out.println(numerator+"/"+denominator);
	}
	public int getNume(){  //�^�Ǧ�����s�����l
		return numerator;
	}
	public int getDeno(){  //�^�Ǧ�����s������
		return denominator;
	}
}
public class Java_hw2_problem1 {
	public static void main(String args[]){
		Fraction fraction=new Fraction();  //�إߤ@��Fraction�������ϥΪ̨ϥ�
		Fraction cfraction=new Fraction();  //�إߥt�@��Fraction�������ϥΪ̶i�����O�_�ۦP��
		Scanner scn=new Scanner(System.in);
		int numerator,denominator;  //�s�ϥΪ̦s�����l����
		System.out.println("Please enter a fraction.");
		System.out.println("Enter the numerator:");
		while(scn.hasNextInt()){		     //�ϥ�Scanner.hasNextInt()���ϥΪ̭��ƿ�J�����JEOF����
			numerator=scn.nextInt();     //��J���l
			System.out.println("Enter the denominator:");
			denominator=scn.nextInt();  //��J����
			fraction.setFraction(numerator,denominator);  //�Ĥ@��Fraction�����setFraction�]�w
			fraction.showFraction();  //��Fraction��showFraction�N�Ӥ��ƦL�X��
			
			//check
			System.out.println("Please enter a fraction to check being equal or not.");
			System.out.println("Enter the numerator:");
			numerator=scn.nextInt();     //��J�n����O�_�۵����ƪ�����
			System.out.println("Enter the denominator:");
			denominator=scn.nextInt();  //��J�n����O�_�۵����ƪ����l
			cfraction.setFraction(numerator,denominator);  //�N�n�����Fraction�����setFraction�]�w
			System.out.println((new CheckEqual(){  //�ϥΰΦW����ChekcEqual��equals function������Fraction���󪺤��ƬO�_�ۦP
				boolean equals(Fraction fraction,Fraction cfraction){
					gcd1=GCD(fraction.getNume(),fraction.getDeno());  //�ϥ�GCD function�M�����ƦU�O���l�������̤j���]��
					gcd2=GCD(cfraction.getNume(),cfraction.getDeno());
					if((fraction.getNume()/gcd1)==(cfraction.getNume()/gcd2)&&(fraction.getDeno()/gcd1)==(cfraction.getDeno()/gcd2)){
						return true;  //�N����ƪ����l���������ۤv���̤j���]�ơA�p�G�ۦP�h���ƬۦP
					}
					else{  //�Ϥ��h�_
						return false;
					}
				}
			 }).equals(fraction,cfraction));
			System.out.println("Please enter a fraction.");  //�j�魫�ư���A�A���L�X�}�l�T��
			System.out.println("Enter the numerator:");
		}
	}
	static class CheckEqual{  //�ΦW����A�ŧi��Ӧs�̤j���]�ƪ��ܼ�
		int gcd1,gcd2;
	}
	public static int GCD(int nume,int deno){  //function GCD�A��X��ǤJ���ƪ��̤j���]��
		while(true){  //����j��A���j�ƴ�p�ơA�����̬ۦP����A�ӼƧY���̤j���]��
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
		return nume;  //�N�̤j���]�Ʀ^��
	}
}
