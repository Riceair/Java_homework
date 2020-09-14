class Pizza{
	private String size;  //將Pizza的size用字串存
	private int cheese,pepporoni,ham;  //將Pizza的各種toppings用int存
	public Pizza(String size,int cheese,int pepporoni,int ham){  //有傳遞參數的建構子
		setAll(size,cheese,pepporoni,ham);  //使用member function setAll將資料存入
	}
	public Pizza(){  //沒有傳遞參數的建構子
		setAll("Medium",3,3,3);  //使用setAll將預設值存入
	}
	public void setAll(String size,int cheese,int pepporoni,int ham){
		//setAll將傳遞過來的資料使用各個資料的set function去設置
		setSize(size);
		setCheese(cheese);
		setPepporoni(pepporoni);
		setHam(ham);
	}
	public void setSize(String size){
		//將size給設置
		this.size=size;
	}
	public void setCheese(int cheese){
		//將cheese數設置
		this.cheese=cheese;
	}
	public void setPepporoni(int pepporoni){
		//將pepporoni數設置
		this.pepporoni=pepporoni;
	}
	public void setHam(int ham){
		//將ham數設置
		this.ham=ham;
	}
	public int calcCost(){  //計算總金額
		int myCost=0;  //作為回傳金額的變數
		if(size=="Small"){  //以下的if和else判斷依照Size和topping數計算金額
			myCost=10+2*(cheese+pepporoni+ham);
		}
		else if(size=="Medium"){
			myCost=12+2*(cheese+pepporoni+ham);
		}
		else if(size=="Large"){
			myCost=14+2*(cheese+pepporoni+ham);
		}
		return myCost;  //回傳計算結果(如果size錯誤回傳值就會為0，在getDescripition會顯示錯誤訊息)
	}
	public String getDescription(){  //將Descripition以字串方式傳回
		if(cheese>=0 && pepporoni>=0 && ham>=0 && calcCost()!=0){
			//如果topping都大於0，calcCost也不為0，那表示資訊是對的，可以正常輸出
			String myDescripition;
			myDescripition="Size: "+size+"\nCheese: "+cheese+"\nPepporoni: "+pepporoni
					+"\nHam: "+ham+"\nCost: "+calcCost();
			//將訊息存入myDescripition字串中
			return myDescripition;
			//回傳myDescripition字串
		}
		else{
			//資訊錯誤，回傳錯誤訊息的字串
			return "The information is wrong.\nPlease use setAll() or other seting size to reset.\n";
		}
	}
}
public class Java_hw2_problem2 {
	public static void main(String args[]){
		Pizza myPizza1=new Pizza("Small",1,0,3);  //創建size為Small的Pizza
		Pizza myPizza2=new Pizza();  //使用無參數傳遞的建構子(預設大小為Medium
		Pizza myPizza3=new Pizza("Large",2,4,1);  //創建size為Large的Pizza
		Pizza myPizzaWrong=new Pizza("123",1,2,3);  //創建size訊息為錯誤的Pizza
		Pizza myPizzaWrong2=new Pizza("Large",-1,87,2);  //創建topping訊息為錯誤的Pizza
		//將所有建立的Pizza使用getDescripition()顯示
		System.out.println(myPizza1.getDescription()+"\n");
		System.out.println(myPizza2.getDescription()+"\n");
		System.out.println(myPizza3.getDescription()+"\n");
		System.out.println(myPizzaWrong.getDescription());
		System.out.println(myPizzaWrong2.getDescription());
	}
}
