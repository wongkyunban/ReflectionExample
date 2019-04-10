import com.sun.xml.internal.ws.assembler.jaxws.TerminalTubeFactory;

import java.lang.reflect.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        main.getConstructor();
        main.useConstructor();

        main.getMyField();
        main.useMyfield();

        main.getAllMethod();
        main.useMethod();


        main.handlArray();
        main.getGenericType();

        main.showPermmit();
    }

    //获取构造函数
    public void getConstructor() {
        try {
            Class<?> clazz = Class.forName("TestObject");
            //获得所有的具有public访问权限的构造方法
            Constructor<?>[] constructors = clazz.getConstructors();
            System.out.printf("所有的具有public访问权限的构造方法:\n");
            for (Constructor o : constructors) {
                System.out.printf("%s\n", o.toString());
            }

            //获得指定的具有public访问权限的构造方法
            Constructor<?> constructor = clazz.getConstructor(String.class);
            System.out.printf("获得指定的具有public访问权限的构造方法:\n");
            System.out.printf("%s\n", constructor.toString());


            //获得所有的构造方法，包括public, private,protected和默认权限的
            Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
            System.out.printf("获得所有的构造方法，包括public, private,protected和默认权限的:\n");
            for (Object o : declaredConstructors) {
                System.out.printf("%s\n", o.toString());
            }

            //获得指定的构造方法，不管它的访问权限是什么
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class);
            System.out.printf("获得指定的构造方法，不管它的访问权限是什么:\n");
            System.out.printf("%s\n", declaredConstructor.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    //使用获得的构造函数，构造对象
    public void useConstructor(){
        try {
            Class<?> clazz = Class.forName("TestObject");
            Constructor constructor = clazz.getConstructor(String.class);
            Object o = constructor.newInstance("Hello");
            TestObject testObject = (TestObject) o;
            testObject.byebye();


            Constructor privateConstructor = clazz.getDeclaredConstructor(int.class);
            //privateConstructor的访问权限不是public所以一定要执行下面这条语句
            privateConstructor.setAccessible(true);
            Object o1 = privateConstructor.newInstance(88);
            TestObject testObject1 = (TestObject)o1;
            testObject1.byebye();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //获取所有字段
    public void getMyField() {

        try {
            Class<?> clazz = Class.forName("TestObject");

            //获得所有的具有public访问权限的字段
            Field[] fields = clazz.getFields();
            System.out.printf("获得所有的具有public访问权限的字段:\n");
            for (Field o : fields) {
                System.out.printf("%s\n", o.toString());
            }

            //获得指定的具有public访问权限的字段
            System.out.printf("获得指定的具有public访问权限的字段:\n");
            Field field = clazz.getField("hobby");
            System.out.printf("%s\n", field.toString());

            //获得所有字段，包括public, private,protected和默认权限的字段
            Field[] declaredfields = clazz.getDeclaredFields();
            System.out.printf("获得所有的字段，包括public, private,protected和默认权限的字段:\n");
            for (Field o : declaredfields) {
                System.out.printf("%s\n", o.toString());
            }

            //获得指定的字段，字段的访问权限包括public, private,protected和默认权限的
            System.out.printf("获得指定的字段，字段的访问权限包括public, private,protected和默认权限的:\n");
            Field declaredField = clazz.getDeclaredField("myName");
            System.out.printf("%s\n", declaredField.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
    //使用获得的字段
    public void useMyfield(){
        try {
            Class<?> clazz = Class.forName("TestObject");

            Field field = clazz.getField("hobby");//有public权限的
            TestObject object = new TestObject();
            System.out.printf("%s\n",(String)field.get(object));
            field.set(object,"PingPong");
            System.out.printf("%s\n",(String)field.get(object));


            Field privateField = clazz.getDeclaredField("myName");
            privateField.setAccessible(true);//对于访问权限不是public的字段，要想访问，必须调用setAccessible。
            System.out.printf("%s\n",(String)privateField.get(object));
            privateField.set(object,"Wong");
            System.out.printf("%s\n",(String)privateField.get(object));



        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取所有方法
    public void getAllMethod() {
        try {
            Class<?> clazz = Class.forName("TestObject");
            //获得所有的具有public访问权限的方法
            Method[] methods = clazz.getMethods();
            System.out.printf("获得所有的具有public访问权限的方法:\n ");
            for (Object o : methods) {
                System.out.printf("%s\n", o.toString());
            }

            //获得指定的具有public访问权限的方法
            Method method = clazz.getMethod("setMyArg", int.class);
            System.out.printf("获得指定的具有public访问权限的方法:\n ");
            System.out.printf("%s\n", method.toString());

            //获得所有方法，包括public, private,protected和默认权限的方法
            Method[] declaredMethods = clazz.getDeclaredMethods();
            System.out.printf("获得所有方法，包括public, private,protected和默认权限的方法:\n");
            for (Object o : declaredMethods) {
                System.out.printf("%s\n", o.toString());
            }

            //获得指定的方法，方法的访问权限包括public, private,protected和默认权限的

            Method declaredMethod = clazz.getDeclaredMethod("say", String.class);
            System.out.printf("获得指定的方法，方法的访问权限包括public, private,protected和默认权限的:\n");
            System.out.printf("%s\n", declaredMethod.toString());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    //使用已获得的方法
    public void useMethod(){

        try {
            Class<?> clazz = Class.forName("TestObject");

            Method method = clazz.getMethod("handleData", String.class, HashMap.class);//有public权限的
            TestObject testObject = new TestObject();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", "Kingkong");
            method.invoke(testObject, "Tom", hashMap);

            Method privateMethod = clazz.getDeclaredMethod("con");
            privateMethod.setAccessible(true);//对于访问权限不是public的方法，要想访问，必须调用setAccessible。
            privateMethod.invoke(testObject);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    //利用反射技术处理数组
    public void handlArray() {
        String[] nameArr = new String[]{"Tom", "John", "Lucy", "Barkerly"};
        Array.set(nameArr, 0, "Wongkyunban"); //修改数组的值
        Class clazz = nameArr.getClass();
        if (clazz.isArray()) {
            int len = Array.getLength(nameArr);
            for (int i = 0; i < len; i++) {
                Object object = Array.get(nameArr, i);
                String className = object.getClass().getName();
                System.out.println("--> object=" + object + ",className=" + className);
            }
        }


    }

    //使用反射获得泛型类型
    public void getGenericType(){
        try {
            //Class<?> clazz = TestObject.class;与下面等价
            Class<?> clazz = Class.forName("TestObject");
            Method genericTypeMethod = clazz.getDeclaredMethod("handleData", String.class,HashMap.class);
            //获得所有的参数类型
            Type[] genericParameterTypes = genericTypeMethod.getGenericParameterTypes();
            //检验是否为空
            if (null == genericParameterTypes || genericParameterTypes.length < 1) {
                return;
            }

            //取方法第2个参数,获得泛型参数的类型
            ParameterizedType parameterizedType = (ParameterizedType)genericParameterTypes[1];
            Type rawType = parameterizedType.getRawType();
            System.out.printf("--->raw type:%s\n",rawType);

            //取得第二个泛型参数类型
            Type[] actualTypeArgs = parameterizedType.getActualTypeArguments();
            if(actualTypeArgs == genericParameterTypes || actualTypeArgs.length < 1){
                return;
            }
            //打印出每一个类型
            for (int i = 0; i < actualTypeArgs.length; i++){
                Type type = actualTypeArgs[i];
                System.out.printf("--->Type:%s\n",type);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //获得Metho,Field,Constructor 的访问权限
    public void showPermmit(){
        try {
            Class<?> clazz = Class.forName("TestObject");

            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor constructor:constructors){
                int modifier = constructor.getModifiers();

                System.out.printf("构造器%s,权限是%s\n",constructor.toString(), Modifier.toString(modifier));
            }
            System.out.printf("\n\n");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields){
                int modifier = field.getModifiers();

                System.out.printf("字段%s,权限是%s\n",field.toString(), Modifier.toString(modifier));
            }
            System.out.printf("\n\n");

            Method[] methods = clazz.getDeclaredMethods();

            for (Method method:methods){
                int modifier = method.getModifiers();

                System.out.printf("方法%s,权限是%s\n",method.toString(), Modifier.toString(modifier));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
