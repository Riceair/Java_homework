import java.util.Scanner;
import java.util.ArrayList;

class Member<T>{  //PriorityQueue�s�����
	private double priority;  //�u����
	private T myData;  //���
	
	public Member(T myData,double priority){  //�غc�l�]�w��ƻP�u����
		this.myData=myData;
		this.priority=priority;
	}
	public T getData(){  //�^�Ǹ��
		return myData;
	}
	public double getPri(){  //�^���u����
		return priority;
	}
}

class PriorityQueue<T>{
	private ArrayList<Member<T>> mylist;  //�x�s��ƪ�ArrayList
	
	public PriorityQueue(){  //�غc�l�غcmylist
		mylist=new ArrayList<Member<T>>();
	}
	public void Add(T item,double priority){  //�s�W������mylist
		Member<T> newMember=new Member(item,priority);
		mylist.add(newMember);
	}
	public void remove(){  //�ϥ�for�j��M��̤j�u���סA���N��R��
		if(mylist.size()>0){  //�p�Gmylist����ư���
			double max=mylist.get(0).getPri();  //�x�s��e�̤j���u����
			int position=0;  //�����̤j�u���ת���m
			for(int i=0;i<mylist.size();i++){  //�M��̤j���u����
				if(mylist.get(i).getPri()>max){  //�p�G���e�u���פj�A�h����e�̤j�u����
					max=mylist.get(i).getPri();
					position=i;  //��̤j�u���ת���m�令��e��m
				}
			}
			System.out.println(mylist.get(position).getData());  //�N�R������ƦL�X
			mylist.remove(position);  //�N�̤j�u���צ�m����Ʋ���
		}
		else{  //�p�Gmylist�L��ƫh��ܳq��
			System.out.println("There are no element in the queue.");
		}
	}
}

public class Java_hw3_problem2 {
	public static void main(String args[]){
		PriorityQueue<String> myQueue=new PriorityQueue<String>();  //PriorityQueue�s���
		Scanner scn=new Scanner(System.in);
		String newdata="";  //�x�s��J�����
		int priority=0;  //�x�s��J���u����
		String instruction="";  //�x�s��J���ﶵ(add remove)
		System.out.println("Please enter \"add\" or \"remove\" to operate.");
		while(scn.hasNext()){
			instruction=scn.next();  //Ū���ﶵ
			if(instruction.toLowerCase().equals("add")){ //�T�{��J���O�Oadd
				System.out.println("Please enter a data.");
				newdata=scn.next();  //��J���
				System.out.println("Please enter the priority.");
				priority=scn.nextInt();  //��J�u����
				myQueue.Add(newdata, priority);  //�N��[�JmyQueue
			}
			else if(instruction.toLowerCase().equals("remove")){  //�T�{��J���O�Oremove
				myQueue.remove();  //�I�smyQueue.remove()�N�̤j�u���׸�ƧR��
			}
			else{  //���~���O�A��ܳq��
				System.out.println("Wrong");
			}
			System.out.println("Please enter \"add\" or \"remove\" to operate.");
		}
	}
}
