package com.kitri4.GGY.Common;

import java.io.*;

public class FileCopy {
	public static int copy(String srcPath, String destPath) throws FileNotFoundException {
		int count = 0;
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);

		// 파일 존재 유무
		if (!srcFile.exists()) {
			System.out.println("파일명이 존재 ㅌㅌ");
			// throw new FileNotFoundException("파일이 존재하지 않습니다.");
		}

		// 파일체크 및 복사
		if (srcFile.isFile()) {
			copyFile(srcFile, destFile);
			// 디렉토리 체크 및 복사
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
		// 성능향상을 위한 버퍼 스트림 사용
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
		} finally {// 스트림 close 필수
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
				System.out.println("close 도중 에러 발생.");
			}
		}
		// 복사 시간 체크
		StringBuffer time = new StringBuffer("소요시간 : ");
		time.append(System.currentTimeMillis() - startTime);
		time.append(",FileSize : " + totalSize);
		System.out.println(time);
	}

	// 디렉토리 생성 -> 파일복사
	public static void copyDirectory(File source, File dest) {
		long startTime = System.currentTimeMillis();

		if (!source.exists() || !dest.isDirectory()) {
			throw new IllegalArgumentException("디렉토리 없음");
		}

		dest.mkdirs();// 생성

		File[] fileList = source.listFiles();// 내부의 파일리스트 가져오기

		for (int i = 0; i < fileList.length; i++) {
			File sourceFile = fileList[i];

			File destFile = new File(dest, sourceFile.getName());
			copyFile(sourceFile, destFile);// copyFile메소드 실행
		}

		// 복사 시간 체크
		StringBuffer time = new StringBuffer("소요시간 : ");
		time.append(System.currentTimeMillis() - startTime);
		time.append(",File Total List : " + fileList.length);
		System.out.println(time);
	}

}
