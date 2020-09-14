import java.util.Scanner;
import java.util.ArrayList;

class Member<T>{  //PriorityQueue存的資料
	private double priority;  //優先度
	private T myData;  //資料
	
	public Member(T myData,double priority){  //建構子設定資料與優先度
		this.myData=myData;
		this.priority=priority;
	}
	public T getData(){  //回傳資料
		return myData;
	}
	public double getPri(){  //回傳優先度
		return priority;
	}
}

class PriorityQueue<T>{
	private ArrayList<Member<T>> mylist;  //儲存資料的ArrayList
	
	public PriorityQueue(){  //建構子建構mylist
		mylist=new ArrayList<Member<T>>();
	}
	public void Add(T item,double priority){  //新增成員到mylist
		Member<T> newMember=new Member(item,priority);
		mylist.add(newMember);
	}
	public void remove(){  //使用for迴圈尋找最大優先度，找到將其刪除
		if(mylist.size()>0){  //如果mylist有資料執行
			double max=mylist.get(0).getPri();  //儲存當前最大的優先度
			int position=0;  //紀錄最大優先度的位置
			for(int i=0;i<mylist.size();i++){  //尋找最大的優先度
				if(mylist.get(i).getPri()>max){  //如果比當前優先度大，則更改當前最大優先度
					max=mylist.get(i).getPri();
					position=i;  //把最大優先度的位置改成當前位置
				}
			}
			System.out.println(mylist.get(position).getData());  //將刪除的資料印出
			mylist.remove(position);  //將最大優先度位置的資料移除
		}
		else{  //如果mylist無資料則顯示通知
			System.out.println("There are no element in the queue.");
		}
	}
}

public class Java_hw3_problem2 {
	public static void main(String args[]){
		PriorityQueue<String> myQueue=new PriorityQueue<String>();  //PriorityQueue存資料
		Scanner scn=new Scanner(System.in);
		String newdata="";  //儲存輸入的資料
		int priority=0;  //儲存輸入的優先度
		String instruction="";  //儲存輸入的選項(add remove)
		System.out.println("Please enter \"add\" or \"remove\" to operate.");
		while(scn.hasNext()){
			instruction=scn.next();  //讀取選項
			if(instruction.toLowerCase().equals("add")){ //確認輸入指令是add
				System.out.println("Please enter a data.");
				newdata=scn.next();  //輸入資料
				System.out.println("Please enter the priority.");
				priority=scn.nextInt();  //輸入優先度
				myQueue.Add(newdata, priority);  //將其加入myQueue
			}
			else if(instruction.toLowerCase().equals("remove")){  //確認輸入指令是remove
				myQueue.remove();  //呼叫myQueue.remove()將最大優先度資料刪除
			}
			else{  //錯誤指令，顯示通知
				System.out.println("Wrong");
			}
			System.out.println("Please enter \"add\" or \"remove\" to operate.");
		}
	}
}
