package com.alexb.empconsumer.listener;

import com.alexb.empconsumer.dto.EmployeeDto;
import com.alexb.empconsumer.model.Department;
import com.alexb.empconsumer.model.Employee;
import com.alexb.empconsumer.repository.DeptRepository;
import com.alexb.empconsumer.repository.EmpRepository;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmpListener {

    private final EmpRepository empRepository;

    private final DeptRepository deptRepository;

    @RabbitListener(queues = "EmpQueue", errorHandler = "rabbitListenerErrorHandler")
    @Transactional
    public void processEmployee(EmployeeDto employeeDto,
                                Channel channel,
                                @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        if (employeeDto.getName().equalsIgnoreCase("Unknown")) {
            channel.basicNack(tag, false, false);
            return;
        }
        Department department = deptRepository.getOne(employeeDto.getDepartmentNumber());
        Employee employee = convertToEntity(employeeDto);

        employee.setDepartment(department);
        empRepository.save(employee);

        channel.basicAck(tag, false);
    }

    private Employee convertToEntity(EmployeeDto employeeDto) {
        return Employee.builder()
                .name(employeeDto.getName())
                .commission(employeeDto.getCommission())
                .hireDate(employeeDto.getHideDate())
                .job(employeeDto.getJob())
                .salary(employeeDto.getSalary())
                .managerId(employeeDto.getManagerId())
                .build();
    }

}
