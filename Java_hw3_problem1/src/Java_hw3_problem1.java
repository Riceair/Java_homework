import java.util.ArrayList;
import java.util.Scanner;

class Dictionary{  //�r�夺����Term�PSynonym
	private String term;
	private String synonyms;
	public Dictionary(String term,String synonyms){  //�غc�l�]�wTerm�PSynonym
		this.term=term;
		this.synonyms=synonyms;
	}
	public String GetTerm(){  //�^��term��member function
		return this.term;
	}
	public String GetSyn(){  //�^��synonyms��member function
		return this.synonyms;
	}
}

class MyDict{  //�j�r��A�����x�s�h��Dictionary�A��Add�BDelete�BSearch���ާ@
	private ArrayList<Dictionary> myDict;  //�x�s�h��Dictionary��ArrayList
	public MyDict(){
		myDict=new ArrayList<Dictionary>(20);  //�غc�j�p��20��ArrayList<Dictionary>
		Dictionary defaultDict=new Dictionary("term","terminology");  //�w�]�s�Jterm�Pstack���Dictionary
		myDict.add(defaultDict);
		Dictionary defaultDict1= new Dictionary("stack", "heap");
		myDict.add(defaultDict1);
	}
	
	public void AddDict(String newTerm,String newSyn){  //�b�j�r�夤�s�W����
		Dictionary newElement=new Dictionary(newTerm,newSyn);
		myDict.add(newElement);
	}
	public void DelDict(String delTerm){  //�b�j�r�夤������Term(delTerm)
		if(!myDict.isEmpty()){  //�p�G�j�r�夣���Ŷi��d�ߧR�����B�J
			//�p�G�r��s�b�Ӷ�Term�N�����A�Ϥ��h�q����Term���s�b
			
			boolean isfound=false;  //��ܸ�Term�O�_�s�b��flag
			for(Dictionary find : myDict){
				if(delTerm.equals(find.GetTerm())){  //�p�G��Term�Q���N�N�䲾���óq��
					myDict.remove(find);
					System.out.println(delTerm+" has been deleted.");
					isfound=true;  //flag��ܧ��(True)
					break;
				}
			}
			if(!isfound){  //�p�Gflag��false��ܨS���A�q��
				System.out.println(delTerm+" doesn't exist.");
			}
		}
		else{  //�p�G�j�r�嬰�šA�h�q���j�r�嬰��
			System.out.println("The Dictionary is empty.");
		}
	}
	public void DisDict(){  //�L�X�j�r��Ҧ�Dictionary
		if(!myDict.isEmpty()){  //�p�G�j�r�夣���ūh���C�Ҥ]Dictionary
			for(Dictionary display : myDict){
				System.out.println("Term: "+display.GetTerm()+"\nSynonym: "+display.GetSyn()+"\n");
			}
		}
		else  //�p�G�j�r�嬰�šA�h�q���j�r�嬰��
			System.out.println("The Dictionary is empty.");
	}
	public void SearhDict(String Term){  //�d�߸�Term�O�_�s�b
		if(!myDict.isEmpty()){  //�p�G�j�r�夣���Ŷi��d�ߪ��B�J
			//�p�G�r��s�b�Ӷ�Term�N��ܧ��ø߰ݬO�_�R���A�Ϥ��h�q����Term���s�b
			
			boolean isfound=false;  //��ܸ�Term�O�_�s�b��flag
			for(Dictionary find : myDict){
				if(Term.equals(find.GetTerm())){
					System.out.println(Term+" has been found.");  //���A�q��
					isfound=true;
					
					System.out.println("Delete it or not.(1 or 0)");  //�߰ݬO�_����
					Scanner scn=new Scanner(System.in);
					if(scn.nextInt()==1){  //�p�G�n�����h����
						myDict.remove(find);
					}
					break;
				}
			}
			if(!isfound)  //�Ӧr���s�b
				System.out.println(Term+" doesn't exist.");
		}
		else
			System.out.println("The Dictionary is empty.");
	}
}

public class Java_hw3_problem1 {
	public static void main(String args[]){
		MyDict myDict=new MyDict();  //�إߤ@�Ӥj�r��
		Scanner scn=new Scanner(System.in);
		int choose;  //�x�s�ﶵ���ܼ�
		String inTerm;  //�x�s��J��Term�PSynonyms���ܼ�
		String inSyn;
		System.out.println("Please input 0:Add 1:Delete 2:Display 3:Search (Input is not a integer):exit");
		while(scn.hasNextInt()){  //������J�ﶵ
			choose=scn.nextInt();
			switch(choose){  //�̷ӿﶵ�i�J���P��case
			case 0:  //Add
				System.out.println("Please input a term.");
				inTerm=scn.next();
				if(IsText(inTerm)){  //�ϥ�IsText�禡�ˬd��J�O�_����text
					System.out.println("Please input the Synonym");
					inSyn=scn.next();
					if(IsText(inSyn)){  //�ϥ�IsText�禡�ˬd��J�O�_����text
						myDict.AddDict(inTerm, inSyn);  //�N��J�i�Ӫ�Term�PSynonym�ϥ�AddDict�[�J�j�r��
					}
					else
						System.out.println("Invalid input");
				}
				else  //��J������text���r�A�H�k��J
					System.out.println("Invalid input");
				break;
			case 1:  //Delete
				System.out.println("Please input a term.");
				inTerm=scn.next();
				if(IsText(inTerm))  //�ϥ�IsText�禡�ˬd��J�O�_����text
					myDict.DelDict(inTerm);  //�N��J��Term��DelDict����
				else  //��J������text���r�A�H�k��J
					System.out.println("Invalid input");
				break;
			case 2:  //Display
				myDict.DisDict();
				break;
			case 3:  //Search
				System.out.println("Please input a term.");
				inTerm=scn.next();
				if(IsText(inTerm))  //�ϥ�IsText�禡�ˬd��J�O�_����text
					myDict.SearhDict(inTerm);  //�N��J��Term��SearhDict�M��
				else  //��J������text���r�A�H�k��J
					System.out.println("Invalid input");
				break;
			default:  //�H�k��J
				System.out.println("Invalid input");
			}
			
			System.out.println("Please input 0:Add 1:Delete 2:Display 3:Search (Input is not a Integer):exit");
		}
	}
	
	public static boolean IsText(String str){
		boolean myReturn=true;
		for(int i=0;i<str.length();i++){  //�ˬd�O�_�Ҧ��r���O�ݩ�text('A'~'Z' 'a'~'z')
			if(str.charAt(i)>'z' || str.charAt(i)<'A'){
				myReturn=false;
				break;
			}
		}
		return myReturn;
	}
}
