/**
 * ‎Hangzhou Lejian Technology Co., Ltd.
 * Copyright (c) 2019 All Rights Reserved.
 */
package solution;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户注册入口
 * 
 * @author liuxishan
 *
 */
public class SigninController {

    private static SigninController INSTANCE = new SigninController();

    public static SigninController getInstance(){
        return INSTANCE;
    }
    private UserService userService = UserService.getInstance();

    class User{//用户
        private int id;
        private String userName;
        private String mobilePhone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }
    }
    class Response<T>{
        private boolean success;
        private String message;
        private T data;

        public Response() {
        }
        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

     static class UserService {
        private static  UserService INSTANCE = new UserService();
        public static UserService getInstance(){
            return INSTANCE;
        }
        ConcurrentHashMap<Integer, User> userCache = new ConcurrentHashMap();
        ConcurrentHashMap<String, User> phoneCache = new ConcurrentHashMap();
        public User selectById(int id) {
            return userCache.get(id);
        }

        public User selectByMobilePhone(String phone) {
            return phoneCache.get(phone);
        }

        public String checkValidPhone(String phone) {
            if(selectByMobilePhone(phone)!=null){
                return "此手机号已经被其他用户注册";
            }
            return isMobiPhoneNum(phone);
        }

        public void insertUser(User user) {
            userCache.put(user.getId(), user);
            phoneCache.put(user.getMobilePhone(), user);
        }

        public Response<String> register(User user) {
            user.setMobilePhone(user.getMobilePhone().replace(" ",""));
            String errMsg = checkValidPhone(user.getMobilePhone());
            SigninController.Response<String> response =  SigninController.getInstance().new Response();
            if (errMsg == null || !errMsg.isEmpty()) {
                response.setSuccess(false);
                response.setMessage(errMsg);
                return response;
            }
            insertUser(user);
            response.setSuccess(true);
            response.setData("手机号注册成功");
            return response;
        }

        private String isMobiPhoneNum(String telNum) {
            String regex = "^\\d{0,11}$";
            String regexCh = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
            Pattern pCh = Pattern.compile(regexCh, Pattern.CASE_INSENSITIVE);
            Matcher mCh = pCh.matcher(telNum);
            Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(telNum);
            if (m.matches() && mCh.matches()) { //通过
                return "";
            } else if (m.matches() && !mCh.matches()) { //非大陆
                return "此手机号码为中国大陆非法手机号码";
            } else { //不通过
                return "非法手机号";
            }

        }
    }
    public String register(User user){
        Response<String> response = userService.register(user);
        if(response.isSuccess()){
            return response.getData();
        }else {
            return response.getMessage();
        }
    }
	/**
	 * TODO 请从这里开始补充代码
	 * 
	 * 测试1：138 1234 1234
	 *	结果：通过此手机号注册成功
	 *
	 * 测试2：13812345abc
	 *	结果：通知本手机号无法注册，提示为非法手机号
	 *
	 * 测试3：13812345678
	 *	结果：通知此手机号注册成功
	 *
	 * 测试4：138 1234 5678
	 *	结果：提示此手机号已经被其他用户注册
	 *
	 * 测试5：98765432101
	 *	结果：此手机号码为中国大陆非法手机号码
	 */

    public static void main(String[] args) {
        SigninController.User user =  SigninController.getInstance().new User();
        user.setId(1);
        user.setMobilePhone("138 1234 1234");
        user.setUserName("test1");
        System.out.println(SigninController.getInstance().register(user));

        user =  SigninController.getInstance().new User();
        user.setId(2);
        user.setMobilePhone("13812345abc");
        user.setUserName("test2");
        System.out.println(SigninController.getInstance().register(user));

        user =  SigninController.getInstance().new User();
        user.setId(3);
        user.setMobilePhone("13812345678");
        user.setUserName("test3");
        System.out.println(SigninController.getInstance().register(user));

        user =  SigninController.getInstance().new User();
        user.setId(4);
        user.setMobilePhone("138 1234 5678");
        user.setUserName("test4");
        System.out.println(SigninController.getInstance().register(user));

        user =  SigninController.getInstance().new User();
        user.setId(5);
        user.setMobilePhone("98765432101");
        user.setUserName("test5");
        System.out.println(SigninController.getInstance().register(user));

    }
}
