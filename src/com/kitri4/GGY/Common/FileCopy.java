package com.kitri4.GGY.Common;

import java.io.*;

public class FileCopy {
	public static int copy(String srcPath, String destPath) throws FileNotFoundException {
		int count = 0;
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);

		// ���� ���� ����
		if (!srcFile.exists()) {
			System.out.println("���ϸ��� ���� ����");
			// throw new FileNotFoundException("������ �������� �ʽ��ϴ�.");
		}

		// ����üũ �� ����
		if (srcFile.isFile()) {
			copyFile(srcFile, destFile);
			// ���丮 üũ �� ����
		} else if (srcFile.isDirectory()) {
			copyDirectory(srcFile, destFile);
		}

		return count;
	}

	public static void copyFile(File source, File dest) {
		long startTime = System.currentTimeMillis();

		int count = 0;
		long totalSize = 0;
		byte[] b = new byte[128];

		FileInputStream in = null;
		FileOutputStream out = null;
		// ��������� ���� ���� ��Ʈ�� ���
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		try {
			in = new FileInputStream(source);
			bin = new BufferedInputStream(in);

			out = new FileOutputStream(dest);
			bout = new BufferedOutputStream(out);
			while ((count = bin.read(b)) != -1) {
				bout.write(b, 0, count);
				totalSize += count;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {// ��Ʈ�� close �ʼ�
			try {
				if (bout != null) {
					bout.close();
				}
				if (out != null) {
					out.close();
				}
				if (bin != null) {
					bin.close();
				}
				if (in != null) {
					in.close();
				}

			} catch (IOException r) {
				// TODO: handle exception
				System.out.println("close ���� ���� �߻�.");
			}
		}
		// ���� �ð� üũ
		StringBuffer time = new StringBuffer("�ҿ�ð� : ");
		time.append(System.currentTimeMillis() - startTime);
		time.append(",FileSize : " + totalSize);
		System.out.println(time);
	}

	// ���丮 ���� -> ���Ϻ���
	public static void copyDirectory(File source, File dest) {
		long startTime = System.currentTimeMillis();

		if (!source.exists() || !dest.isDirectory()) {
			throw new IllegalArgumentException("���丮 ����");
		}

		dest.mkdirs();// ����

		File[] fileList = source.listFiles();// ������ ���ϸ���Ʈ ��������

		for (int i = 0; i < fileList.length; i++) {
			File sourceFile = fileList[i];

			File destFile = new File(dest, sourceFile.getName());
			copyFile(sourceFile, destFile);// copyFile�޼ҵ� ����
		}

		// ���� �ð� üũ
		StringBuffer time = new StringBuffer("�ҿ�ð� : ");
		time.append(System.currentTimeMillis() - startTime);
		time.append(",File Total List : " + fileList.length);
		System.out.println(time);
	}

}
