package com.example.demo;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class AiService {
    public String chat(String prompt) {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{
                    "python3", "aiRequest.py",
                    "java, spring", "test"  // You might want to pass actual values here
            });

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return reader.readLine();
        } catch (Exception e) {
            return "Failed to generate recommendation";
        }
    }
}
