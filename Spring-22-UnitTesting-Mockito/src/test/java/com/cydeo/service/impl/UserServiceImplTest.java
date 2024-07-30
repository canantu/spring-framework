package com.cydeo.service.impl;

import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepositoryMock;
    @InjectMocks
    UserServiceImpl userService;


    @Test
    void deleteByUserName_test(){
        userService.deleteByUserName("mikesmith@cydeo.com");

        verify(userRepositoryMock).deleteByUserName("mikesmith@cydeo.com");
        verify(userRepositoryMock, atLeastOnce()).deleteByUserName("mikesmith@cydeo.com");
        //verify(userRepositoryMock, atLeast(5)).deleteByUserName("mikesmith@cydeo.com");
       // verify(userRepositoryMock, atMost(5)).deleteByUserName("mikesmith@cydeo.com");
       // verify(userRepositoryMock, atMostOnce()).deleteByUserName("mikesmith@cydeo.com");
     //   verify(userRepositoryMock, times(2)).deleteByUserName("mikesmith@cydeo.com");
       // if we need to run the method more than one

        InOrder inOrder = inOrder(userRepositoryMock);
        verify(userRepositoryMock).deleteByUserName("mikesmith@cydeo.com");
        inOrder.verify(userRepositoryMock).findAll();





    }

}