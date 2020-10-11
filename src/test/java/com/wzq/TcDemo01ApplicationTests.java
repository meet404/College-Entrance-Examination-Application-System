package com.wzq;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzq.mapper.MajorMapper;
import com.wzq.mapper.SchoolMapper;
import com.wzq.mapper.ScoreMapper;
import com.wzq.pojo.Major;
import com.wzq.pojo.School;
import com.wzq.pojo.Score;
import com.wzq.pojo.User;
import com.wzq.service.HeatService;
import com.wzq.service.SchoolService;
import com.wzq.service.UserService;
import com.wzq.utils.GetHtmlText;
import com.wzq.utils.GetNum;
import com.wzq.utils.GuuidUtil;
import com.wzq.utils.GetSaltUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@SpringBootTest
class TcDemo01ApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	@Autowired
	private MajorMapper majorMapper;

	@Autowired
	private ScoreMapper scoreMapper;

	@Autowired
	private SchoolMapper schoolMapper;

	@Autowired
	private HeatService heatService;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		long uuid = GuuidUtil.getUUID();
		System.out.println(uuid);
	}

	@Test
	public void test() {
		List<Major> all = majorMapper.findAll();
		all.forEach(System.out::println);
	}

	@Test
	public void test2() {
		List<Major> all = majorMapper.findAll();
		all.forEach(System.out::println);
	}

	@Test
	public void test3() {
		List<Score> allBySchoolId = scoreMapper.findAllBySchoolId(100587486396284928L);
		allBySchoolId.forEach(System.out::println);
	}

	@Test
	public void test4() {
		heatService.updateHeat(100587486396284928L);
	}

	@Test
	public void test5() {
		System.out.println(schoolService.count());
	}

	@Test
	public void test6() {
		Page<School> page = new Page<>(1, 10);
		schoolMapper.selectPage(page, null);
		List<School> list = page.getRecords();
		System.out.println(list);
	}

	@Test
	public void test7() {
		List<School> list = schoolService.findSchoolByName("test");
		System.out.println(list);
	}

	@Test
	public void test8() {
		List<Major> list = majorMapper.findAllByName("工业");
		System.out.println(list);
	}

	@Test
	public void test9() {
		PageHelper.startPage(1, 1);
		List<Major> all = majorMapper.findAll();
		PageInfo<Major> pageInfo = new PageInfo<>(all);
		System.out.println(pageInfo);
	}

	@Test
	public void test10() {
		/*User user = userService.querryUserLogin("test");
		System.out.println(user);*/
	}

	@Test
	public void test11() throws MessagingException {
		String email = "meet404@163.com";
		String num = GetNum.getNum();
		sendMail(num, email);
	}

	public void sendMail(String text, String sendTo) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject("您的验证码是");
		helper.setText(text, true);
		helper.setTo(sendTo);
		helper.setFrom("yourhero666@126.com");
		mailSender.send(mimeMessage);
	}

	@Test
	public void test12() {
		User user = new User();
		user.setId(102785872243458048L);
		userService.activeUser(user);
	}

	@Test
	public void test14(){
		test13(102785872243458048L);
	}

	public String test13(long id) {
		if (String.valueOf(id).length() != 18) {
			System.out.println("不存在");
			System.out.println(String.valueOf(id).length());
			return "不存在";
		} else {
			User user = userService.findUserById(id);
			if (user == null) {
				System.out.println("连接有误");
				return "连接有误";
			} else {
				if (user.getUserStatus() == 2) {
					userService.activeUser(user);
					System.out.println("激活成功");
					return "ok";
				} else {
					System.out.println("访问错误");
					return "访问错误";
				}
			}
		}

	}

}
