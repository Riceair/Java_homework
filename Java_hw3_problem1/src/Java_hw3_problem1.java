import java.util.ArrayList;
import java.util.Scanner;

class Dictionary{  //字典內部的Term與Synonym
	private String term;
	private String synonyms;
	public Dictionary(String term,String synonyms){  //建構子設定Term與Synonym
		this.term=term;
		this.synonyms=synonyms;
	}
	public String GetTerm(){  //回傳term的member function
		return this.term;
	}
	public String GetSyn(){  //回傳synonyms的member function
		return this.synonyms;
	}
}

class MyDict{  //大字典，內部儲存多個Dictionary，有Add、Delete、Search等操作
	private ArrayList<Dictionary> myDict;  //儲存多個Dictionary的ArrayList
	public MyDict(){
		myDict=new ArrayList<Dictionary>(20);  //建構大小為20的ArrayList<Dictionary>
		Dictionary defaultDict=new Dictionary("term","terminology");  //預設存入term與stack兩個Dictionary
		myDict.add(defaultDict);
		Dictionary defaultDict1= new Dictionary("stack", "heap");
		myDict.add(defaultDict1);
	}
	
	public void AddDict(String newTerm,String newSyn){  //在大字典中新增成員
		Dictionary newElement=new Dictionary(newTerm,newSyn);
		myDict.add(newElement);
	}
	public void DelDict(String delTerm){  //在大字典中移除該Term(delTerm)
		if(!myDict.isEmpty()){  //如果大字典不為空進行查詢刪除的步驟
			//如果字典存在該項Term就移除，反之則通知該Term不存在
			
			boolean isfound=false;  //顯示該Term是否存在的flag
			for(Dictionary find : myDict){
				if(delTerm.equals(find.GetTerm())){  //如果該Term被找到就將其移除並通知
					myDict.remove(find);
					System.out.println(delTerm+" has been deleted.");
					isfound=true;  //flag顯示找到(True)
					break;
				}
			}
			if(!isfound){  //如果flag為false表示沒找到，通知
				System.out.println(delTerm+" doesn't exist.");
			}
		}
		else{  //如果大字典為空，則通知大字典為空
			System.out.println("The Dictionary is empty.");
		}
	}
	public void DisDict(){  //印出大字典所有Dictionary
		if(!myDict.isEmpty()){  //如果大字典不為空則陳列所也Dictionary
			for(Dictionary display : myDict){
				System.out.println("Term: "+display.GetTerm()+"\nSynonym: "+display.GetSyn()+"\n");
			}
		}
		else  //如果大字典為空，則通知大字典為空
			System.out.println("The Dictionary is empty.");
	}
	public void SearhDict(String Term){  //查詢該Term是否存在
		if(!myDict.isEmpty()){  //如果大字典不為空進行查詢的步驟
			//如果字典存在該項Term就表示找到並詢問是否刪除，反之則通知該Term不存在
			
			boolean isfound=false;  //顯示該Term是否存在的flag
			for(Dictionary find : myDict){
				if(Term.equals(find.GetTerm())){
					System.out.println(Term+" has been found.");  //找到，通知
					isfound=true;
					
					System.out.println("Delete it or not.(1 or 0)");  //詢問是否移除
					Scanner scn=new Scanner(System.in);
					if(scn.nextInt()==1){  //如果要移除則移除
						myDict.remove(find);
					}
					break;
				}
			}
			if(!isfound)  //該字不存在
				System.out.println(Term+" doesn't exist.");
		}
		else
			System.out.println("The Dictionary is empty.");
	}
}

public class Java_hw3_problem1 {
	public static void main(String args[]){
		MyDict myDict=new MyDict();  //建立一個大字典
		Scanner scn=new Scanner(System.in);
		int choose;  //儲存選項的變數
		String inTerm;  //儲存輸入的Term與Synonyms的變數
		String inSyn;
		System.out.println("Please input 0:Add 1:Delete 2:Display 3:Search (Input is not a integer):exit");
		while(scn.hasNextInt()){  //偵測輸入選項
			choose=scn.nextInt();
			switch(choose){  //依照選項進入不同的case
			case 0:  //Add
				System.out.println("Please input a term.");
				inTerm=scn.next();
				if(IsText(inTerm)){  //使用IsText函式檢查輸入是否全為text
					System.out.println("Please input the Synonym");
					inSyn=scn.next();
					if(IsText(inSyn)){  //使用IsText函式檢查輸入是否全為text
						myDict.AddDict(inTerm, inSyn);  //將輸入進來的Term與Synonym使用AddDict加入大字典
					}
					else
						System.out.println("Invalid input");
				}
				else  //輸入有不為text的字，違法輸入
					System.out.println("Invalid input");
				break;
			case 1:  //Delete
				System.out.println("Please input a term.");
				inTerm=scn.next();
				if(IsText(inTerm))  //使用IsText函式檢查輸入是否全為text
					myDict.DelDict(inTerm);  //將輸入的Term用DelDict移除
				else  //輸入有不為text的字，違法輸入
					System.out.println("Invalid input");
				break;
			case 2:  //Display
				myDict.DisDict();
				break;
			case 3:  //Search
				System.out.println("Please input a term.");
				inTerm=scn.next();
				if(IsText(inTerm))  //使用IsText函式檢查輸入是否全為text
					myDict.SearhDict(inTerm);  //將輸入的Term用SearhDict尋找
				else  //輸入有不為text的字，違法輸入
					System.out.println("Invalid input");
				break;
			default:  //違法輸入
				System.out.println("Invalid input");
			}
			
			System.out.println("Please input 0:Add 1:Delete 2:Display 3:Search (Input is not a Integer):exit");
		}
	}
	
	public static boolean IsText(String str){
		boolean myReturn=true;
		for(int i=0;i<str.length();i++){  //檢查是否所有字都是屬於text('A'~'Z' 'a'~'z')
			if(str.charAt(i)>'z' || str.charAt(i)<'A'){
				myReturn=false;
				break;
			}
		}
		return myReturn;
	}
}
