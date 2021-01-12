
/**
 * @标题: HelloClassLoader.java
 * @包名： wenjie.ye.mqtest.test.jike.jvm
 * @功能描述：TODO
 * @作者： wenjie.ye
 * @创建时间： 2021年1月7日 上午10:04:58
 * @version v1.0
 */

package wenjie.ye.mqtest.test.jike.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Base64;
import sun.misc.BASE64Encoder;
/**
     * 1双亲委托    父类加载  爷类加载  （先检查父类、爷爷类有没有加载  如果加载过了 就不加载了）
	 * 2负责依赖    加载类中依赖的其他的类
	 * 3缓存加载    只加载类一次 有缓存则不用重复加载
 */

public class HelloClassLoader  extends ClassLoader{
	public static void main(String[] args) {
		try {
			  Object newInstance = new HelloClassLoader().findClass("Hello").newInstance();
			  Class<? extends Object> class1 = newInstance.getClass();
			  Method method = class1.getMethod("hello",null);
			  method.invoke(newInstance, null);
		} catch ( Exception e) {
			e.printStackTrace();
		}  
	}
	
	@Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
		String Hellobase64=null;
		try {
			 Hellobase64 = encodeBase64File("H:/learn/极客大学/2021.01.06jvm/课后/Hello/Hello.xlass");
		} catch (Exception e) {
			e.printStackTrace();
		};
		byte[] bytes = decode(Hellobase64);
		return defineClass(name,bytes,0,bytes.length);
    }
	
	public static String encodeBase64File(String path) throws Exception {
		
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        String replace = new BASE64Encoder().encode(buffer).replace("\r\n", ""); 
        return replace;
    }
	
	public   byte[]  decode(String base64){
		     byte[] decode = Base64.getDecoder().decode(base64);
	    	 byte a=(byte) 255 ;
		     for (int i = 0; i < decode.length; i++) {
				 byte b = decode[i];
				 decode[i]= (byte) (a -b);
			}
		    return decode;
	}
}
