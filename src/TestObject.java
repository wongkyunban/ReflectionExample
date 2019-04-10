import java.util.HashMap;

public class TestObject {

    private String myName;
    private int myArg;
    public String hobby;
    public String schoolName;
    protected  String age;
    public String[] arr = new String[]{"hello","world"};



    public TestObject(){
        System.out.println("调用TestObject的无参构造方法");
        this.myName = "wongkyunban";
        this.myArg = 23;
    }
    public TestObject(String name){
        System.out.printf("调用TestObject的有一个String型参数的构造方法:%s\n",name);
        this.myName = name;
        this.myArg = 21;
    }
    private TestObject(int arg){
        System.out.printf("调用TestObject的有一个int型参数的构造方法：%d\n",arg);
        this.myName = "Jack";
        this.myArg = arg;
    }
    public TestObject(int arg,String name){
        System.out.printf("调用TestObject的有两个参数的构造方法");
        this.myName = name;
        this.myArg = arg;
    }



    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getMyArg() {
        return myArg;
    }

    public void setMyArg(int myArg) {
        this.myArg = myArg;
    }


    private void con(){
        System.out.printf("hello,%s\n","您调用了一个私有方法");

    }

    public void printHobby(){
        System.out.printf("Hobby:%s\n",hobby);
    }

    protected void byebye(){
        System.out.printf("Bye bye!\n");
    }

    public void handleData(String arg1 ,HashMap<Integer,String> map){
        System.out.printf("%s--->%s\n",arg1,map.get("name"));
    }

    private void say(String name){
        System.out.printf("hello,%s\n",name);
    }

}
