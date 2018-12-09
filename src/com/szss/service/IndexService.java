package com.szss.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.szss.alg.CalWages;
import com.szss.alg.CalWagesbyAmount;
import com.szss.dao.AttendanceMapper;
import com.szss.dao.DeptMapper;
import com.szss.dao.DeptScheduleMapper;
import com.szss.dao.EducationMapper;
import com.szss.dao.NationalMapper;
import com.szss.dao.NewsMapper;
import com.szss.dao.ProjectMapper;
import com.szss.dao.UserMapper;
import com.szss.dao.UserScheduleMapper;
import com.szss.model.Attendance;
import com.szss.model.Dept;
import com.szss.model.DeptSchedule;
import com.szss.model.Education;
import com.szss.model.National;
import com.szss.model.News;
import com.szss.model.Project;
import com.szss.model.User;
import com.szss.model.UserSchedule;
import com.szss.pwencode.EncodeOperation;
import com.szss.pwencode.EncodeOperationAdapter;

@Service("index")
public class IndexService{
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private DeptMapper deptMapper;
	
	@Resource
	private EducationMapper educationMapper;
	
	@Resource
	private NationalMapper nationalMapper;
	
	@Resource
	private DeptScheduleMapper deptScheduleMapper;
	
	@Resource
	private NewsMapper newsMapper;
	
	@Resource
	private AttendanceMapper attendanceMapper;
	
	@Resource
	private ProjectMapper projectMapper;
	
	@Resource
	private UserScheduleMapper userScheduleMapper;
	
	public void saveUser(User user) {
		EncodeOperation operation=new EncodeOperationAdapter();
		String password=user.getPassword();
		password=operation.encode1(operation.encode2(password));
		user.setPassword(password);
		
		userMapper.saveEntity(user);
	}
	
	public List<Dept> getDepts() {
		return deptMapper.searchEntity();
	}
	
	public List<National> getNationals() {
		return nationalMapper.searchEntity();
	}
	
	public List<Education> getEducation() {
		return educationMapper.searchEntity();
	}
	
	public void updateUser(User user) {
		EncodeOperation operation=new EncodeOperationAdapter();
		User userori=userMapper.getEntityById(user.getId());
		if(!user.getPassword().equals(userori.getPassword())){
			String password=user.getPassword();
			user.setPassword(operation.encode1(operation.encode2(password)));
		}
		
//		String password=user.getPassword();
//		password=operation.encode1(operation.encode2(password));
//		
//		String password1=operation.encode1(operation.encode2(password));
//		String passwordori=operation.encode1(operation.encode2(userori.getPassword()));
//		if(!passwordori.equals(password1)){
//			user.setPassword(password);
//		}
		
		userMapper.updateEntity(user);
	}
	
	public User getUserById(Integer id) {
		return userMapper.getEntityById(id);
	}
	
	public List<User> getUsers() {
		return userMapper.searchEntity();
	}
	public List<User> getMessageUsers(Integer userid) {
		//System.out.println("userid"+userid);
		return userMapper.searchMessageEntity(userid);
	}
	public void deleteUsers(Integer id) {
		userMapper.deleteEntity(id);
	}
	
	public void saveDept(Dept dept) {
		deptMapper.saveEntity(dept);
	}
	
	public void updateDept(Dept dept) {
		deptMapper.updateEntity(dept);
	}
	
	public Dept getDeptById(Integer id) {
		return deptMapper.getEntityById(id);
	}
	
	public void deleteDept(Integer id) {
		deptMapper.deleteEntity(id);
	}
	
	
	
	
	
	public void saveDeptSchedule(DeptSchedule deptSchedule) {
		deptScheduleMapper.saveEntity(deptSchedule);
	}
	
	public void updateDeptSchedule(DeptSchedule deptSchedule) {
		deptScheduleMapper.updateEntity(deptSchedule);
	}
	
	public DeptSchedule getDeptScheduleById(Integer id) {
		return deptScheduleMapper.getEntityById(id);
	}
	
	public List<DeptSchedule> getDeptSchedules() {
		return deptScheduleMapper.searchEntity();
	}
	
	public void deleteDeptSchedule(Integer id) {
		deptScheduleMapper.deleteEntity(id);
	}
	
	
	
	
	public void saveNews(News news) {
		newsMapper.saveEntity(news);
	}
	
	public void updateNews(News news) {
		newsMapper.updateEntity(news);
	}
	
	public News getNewsById(Integer id) {
		return newsMapper.getEntityById(id);
	}
	
	public List<News> getNews() {
		return newsMapper.searchEntity();
	}
	
	public void deleteNews(Integer id) {
		newsMapper.deleteEntity(id);
	}
	
	//Template模板模式
	public void saveAttendence(Attendance attendance) {
		attendanceMapper.saveEntity(attendance);
		
		CalWages cw=new CalWagesbyAmount();
		User user = this.getUserById(attendance.getUserId());
		//项目数量
		int projectNum=this.getProjectByUser(attendance.getUserId()).size();
		System.out.println("attendance.getRealAmount()+projectNum"+attendance.getRealAmount()+projectNum);
		user.setWages(cw.cal(attendance.getRealAmount(), projectNum));
		this.updateUser(user);
	}
	
	public List<Attendance> getAttendance() {
		return attendanceMapper.searchEntity();
	}
	
	public void saveProject(Project project) {
		projectMapper.saveEntity(project);
	}
	
	public void updateProject(Project project) {
		projectMapper.updateEntity(project);
	}
	
	public Project getProjectById(Integer id) {
		return projectMapper.getEntityById(id);
	}
	
	public List<Project> getProject() {
		return projectMapper.searchEntity();
	}
	public List<Project> getProjectByUser(Integer id) {
		return projectMapper.getProjectByUser(id);
	}
	
	public void deleteProject(Integer id) {
		projectMapper.deleteEntity(id);
	}
	
	
	public void saveUserSchedule(UserSchedule userSchedule) {
		userScheduleMapper.saveEntity(userSchedule);
	}
	
	public void updateUserSchedule(UserSchedule userSchedule) {
		userScheduleMapper.updateEntity(userSchedule);
	}
	
	public UserSchedule getUserScheduleById(Integer id) {
		return userScheduleMapper.getEntityById(id);
	}
	
	public List<UserSchedule> getUserSchedules(Integer id) {
		return userScheduleMapper.searchEntity(id);
	}
	
	
	public void deleteUserSchedule(Integer id) {
		userScheduleMapper.deleteEntity(id);
	}
	
	public User userLogon(Map<String, Object> map) {
		return userMapper.userLogon(map);
	}

	public void checkProject(Integer id, Integer state) {
		Project p=new Project();
		p.setId(id);
		p.setState(state);
		projectMapper.checkProject(p);
		
	}

	public List<Attendance> getAttendanceByUser(Integer userid) {
		return attendanceMapper.searchByUser(userid);
	}

	
	
}
