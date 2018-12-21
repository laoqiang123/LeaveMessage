package com.example.test.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author laoqiang
 *
 */
public class EmailUtil {
	private static final String HOST = "127.0.0.1";

	/**
	 * 
	 * @param to
	 *            收件人
	 * @param from
	 *            发件人
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static void sendEmail(String to, String from, String subject, String content)
			throws AddressException, MessagingException {
		// 获取系统属性
		Properties properties = System.getProperties();
		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", HOST);
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties);
		// 创建默认的 MimeMessage 对象
		MimeMessage message = new MimeMessage(session);
		// Set From: 头部头字段
		message.setFrom(new InternetAddress(from));
		// Set To: 头部头字段
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		// Set Subject: 头部头字段
		message.setSubject(subject);
		// 设置消息体
		message.setText(content);
		// 发送消息
		Transport.send(message);
	}

}
