package AddressBook;

import java.io.*;

public class AddressBook {
	// ������ �Լ����ٰ� �ܺο��� ũ�� ���ϴ� �ɷ�
	private Person[] person;
	int addindex = 0; // �ο����� �߰��� �� �ʿ��� �ε��� ����

	// Person �迭�� ���� �Ҵ�
	public AddressBook(int Number) {
		person = new Person[Number];

		DataInputStream in = null;

		File file = new File("Person.dat");
		try {
			// ������ �����ϴ��� �˻�!
			// �����Ѵٸ�?!
			if (!file.exists()) {
				file.createNewFile();
			}
			// Person.dat�� ����Ǿ��ִ� �����͸� �о���� in ��ü ����
			in = new DataInputStream(new FileInputStream("Person.dat"));
			readFile(in);


		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// in ������ ����
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// Person �迭 getter �Լ�
	public Person getPerson(int index) {
		return person[index];
	}

	// �ּҷ� �ο��� �߰��ϱ� ���ؼ� Person p ��ü�� ������ �Է� �޾Ƽ� �߰�
	public void add(Person p) throws Exception {
		if (addindex != person.length)
			// ó���� �Է� �Ŀ��� �߰��� �Է��� ������� �ε��� ���
			person[addindex++] = p;
		else
			// �뷮 �ʰ��Ǿ��� �� �ͼ��� �߼�
			throw new Exception("�뷮�� �����մϴ�.");
	}

	// ã�� ��� �̸��� �Է��ϸ� �� ��° �ε����� �ִ��� ��ȯ
	public int find(String key) throws Exception {
		for (int i = 0; i < addindex; i++) {
			// i �迭�� name ������ key�� ���ٸ�?!
			if (getPerson(i).getName().equals(key)) {
				return i; // �ش� �ε��� �ٷ� ��ȯ
			}
		}
		// key�� �������� ������
		throw new Exception("�ش� �ּҷ��� �����ϴ�.");

	}

	// ������ ����(index)�� �Է��ϸ� Person P���ٰ� ������ �޾Ƽ� �迭�� �Է�
	public void edit(int index, Person p) {
		// index��° �迭�� ��ü p �־ ����
		person[index] = p;
	}

	// �����ҹ�°(index)�� �Է��ϸ� �ش� �迭 ����
	public void delete(int index) {
		// �����Ϸ��� index�� ù��°~������ �� �ε��� �� ��
		// �����Ϸ��� �ε������� ������ �� �ε������� ������ ��ĭ�� ����
		for (int i = index; i < addindex - 1; i++) {
			person[i] = person[i + 1];
		}
		// �����Ϸ��� index�� ������ �ε��� �� ��
		// �� ������ �ε��� ����
		addindex--;
	}

	// ���Ͽ��ٰ� person ��ü�� �Է��ϰ� �ϴ� �Լ�
	public void writeFile(DataOutputStream out) throws IOException {
		out.writeInt(addindex);
		for (int i = 0; i < addindex; i++) {
			person[i].WriteMyFile(out);
		}
	}

	public void readFile(DataInputStream in) throws Exception {
		// ���Ͽ��� ����� ��ü �� ���� �ҷ��ͼ� addindex�� ����
		addindex = in.readInt();

		// ����� ��ü �� ��ŭ for���� ������
		for (int i = 0; i < addindex; i++) {
			// ���ο� Person ��ü ���� �� readMyFile���� ��� �����ϱ�
			Person p = new Person();
			p.readMyFile(in);
			// �ҷ��� ���� �Ҵ�� p�� person �迭 �ȿ��ٰ� ������� ����ֱ�
			person[i] = p;

		}
	}
}