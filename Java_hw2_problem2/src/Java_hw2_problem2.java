class Pizza{
	private String size;  //�NPizza��size�Φr��s
	private int cheese,pepporoni,ham;  //�NPizza���U��toppings��int�s
	public Pizza(String size,int cheese,int pepporoni,int ham){  //���ǻ��Ѽƪ��غc�l
		setAll(size,cheese,pepporoni,ham);  //�ϥ�member function setAll�N��Ʀs�J
	}
	public Pizza(){  //�S���ǻ��Ѽƪ��غc�l
		setAll("Medium",3,3,3);  //�ϥ�setAll�N�w�]�Ȧs�J
	}
	public void setAll(String size,int cheese,int pepporoni,int ham){
		//setAll�N�ǻ��L�Ӫ���ƨϥΦU�Ӹ�ƪ�set function�h�]�m
		setSize(size);
		setCheese(cheese);
		setPepporoni(pepporoni);
		setHam(ham);
	}
	public void setSize(String size){
		//�Nsize���]�m
		this.size=size;
	}
	public void setCheese(int cheese){
		//�Ncheese�Ƴ]�m
		this.cheese=cheese;
	}
	public void setPepporoni(int pepporoni){
		//�Npepporoni�Ƴ]�m
		this.pepporoni=pepporoni;
	}
	public void setHam(int ham){
		//�Nham�Ƴ]�m
		this.ham=ham;
	}
	public int calcCost(){  //�p���`���B
		int myCost=0;  //�@���^�Ǫ��B���ܼ�
		if(size=="Small"){  //�H�U��if�Melse�P�_�̷�Size�Mtopping�ƭp����B
			myCost=10+2*(cheese+pepporoni+ham);
		}
		else if(size=="Medium"){
			myCost=12+2*(cheese+pepporoni+ham);
		}
		else if(size=="Large"){
			myCost=14+2*(cheese+pepporoni+ham);
		}
		return myCost;  //�^�ǭp�⵲�G(�p�Gsize���~�^�ǭȴN�|��0�A�bgetDescripition�|��ܿ��~�T��)
	}
	public String getDescription(){  //�NDescripition�H�r��覡�Ǧ^
		if(cheese>=0 && pepporoni>=0 && ham>=0 && calcCost()!=0){
			//�p�Gtopping���j��0�AcalcCost�]����0�A����ܸ�T�O�諸�A�i�H���`��X
			String myDescripition;
			myDescripition="Size: "+size+"\nCheese: "+cheese+"\nPepporoni: "+pepporoni
					+"\nHam: "+ham+"\nCost: "+calcCost();
			//�N�T���s�JmyDescripition�r�ꤤ
			return myDescripition;
			//�^��myDescripition�r��
		}
		else{
			//��T���~�A�^�ǿ��~�T�����r��
			return "The information is wrong.\nPlease use setAll() or other seting size to reset.\n";
		}
	}
}
public class Java_hw2_problem2 {
	public static void main(String args[]){
		Pizza myPizza1=new Pizza("Small",1,0,3);  //�Ы�size��Small��Pizza
		Pizza myPizza2=new Pizza();  //�ϥεL�Ѽƶǻ����غc�l(�w�]�j�p��Medium
		Pizza myPizza3=new Pizza("Large",2,4,1);  //�Ы�size��Large��Pizza
		Pizza myPizzaWrong=new Pizza("123",1,2,3);  //�Ы�size�T�������~��Pizza
		Pizza myPizzaWrong2=new Pizza("Large",-1,87,2);  //�Ы�topping�T�������~��Pizza
		//�N�Ҧ��إߪ�Pizza�ϥ�getDescripition()���
		System.out.println(myPizza1.getDescription()+"\n");
		System.out.println(myPizza2.getDescription()+"\n");
		System.out.println(myPizza3.getDescription()+"\n");
		System.out.println(myPizzaWrong.getDescription());
		System.out.println(myPizzaWrong2.getDescription());
	}
}
