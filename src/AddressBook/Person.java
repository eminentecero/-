package AddressBook;

import java.io.*;

public class Person {
	private String name;
	private String phone;
	private String address;
	private String mail;

	Person() {
		name = null;
		phone = null;
		address = null;
		mail = null;
	}

	// ��ü ������
	Person(String name, String phone, String address, String mail) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.mail = mail;
	}

	// �̸�
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// �޴��ȣ
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// �ּ�
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// �̸��� �ּ�
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	// ��ȯ�� ����
	public String toString() {
		return "\n �̸� : " + this.name + "\n ��ȭ��ȣ : " + this.phone + "\n �ּ� : " + this.address + "\n �̸��� �ּ� : "
				+ this.mail + "\n";
	}

	// ���Ͽ��ٰ� ��ü ������ �Է��ϰ� �ϴ� �Լ�
	public void WriteMyFile(DataOutputStream out) throws IOException {
		// ���Ͽ� �ش� ������ ����.
		out.writeUTF(this.name);
		out.writeUTF(this.phone);
		out.writeUTF(this.address);
		out.writeUTF(this.mail);
	}

	public void readMyFile(DataInputStream in) throws Exception {
		// ����� ������ �� �ҷ��ͼ� �� �޼ҵ忡 setter�� �����ϱ�
		this.setName(in.readUTF());
		this.setPhone(in.readUTF());
		this.setAddress(in.readUTF());
		this.setMail(in.readUTF());
	}
}