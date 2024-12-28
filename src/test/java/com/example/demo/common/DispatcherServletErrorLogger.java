package com.example.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatcherServletErrorLogger {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServletErrorLogger.class);
    private static final String LOG_FILE_PATH = "logs/app.log"; // 로그 파일 경로 설정

    public static void main(String[] args) {
        List<String[]> errorLogSummary = filterDispatcherServletErrors();
        printErrorLogTable(errorLogSummary);
    }

    public static List<String[]> filterDispatcherServletErrors() {
        List<String[]> errorSummary = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("DispatcherServlet") && line.contains("ERROR")) {
                    // 날짜/시간, 요청 방식(HTTP 메서드), 에러 메시지 추출
                    String dateTime = extractDateTime(line);
                    String httpMethod = extractHttpMethod(line);
                    String errorMessage = extractErrorMessage(line);

                    // 요약 정보 추가
                    errorSummary.add(new String[]{dateTime, httpMethod, errorMessage});
                }
            }
        } catch (IOException e) {
            logger.error("Error reading log file: {}", e.getMessage());
        }
        return errorSummary;
    }

    private static String extractDateTime(String logLine) {
        try {
            String[] parts = logLine.split(" ");
            String date = parts[0]; // 날짜
            String time = parts[1]; // 시간
            // 요일 추가
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateObj = sdf.parse(date + " " + time);
            SimpleDateFormat dayFormat = new SimpleDateFormat("E HH:mm:ss"); // E는 요일
            return dayFormat.format(dateObj);
        } catch (Exception e) {
            logger.error("Failed to parse date and time: {}", e.getMessage());
            return "Unknown Date/Time";
        }
    }

    private static String extractHttpMethod(String logLine) {
        try {
            // 요청 방식 추출: "GET" 또는 "POST" 등의 HTTP 메서드 탐색
            if (logLine.contains("GET")) return "GET";
            if (logLine.contains("POST")) return "POST";
            if (logLine.contains("PUT")) return "PUT";
            if (logLine.contains("DELETE")) return "DELETE";
            return "Unknown Method";
        } catch (Exception e) {
            return "Unknown Method";
        }
    }

    private static String extractErrorMessage(String logLine) {
        int errorIndex = logLine.indexOf("ERROR");
        return errorIndex != -1 ? logLine.substring(errorIndex + 6).trim() : "Unknown Error";
    }

    private static void printErrorLogTable(List<String[]> errorLogSummary) {
        // 표 헤더 출력
        System.out.println("+----------------------+-------------+-----------------------------------+");
        System.out.println("|       요일/시간       | 요청 방식   |              에러 메시지           |");
        System.out.println("+----------------------+-------------+-----------------------------------+");

        // 에러 로그 출력
        for (String[] error : errorLogSummary) {
            String dateTime = String.format("%-20s", error[0]); // 요일/시간
            String httpMethod = String.format("%-11s", error[1]); // HTTP 요청 방식
            String errorMessage = String.format("%-33s", error[2]); // 에러 메시지
            System.out.println("| " + dateTime + " | " + httpMethod + " | " + errorMessage + " |");
        }

        // 표 하단 출력
        System.out.println("+----------------------+-------------+-----------------------------------+");
    }
}

//+----------------------+-------------+-----------------------------------+
//        |       요일/시간       | 요청 방식   |              에러 메시지           |
//        +----------------------+-------------+-----------------------------------+
//        | 일 00:38:08           | GET         | dispatch for GET "/error", parameters={} |
//        | 일 00:38:08           | Unknown Method | dispatch, status 404              |
//        | 일 09:34:02           | GET         | dispatch for GET "/error", parameters={} |
//        | 일 09:34:02           | Unknown Method | dispatch, status 404              |
//        +----------------------+-------------+-----------------------------------+