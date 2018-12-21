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
	 *            �ռ���
	 * @param from
	 *            ������
	 * @param subject
	 *            �ʼ�����
	 * @param content
	 *            �ʼ�����
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static void sendEmail(String to, String from, String subject, String content)
			throws AddressException, MessagingException {
		// ��ȡϵͳ����
		Properties properties = System.getProperties();
		// �����ʼ�������
		properties.setProperty("mail.smtp.host", HOST);
		// ��ȡĬ��session����
		Session session = Session.getDefaultInstance(properties);
		// ����Ĭ�ϵ� MimeMessage ����
		MimeMessage message = new MimeMessage(session);
		// Set From: ͷ��ͷ�ֶ�
		message.setFrom(new InternetAddress(from));
		// Set To: ͷ��ͷ�ֶ�
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		// Set Subject: ͷ��ͷ�ֶ�
		message.setSubject(subject);
		// ������Ϣ��
		message.setText(content);
		// ������Ϣ
		Transport.send(message);
	}

}
