package com.szss.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.beans.editors.DoubleEditor;
import com.sun.beans.editors.FloatEditor;
import com.sun.beans.editors.IntegerEditor;
import com.sun.beans.editors.LongEditor;
import com.szss.alg.HolidayStrategy;
import com.szss.factory.PeopleFactory;
import com.szss.model.Attendance;
import com.szss.model.Dept;
import com.szss.model.DeptSchedule;
import com.szss.model.News;
import com.szss.model.People;
import com.szss.model.Project;
import com.szss.model.User;
import com.szss.model.UserSchedule;
import com.szss.pwencode.EncodeOperation;
import com.szss.pwencode.EncodeOperationAdapter;
import com.szss.service.IndexService;

@Controller
public class IndexController {
    @Resource
    private IndexService indexService;
    
    
    @InitBinder    
    public void initBinder(WebDataBinder binder) {    
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new LongEditor());  
        binder.registerCustomEditor(double.class, new DoubleEditor());  
        binder.registerCustomEditor(float.class, new FloatEditor());
    }
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index"); 
		return mav;
	}
	
	@RequestMapping("/logon")
	public ModelAndView logon() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("info", "请登录");
		mav.setViewName("logon"); 
		return mav;
	}
	
	
	
	
	//简单工厂
	//Adapter 适配器
	@RequestMapping("/userLogon")
	public ModelAndView userLogon(String account, String password, Integer roleId, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		
		EncodeOperation operation=new EncodeOperationAdapter();
		password=operation.encode1(operation.encode2(password));
		
		
		map.put("account", account);
		map.put("password", password);
		map.put("roleId", roleId);
		
			User user = indexService.userLogon(map);
			if (user == null) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("info", "用户名或密码错误！");
				mav.setViewName("logon");
				
				return mav;
			} else {
				PeopleFactory pf=new PeopleFactory();
				People role=pf.findRole(user);
				session.setAttribute("user", role);
				if (role.getRoleId() == 0) {
					return new ModelAndView("redirect:/index.html");
				} else {
					return new ModelAndView("redirect:/userIndex.html");
				}
			}
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("user", null);
		
		return new ModelAndView("redirect:logon.html");
	}
	
//	@RequestMapping("/teacherIndex")
//	public ModelAndView teacherindex() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("teacherIndex");
//		return mav;
//	}
	
	@RequestMapping("/createUser")
	public ModelAndView createUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("depts", indexService.getDepts());
		mav.addObject("nationals", indexService.getNationals());
		mav.addObject("educations", indexService.getEducation());
		
		mav.setViewName("createUser");
		return mav;
	}
	
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUser(User user) {
		user.setNumber(String.valueOf(System.currentTimeMillis()));
		user.setRoleId(1);
		indexService.saveUser(user);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "新增成功！");
	    mav.setViewName("createUser");
	    return mav;
		//return new ModelAndView("redirect:/createUser.html");
	}
	
	@RequestMapping("/updateUser/{id}")
	public ModelAndView updateUser(@PathVariable("id") Integer id) {
		User user = indexService.getUserById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("depts", indexService.getDepts());
		mav.addObject("nationals", indexService.getNationals());
		mav.addObject("educations", indexService.getEducation());
		mav.addObject("user", user);
		
		mav.setViewName("updateUser");
		return mav;
	}
	
	@RequestMapping("/editUser/{id}")
	public ModelAndView editUser(@PathVariable("id") Integer id, User user) {
		user.setId(id);
		indexService.updateUser(user);
		
		return new ModelAndView("redirect:/searchUser.html");
		
	}
	
	@RequestMapping("/searchUser")
	public ModelAndView searchUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", indexService.getUsers());
		mav.setViewName("searchUser");
		return mav;
	}
	
	@RequestMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") Integer id) {
		
		indexService.deleteUsers(id);
		
		return new ModelAndView("redirect:/searchUser.html");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/createDept")
	public ModelAndView createDept() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("createDept");
		return mav;
	}
	
	
	@RequestMapping("/saveDept")
	public ModelAndView saveDept(Dept dept) {
		dept.setNumber(String.valueOf(System.currentTimeMillis()));
		indexService.saveDept(dept);
		
		return new ModelAndView("redirect:/createDept.html");
	}
	
	@RequestMapping("/updateDept/{id}")
	public ModelAndView updateDept(@PathVariable("id") Integer id) {
		Dept dept = indexService.getDeptById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dept", dept);
		
		mav.setViewName("updateDept");
		return mav;
	}
	
	@RequestMapping("/editDept/{id}")
	public ModelAndView editDept(@PathVariable("id") Integer id, Dept dept) {
		dept.setId(id);
		indexService.updateDept(dept);
		
		return new ModelAndView("redirect:/searchDept.html");
		
	}
	
	@RequestMapping("/searchDept")
	public ModelAndView searchDept() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("depts", indexService.getDepts());
		mav.setViewName("searchDept");
		return mav;
	}
	
	@RequestMapping("/deleteDept/{id}")
	public ModelAndView deleteDept(@PathVariable("id") Integer id) {
		indexService.deleteDept(id);
		
		return new ModelAndView("redirect:/searchDept.html");
		
	}
	
	
	
	
	
	
	
	@RequestMapping("/createDeptSchedule")
	public ModelAndView createDeptSchedule() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("depts", indexService.getDepts());
		mav.setViewName("createDeptSchedule");
		return mav;
	}
	
	
	@RequestMapping("/saveDeptSchedule")
	public ModelAndView saveDeptSchedule(DeptSchedule deptSchedule) {
		indexService.saveDeptSchedule(deptSchedule);
		
		return new ModelAndView("redirect:/createDeptSchedule.html");
	}
	
	@RequestMapping("/updateDeptSchedule/{id}")
	public ModelAndView updateDeptSchedule(@PathVariable("id") Integer id) {
		DeptSchedule deptSchedule = indexService.getDeptScheduleById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("depts", indexService.getDepts());
		mav.addObject("deptSchedule", deptSchedule);
		
		mav.setViewName("updateDeptSchedule");
		return mav;
	}
	
	@RequestMapping("/editDeptSchedule/{id}")
	public ModelAndView editDeptSchedule(@PathVariable("id") Integer id, DeptSchedule deptSchedule) {
		deptSchedule.setId(id);
		indexService.updateDeptSchedule(deptSchedule);
		
		return new ModelAndView("redirect:/searchDeptSchedule.html");
		
	}
	
	@RequestMapping("/searchDeptSchedule")
	public ModelAndView searchDeptSchedule() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("deptSchedules", indexService.getDeptSchedules());
		mav.setViewName("searchDeptSchedule");
		return mav;
	}
	
	@RequestMapping("/deleteDeptSchedule/{id}")
	public ModelAndView deleteDeptSchedule(@PathVariable("id") Integer id) {
		indexService.deleteDeptSchedule(id);
		
		return new ModelAndView("redirect:/searchDeptSchedule.html");
		
	}
	
	@RequestMapping("searchUserDoc")
	public ModelAndView searchUserDoc() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", indexService.getUsers());
		mav.setViewName("searchUserDoc");
		return mav;
	}
	
	@RequestMapping("searchMyDoc")
	public ModelAndView searchMyDoc(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user=(User) session.getAttribute("user");
		mav.addObject("user", indexService.getUserById(user.getId()));
		mav.setViewName("searchMyDoc");
		return mav;
	}
	
	
	@RequestMapping("/createNews")
	public ModelAndView createNews() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("createNews");
		
		return mav;
	}
	
	@RequestMapping("/saveNews")
	public ModelAndView saveNews(News news) {
		news.setUserId(1);
		news.setCreateTime(new Date());
		indexService.saveNews(news);
		
		return new ModelAndView("redirect:/createNews.html");
	}
	
	@RequestMapping("/updateNews/{id}")
	public ModelAndView updateNews(@PathVariable("id") Integer id) {
		News news = indexService.getNewsById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("news", news);
		
		mav.setViewName("updateNews");
		return mav;
	}
	
	@RequestMapping("/editNews/{id}")
	public ModelAndView editNews(@PathVariable("id") Integer id, News news) {
		news.setId(id);
		indexService.updateNews(news);
		
		return new ModelAndView("redirect:/searchNews.html");
		
	}
	
	@RequestMapping("/searchNews")
	public ModelAndView searchNews() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("news", indexService.getNews());
		mav.setViewName("searchNews");
		return mav;
	}
	
	@RequestMapping("/searchNewsInfo")
	public ModelAndView searchNewsInfo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("news", indexService.getNews());
		mav.setViewName("searchNewsInfo");
		return mav;
	}
	@RequestMapping("/searchNewsInfo2")
	public ModelAndView searchNewsInfo2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("news", indexService.getNews());
		mav.setViewName("searchNewsInfo2");
		return mav;
	}
	
	@RequestMapping("/deleteNews/{id}")
	public ModelAndView deleteNews(@PathVariable("id") Integer id) {
		indexService.deleteNews(id);
		
		return new ModelAndView("redirect:/searchNews.html");
		
	}
	
	@RequestMapping("/createAttendance")
	public ModelAndView createAttendance() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", indexService.getUsers());
		mav.setViewName("createAttendance");
		
		return mav;
	}
	
	@RequestMapping("/saveAttendance")
	public ModelAndView saveAttendance(Attendance attendance) {
		indexService.saveAttendence(attendance);
		//System.out.println("attendance.day:"+attendance.getRecordDate());
		
		return new ModelAndView("redirect:/createAttendance.html");
	}
	
	
	
	//策略模式
	@RequestMapping("/searchAttendance")
	public ModelAndView searchAttendance() {
		ModelAndView mav = new ModelAndView();
		HolidayStrategy hs=new HolidayStrategy();
		List<Attendance> attendanceList=indexService.getAttendance();
		List<Project> projectList=indexService.getProject();
		for(int i=0;i<attendanceList.size();i++){
			Attendance atten=attendanceList.get(i);
			for(int j=0;j<projectList.size();j++){
				Project pro=projectList.get(j);
				if((pro.getUserid()==atten.getUserId())&&(atten.getRecordDate().getMonth()-1==pro.getEndDate().getMonth())&&(atten.getRecordDate().getYear()==pro.getEndDate().getYear())){					
					//System.out.println("pro:"+pro.getUserid()+" atten:"+atten.getUserId());
					//System.out.println(atten.getRecordDate().getYear());
					atten.setVacation(hs.arrangeholidays(atten.getRecordDate().getYear(),atten.getRecordDate().getMonth()-1,1));
					break;
				}
				if(j==projectList.size()-1){
					atten.setVacation(hs.arrangeholidays(atten.getRecordDate().getYear(),atten.getRecordDate().getMonth()-1,0));
				}
			}
			attendanceList.set(i, atten);
		}
		mav.addObject("attendances", attendanceList);
		mav.setViewName("searchAttendance");
		return mav;
	}
	@RequestMapping("/searchAttendanceByUser")
	public ModelAndView searchAttendanceByUser(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user=(User) session.getAttribute("user");
		//策略模式
		HolidayStrategy hs=new HolidayStrategy();
		List<Attendance> attendanceList=indexService.getAttendanceByUser(user.getId());
		List<Project> projectList=indexService.getProjectByUser(user.getId());
		for(int i=0;i<attendanceList.size();i++){
			Attendance atten=attendanceList.get(i);
			for(int j=0;j<projectList.size();j++){
				Project pro=projectList.get(j);
				if((atten.getRecordDate().getMonth()==pro.getEndDate().getMonth()-1)&&(atten.getRecordDate().getYear()==pro.getEndDate().getYear())){
					atten.setVacation(hs.arrangeholidays(atten.getRecordDate().getYear(),atten.getRecordDate().getMonth()-1,1));
					break;
				}
				if(j==projectList.size()-1){
					atten.setVacation(hs.arrangeholidays(atten.getRecordDate().getYear(),atten.getRecordDate().getMonth()-1,0));
				}
			}
			if(projectList.size()==0){
				atten.setVacation(hs.arrangeholidays(atten.getRecordDate().getYear(),atten.getRecordDate().getMonth()-1,0));
			}
			attendanceList.set(i, atten);
		}
		
		
		
		
		mav.addObject("attendances", attendanceList);
		mav.setViewName("searchAttendance");
		return mav;
	}
	
	@RequestMapping("/searchUserWages")
	public ModelAndView searchUserWages() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", indexService.getUsers());
		
		mav.setViewName("searchUserWages");
		return mav;
	}
	@RequestMapping("/searchUserWages2")
	public ModelAndView searchUserWages2(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user=(User) session.getAttribute("user");
		
		mav.addObject("user", indexService.getUserById(user.getId()));
		mav.setViewName("searchUserWages2");
		return mav;
	}
	
	@RequestMapping("/updateUserWages/{id}")
	public ModelAndView updateUserWages(@PathVariable("id") Integer id, Double wages) {
		User user = indexService.getUserById(id);
		user.setWages(wages);
		
		indexService.updateUser(user);
		return new ModelAndView("redirect:/searchUserWages.html");
	}
	
	@RequestMapping("/createProject")
	public ModelAndView createProject() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("createProject");
		return mav;
	}
	
	@RequestMapping("/saveProject")
	public ModelAndView saveProject(Project project,HttpSession session) {
		User user=(User) session.getAttribute("user");
		project.setState(0);
		project.setUserid(user.getId());
		project.setUsername(user.getName());
		indexService.saveProject(project);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "新增成功！");
	    mav.setViewName("createProject");
	    return mav;
		//return new ModelAndView("redirect:/createProject.html");
	}
	
	@RequestMapping("/updateProject/{id}")
	public ModelAndView updateProject(@PathVariable("id") Integer id) {
		Project project = indexService.getProjectById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("project", project);
		
		mav.setViewName("updateProject");
		return mav;
	}
	@RequestMapping("/checkProject/{id}")
	public ModelAndView checkProject(@PathVariable("id") Integer id,
			@RequestParam("action") Integer state) {
		indexService.checkProject(id,state);
		
		return new ModelAndView("redirect:/searchProject.html");
		
	}
	
	@RequestMapping("/editProject/{id}")
	public ModelAndView editProject(@PathVariable("id") Integer id, Project project) {
		project.setId(id);
		indexService.updateProject(project);
		
		return new ModelAndView("redirect:/searchProject.html");
		
	}
	
	@RequestMapping("/searchProject")
	public ModelAndView searchProject(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		People user=(People) session.getAttribute("user");
		Integer id= user.getId();
		if(user.getRoleId()==0){
			id=0;
		}
		mav.addObject("projects", indexService.getProjectByUser(id));
		mav.setViewName("searchProject");
		return mav;
	}
	
	@RequestMapping("/deleteProject/{id}")
	public ModelAndView deleteProject(@PathVariable("id") Integer id) {
		indexService.deleteProject(id);
		
		return new ModelAndView("redirect:/searchProject.html");
		
	}
	@RequestMapping("/deleteNews2/{id}")
	public ModelAndView deleteNews2(@PathVariable("id") Integer id) {
		indexService.deleteNews(id);
		return new ModelAndView("redirect:/searchNewsInfo.html");
		
	}
	
	@RequestMapping("userIndex")
	public ModelAndView userIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userIndex");
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/createUserSchedule")
	public ModelAndView createUserSchedule() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("createUserSchedule");
		return mav;
	}
	
	
	@RequestMapping("/saveUserSchedule")
	public ModelAndView saveUserSchedule(UserSchedule userSchedule,HttpSession session) {
		
		People user=(People) session.getAttribute("user");
		userSchedule.setUserId(user.getId()); 
		indexService.saveUserSchedule(userSchedule);
		
		return new ModelAndView("redirect:/searchUserSchedule.html");
	}
	
	@RequestMapping("/updateUserSchedule/{id}")
	public ModelAndView updateUserSchedule(@PathVariable("id") Integer id) {
		UserSchedule userSchedule = indexService.getUserScheduleById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userSchedule", userSchedule);
		
		mav.setViewName("updateUserSchedule");
		return mav;
	}
	
	@RequestMapping("/editUserSchedule/{id}")
	public ModelAndView editUserSchedule(@PathVariable("id") Integer id, UserSchedule userSchedule) {
		userSchedule.setId(id);
		userSchedule.setUserId(id);
		indexService.updateUserSchedule(userSchedule);
		
		return new ModelAndView("redirect:/searchUserSchedule.html");
		
	}
	
	@RequestMapping("/searchUserSchedule")
	public ModelAndView searchUserSchedule(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		People user=(People) session.getAttribute("user");
		mav.addObject("userSchedules", indexService.getUserSchedules(user.getId()));
		mav.setViewName("searchUserSchedule");
		return mav;
	}
	
	@RequestMapping("/deleteUserSchedule/{id}")
	public ModelAndView deleteUserSchedule(@PathVariable("id") Integer id) {
		indexService.deleteUserSchedule(id);
		
		return new ModelAndView("redirect:/searchUserSchedule.html");
		
	}
	

}
