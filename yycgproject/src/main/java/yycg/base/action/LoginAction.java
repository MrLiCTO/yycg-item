package yycg.base.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yycg.base.pojo.vo.ActiveUser;
import yycg.base.process.context.Config;
import yycg.base.process.result.ResultUtil;
import yycg.base.process.result.SubmitResultInfo;
import yycg.base.service.UserService;

@Controller
public class LoginAction {
	
	
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/login")
	public String login(){
		return "/base/login";
	}
	
	@RequestMapping("/loginsubmit")
	public @ResponseBody SubmitResultInfo loginsubmit(HttpSession session,String userid,String pwd,String validateCode) throws Exception{
		
		String validateCode_session=(String) session.getAttribute("validateCode");
		if(validateCode_session==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,113,null));
		}else{
			if(!validateCode_session.equalsIgnoreCase(validateCode)){
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,113,null));
			}
		}
		
		
		
		ActiveUser activeUser=userService.checkUserInfo(userid, pwd);
		
		session.setAttribute(Config.ACTIVEUSER_KEY,activeUser);
		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE,107, new Object[]{""}));
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		
		return "redirect:login.action";
	}
}
