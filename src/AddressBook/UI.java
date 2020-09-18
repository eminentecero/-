package AddressBook;

import java.io.*;
import java.util.Scanner;

public class UI {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String name; // �̸�
		String phone; // ��ȭ��ȣ
		String address; // �ּ�
		String mail; // �̸��� �ּ�
		String key; // ã�� ��� - ã����� ��� �̸� �Է�
		int index; // ã�� ��ɿ��� �˻� �� ã�� ��� ���°���� ��ȯ
		DataOutputStream out = null;

		// AddressBook Ŭ���� �߰�
		AddressBook ab = new AddressBook(100);

		while (true) // �ݺ���
		{
			Menu.menu(); // �޴��� �����ش�.
			int answer = scan.nextInt(); // ��ȣ�� �Է¹޴´�.
			scan.nextLine();
			switch (answer) // ��ȣ�� ���� �޼ҵ� ����
			{
			case 1: // �Է��ϱ� add
				try {
					System.out.print("\n"); // �������� ���� �� �ٲ�

					// ����ڿ��� �Է°� �ޱ�
					System.out.print("�̸��� �Է��ϼ��� : ");
					name = scan.nextLine();
					System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
					phone = scan.nextLine();
					System.out.print("�ּҸ� �Է��ϼ��� : ");
					address = scan.nextLine();
					System.out.print("�̸��� �ּҸ� �Է��ϼ��� : ");
					mail = scan.nextLine();

					// �ߺ� �˻��ϱ� - ���� �ּҿ� �� ���ɼ� �����صΰ� �ּ��� ���� �� �ߺ� �˻�
					for (int j = 0; j < ab.addindex; j++) {
						if (name.equals(ab.getPerson(j).getName()) || phone.equals(ab.getPerson(j).getPhone())
								|| mail.equals(ab.getPerson(j).getMail())) {
							throw new Exception("!)�ߺ��� ������ �ֽ��ϴ�.\n�̸��� ��ȭ��ȣ�� ��Ȯ�ϰ� �Է����ֽðų� �����ϱ⸦ �̿����ֽʽÿ�.");
						}
					}

					// Person ��ü �����ؼ� �ش� ��ü�� ��� ���� �Է�
					Person p = new Person(name, phone, address, mail);

					// AddressBook���� �߰��ϱ� ��� ����
					ab.add(p);
				} catch (Exception e) {
					// throw Exception�� �ִ� �޼��� �о����
					String str = e.getMessage();
					System.out.println(str);
				}
				break;

			case 2: // �˻��ϱ�
				// �˻��� ���� �ޱ�(�̸�)
				System.out.print("�̸��� �Է��ϼ��� : ");
				key = scan.nextLine();
				try {
					// AddressBook�� �ִ� �˻��ϱ� ��� ����
					// ã�� ��� �ε����� �Ҵ�
					index = ab.find(key);
					System.out.println(ab.getPerson(index));
				} catch (Exception e) {
					// throw Exception�� �ִ� �޼��� �о����
					String str = e.getMessage();
					System.out.println(str);
				}

				break;
			case 3: // �����ϱ�
				// ************�����޴� ������ ������ �ִ� �迭 �߿� ���Ե� �迭 ������, ������ �ͼ��� ó���ϵ��� ����
				System.out.print("�̸��� �Է��ϼ��� : ");
				key = scan.nextLine();
				index = 0;
				try {
					// AddressBook�� �ִ� �˻��ϱ� ��� ����
					// ���� �̸����� find�ߴµ� �װ� ���ٸ�? �ͼ��� ó�� & ã�� ��� �ε����� �Ҵ�
					index = ab.find(key);
					System.out.print("\n"); // �������� ���� �� �ٲ�

					// ����ڿ��� �Է°� �ޱ�
					System.out.print("�̸��� �Է��ϼ��� : ");
					name = scan.nextLine();
					System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
					phone = scan.nextLine();
					System.out.print("�ּҸ� �Է��ϼ��� : ");
					address = scan.nextLine();
					System.out.print("�̸��� �ּҸ� �Է��ϼ��� : ");
					mail = scan.nextLine();

					// �̹� �����ϴ� �迭 �߿� ���� �����͸� ���� �迭�� �����ϴ��� �˻�
					for (int i = 0; i < ab.addindex; i++) {
						if (name.equals(ab.getPerson(i).getName()) && phone.equals(ab.getPerson(i).getPhone())
								&& address.equals(ab.getPerson(i).getAddress())
								&& mail.equals(ab.getPerson(i).getMail())) {
							throw new Exception("�ߺ��� �����Ͱ� �̹� �����մϴ�.");
						}

					}
					// Person ��ü �����ؼ� �ش� ��ü�� ��� ���� �Է�
					Person p = new Person(name, phone, address, mail);

					// AddressBook���� �߰��ϱ� ��� ����
					ab.edit(index, p);

				} catch (Exception e) {
					// find���� �̸����� �������� ���� ���
					String str = e.getMessage();
					System.out.println(str);
					continue;
				}
				break;

			case 4: // �����ϱ�
				index = -1;
				System.out.print("�̸��� �Է��ϼ��� : ");
				key = scan.nextLine();
				try {
					// AddressBook�� �ִ� �˻��ϱ� ��� ����
					// ���� �̸����� find�ߴµ� �װ� ���ٸ�? �ͼ��� ó�� & ã�� ��� �ε����� �Ҵ�
					index = ab.find(key);
					System.out.println("���� �Ǿ����ϴ�.");
				} catch (Exception e) {
					// find���� �̸����� �������� ���� ���
					String str = e.getMessage();
					System.out.println(str);
					continue;
				}

				ab.delete(index);

				break;
			case 5: // ��ü ����ϱ�
				// �ּҷ��� ����� �� ��¹� �ۼ�
				if (ab.addindex == 0)
					System.out.println("�ּҷ��� ������ϴ�.");
				else
					for (int i = 0; i < ab.addindex; i++) {
						System.out.println(ab.getPerson(i));
					}

				break;
			case 6:
				// �迭 ���Ϸ� ����
				try {
					// ���Ͽ� �迭 ������ �Է��� out ��ü ���� - ���� ������ ���� BufferedOutputStream ����
					out = new DataOutputStream(new FileOutputStream("Person.dat"));
					// AddressBook Ŭ�������� writeFile �Լ� ����
					ab.writeFile(out);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("���Ϸ� ����� �� �����ϴ�.");
				} finally {
					try {
						// out ������ ����
						out.close();
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					} catch (Exception e) {
					}
				}
				break;

			case 7: // ���α׷� ����
				break;
			}
			// ���α׷� ����� ���
			if (answer == 7) {
				System.out.println("�ý����� ����˴ϴ�.");
				break;
			}
		}
	}
}