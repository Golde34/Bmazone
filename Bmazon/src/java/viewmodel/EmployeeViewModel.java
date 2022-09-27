/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EmployeeService;

/**
 *
 * @author nguye
 */
public class EmployeeViewModel {

    EmployeeService employeeService = new EmployeeService();

    public void employeeController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("topupresponse")) {
            employeeService.serviceTopUpResponse(service, request, response);
        }
        if (service.equalsIgnoreCase("pagingtopupresponse")) {
            employeeService.servicePagingTopUpResponse(service, request, response);
        }
        if (service.equalsIgnoreCase("showpagetopupresponse")) {
            employeeService.serviceShowPageTopUpResponse(service, request, response);
        }
        if (service.equalsIgnoreCase("accepttopup")) {
            employeeService.serviceAcceptTopUpRequest(service, request, response);
        }
        if (service.equalsIgnoreCase("denytopup")) {
            employeeService.serviceDenyTopUpRequest(service, request, response);
        }
    }
}
