package success;
import java.util.Scanner;

public class Library {
	Scanner input=new Scanner(System.in);
	private int BookId;//书的ID
	private String BookName;//书的名字
	private String Author;//书的作者
	private int BookNum;//书的数量
	
	public void Library(int BookId,String BookName,String Author,int BookNum){
		this.BookId=BookId;
		this.BookName=BookName;
		this.Author=Author;
		this.BookNum=BookNum;
	}
	
	public void setBookId(int BookId){
		this.BookId=BookId;
		
	}
	public void setBookName(String BookName){
		this.BookName=BookName;
	}
	public void setAuthor(String Author){
		this.Author=Author;
	}
	public void setBookNum(int BookNum){
		this.BookNum=BookNum;
	}
	public int getBookId(){
		return BookId;
	}
	public String getBookName(){
		return BookName;
	}
	public String getAuthor(){
		return Author;
	}
	public int getBookNum(){
		return BookNum;
	}
	//增加图书函数
	public void add(Library a){//增加图书以及图书信息函数
		int BookId1,BookNum1;
		String BookName1,Author1;
		System.out.println("~~~~~~~~~开始添加图书信息！~~~~~~~~~");
		System.out.println("图书ID：");
		BookId1=input.nextInt();
		a.setBookId(BookId1);
		System.out.println("图书名字：");
		BookName1=input.next();
		a.setBookName(BookName1);
		System.out.println("图书作者");
		Author1=input.next();
		a.setAuthor(Author1);
		System.out.println("图书数量");
		BookNum1=input.nextInt();
		a.setBookNum(BookNum1);
		System.out.println("~~~~~~~~~结束添加图书信息！~~~~~~~~~");
	}
	public int select(String[][] a){//用来输出特定图书号图书信息
		int m;
		int n = -1;
		
		System.out.println("请输入你要查找的图书号：");
		m=input.nextInt();
		for(int i=0;i<a.length;i++)
		{
			if(Integer.parseInt(a[i][0])==m){
				
				n=i;
				break;}
			
		}
			return n;
	}
	

	public int alter_s(String[][] a){//用来查找修改图书的下标
		int m;
		int n=-1;
		System.out.println("选择要修改图书的编号：");
		m=input.nextInt();
		for(int i=0;i<a.length;i++){
			if(Integer.parseInt(a[i][0])==m){
				n=i;
				break;
			}
			
		}
		
		return n;
	}
	public int Num(){//用来查找修改图书信息的下标
		int n=-1;
		System.out.println("选择你要修改的内容：0.图书ID   1.图书姓名   2.图书作者   4.图书数量");
		n=input.nextInt();
		return n;
	}
	public int delete(String[][] a){//用于删除图书信息
		System.out.println("选择你要删除的图书的图书号：");
		int m;
		int n=-1;
		m=input.nextInt();
		for(int i=0;i<a.length;i++){
			if(Integer.parseInt(a[i][0])==m){
				n=i;
				break;
			}
			
		}
		
		return n;
	}
	public void display(){
	System.out.println("-----------------------------图书管理系统---------------------------------");
	System.out.println("\t\t1.增加图书\t\t2.查找图书");
	System.out.println("\t\t3.修改图书\t\t4.删除图书");
	System.out.println("\t\t5.退出系统\t\t6.联系作者");
	System.out.println("--------------------------------------------------------------------------");}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		Library Lib=new Library();
		String[][] book1=new String[10][10];//存放图书信息的数组
		
		
		int count=0;//图书个数
		int m,o;//用来定位下标
		boolean flag=true;
		int number;
		
		while(flag){
			Lib.display();
			System.out.println("请输入选择的功能：");
			number=input.nextInt();
			switch(number){
			case 1:
				Lib.add(Lib);
				book1[count][0]=Lib.BookId+"";
				book1[count][1]=Lib.BookName;
				book1[count][2]=Lib.Author;
				book1[count][3]=Lib.BookNum+"";
				System.out.println("图书的ID是："+book1[count][0]);
				System.out.println("图书的名称是："+book1[count][1]);
				System.out.println("图书的作者是："+book1[count][2]);
				System.out.println("图书的数量是："+book1[count][3]);
				count++;
				
				break;
			case 2:
				m=Lib.select(book1);
				
				if(m<0){
					System.out.println("没有这个图书编号！");
					
				}else{
					System.out.println("图书编号为："+book1[m][0]);
					System.out.println("图书名称为："+book1[m][1]);
					System.out.println("图书的作者是："+book1[m][2]);
					System.out.println("图书的数量是："+book1[m][3]);
				}
				System.out.println("~~~~~~~~~~~~图书信息查找完毕~~~~~~~~~~~~");
				break;
			case 3:
				m=Lib.alter_s(book1);
				o=Lib.Num();
				System.out.println("请输入你要修改的内容：");
				book1[m][o]=input.next();
				System.out.println("~~~~~~~~~~~~图书信息已经修改~~~~~~~~~~~~");
				break;
			case 4:
				m=Lib.delete(book1);
				book1[m]=null;
				for(int i=m;i<book1.length-1;i++)
				{
					book1[i]=book1[i+1];
				}
				System.out.println("~~~~~~~~~~~~图书信息已被删除~~~~~~~~~~~");
				count--;
				break;
			case 5:
				System.out.println("~~~~~~~~~~~~您已经退出系统~~~~~~~~~~~~");
				flag=false;
				break;
			case 6:
				System.out.println("~~~~~~~~~~~~作者真的菜！~~~~~~~~~~~~");
				break;
			default:
				System.out.println("输入错误");
				break;
				
			}
		}
	}

	
}
