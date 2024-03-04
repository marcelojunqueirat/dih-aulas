package br.senai.sc.tasksapipatterns.controller;

import br.senai.sc.tasksapipatterns.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller exception handler para tratamento de erros
 */

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AssignmentIsNotEnableForAssigneesException.class)
    public ResponseEntity<ProblemDetail> handleAssignmentIsNotEnableForAssigneesException(AssignmentIsNotEnableForAssigneesException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(InvalidNotificationTypeException.class)
    public ResponseEntity<ProblemDetail> handleInvalidNotificationTypeException(InvalidNotificationTypeException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(InvalidReportTypeException.class)
    public ResponseEntity<ProblemDetail> handleInvalidReportTypeException(InvalidReportTypeException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(PersonAlreadyAssignedOnAssignmentException.class)
    public ResponseEntity<ProblemDetail> handlePersonAlreadyAssignedOnAssignmentException(PersonAlreadyAssignedOnAssignmentException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(PersonIsAlreadyDisabledException.class)
    public ResponseEntity<ProblemDetail> handlePersonIsAlreadyDisabledException(PersonIsAlreadyDisabledException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(InvalidPermissionException.class)
    public ResponseEntity<ProblemDetail> handleInvalidPermissionException(InvalidPermissionException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(problemDetail);
    }

    @ExceptionHandler(AssignmentNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleAssignmentNotFoundException(AssignmentNotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ProblemDetail> handlePersonNotFoundException(PersonNotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }
}
