package com.customerApp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorInfo {
	private LocalDateTime timestamp;
	private String status;
	private String error;
	private String message;
}
